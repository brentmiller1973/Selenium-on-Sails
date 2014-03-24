load("./src/js/content/preferences.js");
load("./src/js/envjs/env.rhino.1.2.js");
load("./src/js/content/tools.js");
load("./src/js/content/misc.js");
load("./src/js/content/dom.js");
load("./src/js/content/xpath.js");
load("./src/js/content/ui-element.js");
load("./src/js/content/testCase.js");
load("./src/js/content/xhtml-entities.js");
load("./src/js/content/utilities.js");
load("./src/js/content/html_test_case_parser.js");
load("./src/js/content/formats/formatCommandOnlyAdapter.js");


var parseHtmlToJavaJUnit = function(args) {

    var testFormat = args[0];
    var testDirectory = args[1];
    var outputDirectory = args[2];
    var environment = args[3];
    var driver = args[4];
    var chromeLoc = args[5];

    if(testFormat == "junit4-webdriver"){
        print("Converting Selenium IDE HTML test cases to Junit 4 Java files...");
        load("./src/js/content/formats/options/junit_options.js");
        load("./src/js/content/formats/templates/junit4/loadJunit4Templates.js");
        load("./src/js/content/formats/webdriver.js");
        load("./src/js/content/formats/webdriver-junit4.js");

    }else if(testFormat == "testng-rc"){
        print("Converting Selenium IDE HTML test cases to TestNG Java files...");

        load("./src/js/content/formats/options/testng_options.js");
        load("./src/js/content/formats/templates/testng/loadTestNGTemplates.js");
        options.superClass = "BaseTestCase";
        load("./src/js/content/formats/remoteControl.js");
        load("./src/js/content/formats/java-rc.js");
        load("./src/js/content/formats/java-rc-testng.js");
    }

    print("testDirectory: " + testDirectory);
    print("outputDirectory: " + outputDirectory);
    print("environment: " + environment);

    var strXML = readFile("./src/js/definitions/iedoc-core-1.8.0.xml");
    var domparser = new DOMParser();
    var document = domparser.parseFromString(strXML+"", 'text/xml');
    options.apiDocuments = new Array(document);

    var testFiles = tools.directoryListing(testDirectory);

    var i;
    for (i = 0; i < testFiles.length; i++) {
        options.declaredVars = null; //This needs to be reset after each export
        print("Now converting file: " + testDirectory + tools.getPathSeperator() + testFiles[i]);

        var fileSource;
        if(!tools.isSingleFile){
            fileSource = tools.fileReader(testDirectory + tools.getPathSeperator() + testFiles[i]);
        }else{
            fileSource = tools.fileReader(testFiles[i]);
        }

        var name  = String(tools.getFileNameWithOutExt(testFiles[i]));
       // name = name.replace(/test/gi, "");
        //name = name.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});
        name = name.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1);});
       // name += "Test";


        var testCase = new TestCase(name);


        parse(testCase, fileSource);
        basicHtmlParse(testCase, fileSource);


        var commands = testCase.commands;
        print("\n" + testFiles[i] + " has the following instructions:\n");
        for (i = 0; i < commands.length; i++) {
            print(commands[i].toString() );
        }
        print("\n");

        if(environment){
            testCase.setBaseURL(environment);
        }
        if(driver){
            if(driver == "firefox"){
                options.driver = "FirefoxDriver()";
            }else if(driver == "ie"){
                options.driver = "InternetExplorerDriver()";
            }else if(driver == "chrome"){
                options.driver = "ChromeDriver(capabilities)";
                if(chromeLoc){
                    options.chromePath = chromeLoc;
                }else{
                    print("Using Chrome driver with out specifying the location to chrome.exe...");
                    print("defaulting to " + options.chromePath);
                }
            }else if(driver == "html"){
                options.driver = "HtmlUnitDriver()";
            }
        }
        print("Using the following Driver: " + options.driver);

        var source = format(testCase, name);
        print("Now writing Java file: " + outputDirectory + tools.getPathSeperator() + name + ".java");
        tools.fileWriter(source, outputDirectory + tools.getPathSeperator() + name + ".java");
    }

}(arguments);