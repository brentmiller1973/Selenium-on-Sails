import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.thoughtworks.selenium.DefaultSelenium;

public class BaseTestCase extends SeleneseTestNgHelper {

    protected static DefaultSelenium selenium;
    private static String TIMEOUT_PERIOD = "10000";
    private String baseUrl = "";

    @BeforeSuite(alwaysRun = true)
    public void setUp() {

        Properties properties = new Properties();
        int defaultPort = 4444;
        try {
            properties.load(new FileInputStream("build.properties"));
            baseUrl = properties.getProperty("base.url");
            String tempUrl = System.getProperty("baseUrl");
            if (tempUrl != null) {
                baseUrl = tempUrl;
            }
            String tmpPort = System.getProperty("port");
            if (tmpPort != null) {
                defaultPort = Integer.valueOf(tmpPort).intValue();
            }
        } catch (IOException e) {
        }
        selenium = new DefaultSelenium("localhost", defaultPort, "*firefox3", baseUrl);
        selenium.start();
        // selenium.open(baseUrl);
    }

    @AfterSuite(alwaysRun = true)
    private void stopTest() {
        selenium.stop();
    }

}