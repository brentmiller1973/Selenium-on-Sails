function Selenium() {

}

if (!SeleniumIDE) {
    var SeleniumIDE = {};
}

SeleniumIDE.Preferences = {

    getArray:function (name) {
        var length = this.getString(name + ".length");
        if (length == null) return [];
        var value = [];
        for (var i = 0; i < length; i++) {
            value.push(this.getString(name + "." + i));
        }
        return value;
    },

    setArray:function (name, value) {
        this.setString(name + ".length", value.length);
        for (var i = 0; i < value.length; i++) {
            this.setString(name + "." + i, value[i]);
        }
    }
};

SeleniumIDE.Preferences.DEFAULT_OPTIONS = {
    encoding:"UTF-8",

    // This should be called 'userExtensionsPaths', but it is left for backward compatibility.
    userExtensionsURL:"",

    ideExtensionsPaths:"",

    rememberBaseURL:"true",

    baseURL:"",

    recordAssertTitle:"false",

    timeout:"30000",

    recordAbsoluteURL:"false",

    pluginProvidedIDEExtensions:"",

    pluginProvidedUserExtensions:"",

    pluginProvidedFormatters:"",

    plugins:"",

    showDeveloperTools:"false",

    selectedFormat:"default",

    enableExperimentalFeatures:"false",

    disableFormatChangeMsg:"false",

    currentVersion:"",

    locatorBuildersOrder:"ui,id,link,name,css,dom:name,xpath:link,xpath:img,xpath:attributes,xpath:idRelative,xpath:href,dom:index,xpath:position",

    recordOnOpen:"true"
};

