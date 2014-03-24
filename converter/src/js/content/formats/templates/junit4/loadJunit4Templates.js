var junitHeaderTemplate = "." + tools.getPathSeperator() + "src" + tools.getPathSeperator() + "js" +
    tools.getPathSeperator() + "content" + tools.getPathSeperator() + "formats" +
    tools.getPathSeperator() + "templates" + tools.getPathSeperator() + "junit4" +
    tools.getPathSeperator() + "header.template";

var junitFooterTemplate = "." + tools.getPathSeperator() + "src" + tools.getPathSeperator() + "js" +
    tools.getPathSeperator() + "content" + tools.getPathSeperator() + "formats" +
    tools.getPathSeperator() + "templates" + tools.getPathSeperator() + "junit4" +
    tools.getPathSeperator() + "footer.template";

options.header = tools.fileReader(junitHeaderTemplate);
options.header += "\n";
options.footer = tools.fileReader(junitFooterTemplate);

if (options.usePackageName) {
    options.header = "package ${packageName};\n\n" + options.header;
}