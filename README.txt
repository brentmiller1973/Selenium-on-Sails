What is it?
------------------------
Selenium on Sails was created to make the creation and automation of Selenium test cases sail!  By utilizing the Firefox IDE
to create the test cases, Selenium on Sails will transform the test cases into auto generated unit tests in order to facilitate
test driven development that can then be applied to a continuous integration and automated environment.


Problem Definition
------------------------
There is no denying that Selenium is a very powerful tool; however, it has its limitations. On the Selenium website, it 
states there are 2 different Selenium Tools to use and asks what Selenium is appropriate for me?

The Firefox IDE: If you want to
  - create quick bug reproduction scripts
  - create scripts to aid in automation-aided exploratory testing

Selenium Webdriver: If you want to
  - create robust, browser-based regression automation
  - scale and distribute scripts across many environments
  
Well if you have ever read this and said, "that sounds great, but I don't know how to answer that because they are both 
appropriate. I wish Selenium had an efficient way to sync the 2 tools together." then Selenium on Sails is for you. 


System Justification
------------------------
This is not the first project created with the intention of transforming html test cases to something meaningful that 
can be used within an automated environment, one of the most popular projects being selenium4j. The problem with 
selenium4j and other like projects out there are:
*   They only offer one alternative testing format for converting the html scripts to. Ex. Selenium4j converts to 
    webdriver junit4.
*   Their conversion code is all custom developed. This presents a big maintainability issue because the conversion code is 
    tied to the specific version of selenium. Because browsers are constantly changing, the Selenium project must continue 
    to change to conform to the new browsers.
*   The other projects have no support for hooking the generated tests into an automated environment.


Documentation
------------------------

http://blog.activelylazy.co.uk/2011/07/09/page-objects-in-selenium-2-0/
Specification vs Implementation
There's an important difference in tests between the specification of what to test versus the implementation of how to test.

----- Selenium project overview --------
Selenium on Sails was designed to be a modular system. It contains sub modules or projects that are all self contained within
its own project.  Each of these sub projects/modules can be used or run independently of the root project. The build file 
in the root directory acts as a master build file that 
root directory
acts as a master build that 

----- converter --------
Converter is the engine behind Selenium for Sails. This project will convert html test cases into a source file. The converter 
project was created by extracting the source from the selenium firefox IDE export functionality.
Currently it only supports converting html to junit4 webdriver and testng remote control source files. 

----- test-junit-webdriver --------
Selenium project created to run selenium2 webdriver junit4 test cases. This project utilizes the converter project to auto
generate the junit4 java test cases by converting selenium IDE html test cases to junit4 java files. The selenium master
project uses the test-junit-webdriver to run selenium webdriver tests against multiple environments and test case directories.
This project is also self contained and can be run independently of this selenium master project.

----- test-testng-rc --------
Selenium project created to run selenium1 remote control testng test cases. This project utilizes the converter project to auto
generate the testng java test cases by converting selenium IDE html test cases to testng java files. The selenium master
project uses the test-testng-rc to run selenium tests against multiple environments and test case directories.
This project is also self contained and can be run independently of this selenium master project.

----- html-hot-deploy --------
Used for building new test cases. When creating a new test case, tester should save the new html test case in
the html-hot-deploy/[username] directory. In each project build file is a hot-deploy ant target. This will only 
build and test the test cases located their hot-deploy directory. Once tester is satisfied with the new test case, tester 
should move the test case to the html-test-cases directory.



----- builder-overrides --------
Contains build override files. Should a tester or environment need to override any property, the tester should run the target
create-host-file, and set their overrides properties there.
Supports the following formats to override the default build.properties.
host-${hostname}.properties
user-${user.name}.properties


By default when you run any test case, a new folder with your username should be created in the hot-deploy directory, if not the run the init target.
Currently hot-deploy should only be used for webdriver tests.

selenium.tests.order=the selenium test projects to run. This should only be used with projects that use the converter to generate the source.
hot.deploy=${basedir}/html-hot-deploy
driver=html
#htmljavascript enables javascript on the seleneium HtmlUnitDriver
htmljavascript=false
test.url=staging2.omx.com
target.env.base.dir=${seleniumbuilder}/html-test-cases
target-envs-cases=endeca=staging1,qa,qa2
#target-envs-cases=staging2=staging2.omx.com,officemax.com:qa=10.50.32.255
#target-envs-cases=staging2=staging2.omx.com,qa.officemax.com
#:qa=qa.officemax.com,localhost
#target.env.base.dir=${basedir}


#jdk properties
jdk.home=C:/Tools/Java/jdk1.6.0_30
jdk.version=1.6
jdk.fork=true
jdk.debug=on
jdk.maxmemory=512m
timeout=8

junit.haltonfailure=no
junit.printsummary=yes

#build structure properties
build.dir=${basedir}/build
classes.dir=${basedir}/classes
lib.dir=${basedir}/lib
reports.dir=${basedir}/reports
reports.dir.append.timestamp=true
reports.usefile=true

Why on Sails?
------------
Like any good project, a catchy name is better than, well for lack of a better word, a non catchy name, and there is 
nothing catchier than alliteration.  And just like the ever so popular programming frameworks, Ruby on Rails and 
Groovy on Rails/Grails, Selenium on Sails is designed for productivity.  The sole purpose of this project is to 
make the creation and automation of selenium test cases, for non-lack of a more perfect word, sail!
