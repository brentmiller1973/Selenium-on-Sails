var javaRCHeaderTemplate = "." + tools.getPathSeperator() + "src" + tools.getPathSeperator() + "js" +
    tools.getPathSeperator() + "content" + tools.getPathSeperator() + "formats" +
    tools.getPathSeperator() + "templates" + tools.getPathSeperator() + "java_rc" +
    tools.getPathSeperator() + "header.template";

var javaRCFooterTemplate = "." + tools.getPathSeperator() + "src" + tools.getPathSeperator() + "js" +
    tools.getPathSeperator() + "content" + tools.getPathSeperator() + "formats" +
    tools.getPathSeperator() + "templates" + tools.getPathSeperator() + "java_rc" +
    tools.getPathSeperator() + "footer.template";

options.header = tools.fileReader(javaRCHeaderTemplate);
options.header += "\n";
options.footer = tools.fileReader(javaRCFooterTemplate);

if (options.usePackageName) {
    options.header = "package ${packageName};\n\n" + options.header;
}