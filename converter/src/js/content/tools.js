/*
 * Copyright 2005 Shinya Kasatani
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

if (SeleniumIDE && SeleniumIDE.Preferences) {
    Preferences = SeleniumIDE.Preferences;
} else {
    // Preferences is not available when called from xlator
    Preferences = {
        getString:function (name, defaultValue) {
            return defaultValue;
        }
    };
}

function exactMatchPattern(string) {
    if (string != null && (string.match(/^\w*:/) || string.indexOf('?') >= 0 || string.indexOf('*') >= 0)) {
        return "exact:" + string;
    } else {
        return string;
    }
}

function LineReader(text) {
    this.text = text;
}

LineReader.prototype.read = function () {
    if (this.text.length > 0) {
        var line = /.*(\r\n|\r|\n)?/.exec(this.text)[0];
        this.text = this.text.substr(line.length);
        line = line.replace(/\r?\n?$/, '');
        return line;
    } else {
        return null;
    }
};

var StringUtils = {};

StringUtils.underscore = function (text) {
    return text.replace(/[A-Z]/g, function (str) {
        return '_' + str.toLowerCase();
    });
};

String.prototype.startsWith = function (str) {
    return (this.match("^" + str) == str)
};

if (typeof(String.prototype.trim) === "undefined") {
    String.prototype.trim = function () {
        return String(this).replace(/^\s+|\s+$/g, '');
    };
}

function Message(key, arg) {
    var strings = window.document.getElementById("strings");
    if (strings) {
        var message = strings.getString(key);
        if (arg) {
            message = message.replace(/%/, arg);
        }
        return message;
    } else {
        return key;
    }
}


/**
 * Returns the string with angle brackets and ampersands escaped as HTML
 * entities. This is a cleaner implementation than the escapeHTML() methods
 * defined by both the prototype and scriptaculous frameworks as it does not
 * rely on the presence of a document object which can be manipulated.
 */
String.prototype.escapeHTML2 = function () {
    return this
        .replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;');
};

String.prototype.formatAsHTML = function () {
    return this.replace(/(?:\r\n|\r|\n)/g, '<br />');
};

Array.prototype["delete"] = function (value) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == value) {
            this.splice(i, 1);
            return true;
        }
    }
    return false;
};

// Samit: Ref: Split the fn to allow both objects of a class as well as the class itself to be notifiable as required
function observable(clazz) {
    classObservable(clazz.prototype);
}

function classObservable(clazz) {
    clazz.addObserver = function (observer) {
        if (!this.observers) this.observers = [];
        this.observers.push(observer);
    };

    clazz.removeObserver = function (observer) {
        if (!this.observers) return;
        this.observers["delete"](observer);
    };

    clazz.notify = function (event) {
        if (!this.observers) return;
        var args = [];
        var i;
        for (i = 1; i < arguments.length; i++) {
            args.push(arguments[i]);
        }
        for (i = 0; i < this.observers.length; i++) {
            var observer = this.observers[i];
            if (observer[event]) {
                try {
                    observer[event].apply(observer, args);
                } catch (e) {
                    //continue with the rest even if one observer fails
                }
            }
        }
    };
}

function defineEnum(clazz, names) {
    var map = {};
    for (var i = 0; i < names.length; i++) {
        clazz[names[i]] = i;
        map[i] = names[i];
    }
    return map;
}

function $(id) {
    return document.getElementById(id);
}
