/*
 * Format for Selenium Remote Control Java client (TestNG)
 */

//var subScriptLoader = Components.classes["@mozilla.org/moz/jssubscript-loader;1"].getService(Components.interfaces.mozIJSSubScriptLoader);
//subScriptLoader.loadSubScript('chrome://java-formatters/content/formats/java-rc.js', this);

options.name = "java-rc-testng";

// TestNG reverses the order of assert functions
Equals.prototype.assert = function() {
	return "assertEquals(" + this.e2.toString() + ", " + this.e1.toString() + ");";
};

Equals.prototype.verify = function() {
	return "verifyEquals(" + this.e2.toString() + ", " + this.e1.toString() + ");";
};


function defaultExtension() {
  return this.options.defaultExtension;
}

options.configForm =
	'<description>Variable for Selenium instance</description>' +
	'<textbox id="options_receiver" />' +
	'<description>Package</description>' +
	'<textbox id="options_packageName" />' +
	'<description>Superclass</description>' +
	'<textbox id="options_superClass" />';