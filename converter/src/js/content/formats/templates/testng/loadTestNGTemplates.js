var testNGHeaderTemplate = "." + tools.getPathSeperator() + "src" + tools.getPathSeperator() + "js" +
    tools.getPathSeperator() + "content" + tools.getPathSeperator() + "formats" +
    tools.getPathSeperator() + "templates" + tools.getPathSeperator() + "testng" +
    tools.getPathSeperator() + "header.template";

var testNGFooterTemplate = "." + tools.getPathSeperator() + "src" + tools.getPathSeperator() + "js" +
    tools.getPathSeperator() + "content" + tools.getPathSeperator() + "formats" +
    tools.getPathSeperator() + "templates" + tools.getPathSeperator() + "testng" +
    tools.getPathSeperator() + "footer.template";

options.header = tools.fileReader(testNGHeaderTemplate);
options.header += "\n";
options.footer = tools.fileReader(testNGFooterTemplate);

if (options.usePackageName) {
    options.header = "package ${packageName};\n\n" + options.header;
}