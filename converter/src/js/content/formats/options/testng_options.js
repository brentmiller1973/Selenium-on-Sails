var options = {
    lastIndent:'\t\t',
    receiver:"selenium",
    environment:"*chrome",
    packageName:"com.example.tests",
    usePackageName:false,
    superClass:"SeleneseTestNgHelper",
    indent:'tab',
    initialIndents:'2',
    defaultExtension:"java",

    remoteControl:true,
    playable:false,

    declaredVars:null, //This varibale may need to be reset back to null with each file


    commandLoadPattern:"<tr\s*[^>]*>" +
        "\\s*(<!--[\\d\\D]*?-->)?" +
        "\\s*<td\s*[^>]*>\\s*([\\w]*?)\\s*</td>" +
        "\\s*<td\s*[^>]*>([\\d\\D]*?)</td>" +
        "\\s*(<td\s*/>|<td\s*[^>]*>([\\d\\D]*?)</td>)" +
        "\\s*</tr>\\s*",

    commandLoadScript:"command.command = result[2];\n" +
        "command.target = result[3];\n" +
        "command.value = result[5] || '';\n",

    commentLoadPattern:"<!--([\\d\\D]*?)-->\\s*",

    commentLoadScript:"comment.comment = result[1];\n",

    testTemplate:'<?xml version="1.0" encoding="${encoding}"?>\n' +
        '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">\n' +
        '<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">\n' +
        '<head profile="http://selenium-ide.openqa.org/profiles/test-case">\n' +
        '<meta http-equiv="Content-Type" content="text/html; charset=${encoding}" />\n' +
        '<link rel="selenium.base" href="${baseURL}" />\n' +
        "<title>${name}</title>\n" +
        "</head>\n" +
        "<body>\n" +
        '<table cellpadding="1" cellspacing="1" border="1">\n' +
        '<thead>\n' +
        '<tr><td rowspan="1" colspan="3">${name}</td></tr>\n' +
        "</thead><tbody>\n" +
        "${commands}\n" +
        "</tbody></table>\n" +
        "</body>\n" +
        "</html>\n",

    commandTemplate:"<tr>\n" +
        "\t<td>${command.command}</td>\n" +
        "\t<td>${command.target}</td>\n" +
        "\t<td>${command.value}</td>\n" +
        "</tr>\n",

    commentTemplate:"<!--${comment.comment}-->\n",

    escapeDollar:"false",

    name:"java-rc"
};