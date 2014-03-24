function convertText(command, converter) {
    var props = ['command', 'target', 'value'];
    for (var i = 0; i < props.length; i++) {
        var prop = props[i];
        command[prop] = converter(command[prop]);
    }
}

/**
 * Parse source and update TestCase. Throw an exception if any error occurs.
 *
 * @param testCase TestCase to update
 * @param source The source to parse
 */
function basicHtmlParse(testCase, source) {
    var commandRegexp = new RegExp(options.commandLoadPattern, 'i');
    var commentRegexp = new RegExp(options.commentLoadPattern, 'i');
    var commandOrCommentRegexp = new RegExp("((" + options.commandLoadPattern + ")|(" + options.commentLoadPattern + "))", 'ig');
    var doc = source;
    var commands = [];
    var commandFound = false;
    var lastIndex;
    while (true) {
        ////log.debug("doc=" + doc + ", commandRegexp=" + commandRegexp);
        lastIndex = commandOrCommentRegexp.lastIndex;
        var docResult = commandOrCommentRegexp.exec(doc);
        if (docResult) {
            if (docResult[2]) { // command
                var command = new Command();
                command.skip = docResult.index - lastIndex;
                command.index = docResult.index;
                var result = commandRegexp.exec(doc.substring(lastIndex));
                eval(options.commandLoadScript);
                convertText(command, decodeText);
                commands.push(command);
                if (!commandFound) {
                    // remove comments before the first command or comment
                    for (var i = commands.length - 1; i >= 0; i--) {
                        if (commands[i].skip > 0) {
                            commands.splice(0, i);
                            break;
                        }
                    }
                    testCase.header = doc.substr(0, commands[0].index);
                    commandFound = true;
                }
            } else { // comment
                var comment = new Comment();
                comment.skip = docResult.index - lastIndex;
                comment.index = docResult.index;
                result = commentRegexp.exec(doc.substring(lastIndex));
                eval(options.commentLoadScript);
                commands.push(comment);
            }
        } else {
            break;
        }
    }
    if (commands.length > 0) {
        testCase.footer = doc.substring(lastIndex);
        //log.debug("header=" + testCase.header);
        //log.debug("footer=" + testCase.footer);
        if (testCase.header &&
            /<link\s+rel="selenium\.base"\s+href="(.*)"/.test(testCase.header)) {
            testCase.baseURL = decodeURI(RegExp.$1);
        }
        ////log.debug("commands.length=" + commands.length);
        testCase.commands = commands;
    } else {
        //Samit: Fix: Atleast try to allow empty test cases, before screaming murder
        //Note: This implementation will work with empty test cases saved with this formatter only
        var templateVars = matchTemplateAndExtractVars(source, options.testTemplate);
        if (templateVars) {
            //Since the matching has succeeded, update the test case with found variable values
            if (templateVars["baseURL"]) {
                testCase.baseURL = templateVars["baseURL"][0];
            }
            if (templateVars["commands"]) {
                testCase.header = doc.substring(0, templateVars["commands"][1]);
                testCase.footer = doc.substring(templateVars["commands"][1]);
                //log.debug("header=" + testCase.header);
                //log.debug("footer=" + testCase.footer);
            }
            testCase.commands = commands;
        } else {
            throw "no command found";
        }
    }
}

function decodeText(text) {
    if (text == null) return "";
    text = text.replace(/<br\s*\/?>/gi, "\n");
    text = text.replace(/&(\w+);/g, function (str, p1) {
        var c = XhtmlEntities[p1];
        if (c) {
            return String.fromCharCode(c);
        } else {
            return str;
        }
    });
    text = text.replace(/&#(\d+);/g, function (str, p1) {
        return String.fromCharCode(parseInt(p1));
    });
    text = text.replace(/&#x([0-9a-f]+);/gi, function (str, p1) {
        return String.fromCharCode(parseInt(p1, 16));
    });
    text = text.replace(/ +/g, " "); // truncate multiple spaces to single space
    text = text.replace(/\xA0/g, " "); // treat nbsp as space

    text = text.replace(/^\$\{/g, '');
    text = text.replace(/}/g, '');

    if ('true' == options.escapeDollar) {
        text = text.replace(/([^\\])\$\{/g, '$1$$$${'); // replace [^\]${...} with $${...}
        text = text.replace(/^\$\{/g, '$$$${'); // replace ^${...} with $${...}
        text = text.replace(/\\\$\{/g, '$${'); // replace \${...} with ${...}
    }
    return text;
}


