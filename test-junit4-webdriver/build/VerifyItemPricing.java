import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
        
public class VerifyItemPricing {

    private WebDriver driver = null;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    
    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.binary", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
        driver = null;
        String tmpDriver = System.getProperty("driver");
        
        if (tmpDriver != null) {
            if (tmpDriver.equals("firefox")) {
                driver = new FirefoxDriver();
            } else if (tmpDriver.equals("ie")) {
                driver = new InternetExplorerDriver();
            } else if (tmpDriver.equals("chrome")) {
                driver = new ChromeDriver();
            } else {
                String javascript = System.getProperty("javascript");
                boolean enabledJavascript = false;
                if(javascript != null && javascript.equals("true")) {
                    enabledJavascript = true;
                }
                driver = new HtmlUnitDriver(enabledJavascript);
            }
        }
        
        if(driver == null) {
            driver = new HtmlUnitDriver();
        }
        
        baseUrl = "http://staging1";
        String tempUrl = System.getProperty("baseUrl");
        
        if(tempUrl != null) {
            baseUrl  = tempUrl;
        }
        
        String timeout = System.getProperty("timeout");
        int defaultTimeOut = 20;
        
        if(timeout != null) {
            defaultTimeOut = Integer.parseInt(timeout);
        }
        
        driver.manage().timeouts().implicitlyWait(defaultTimeOut, TimeUnit.SECONDS);
    }
    
    @Test
    public void testVerifyItemPricing() throws Exception {
		driver.get(baseUrl + "/office-supplies/paper/copy-multipurpose-paper/product-ARS21008");
		String price = driver.findElement(By.xpath("//div[@id='skuItemDisplay']/table/tbody/tr[5]/td[7]")).getText();
		driver.findElement(By.id("quantity21403152")).clear();
		driver.findElement(By.id("quantity21403152")).sendKeys("1");
		driver.findElement(By.xpath("//form[@id='SkuListingForm']/div/div/a/span")).click();
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys("60540");
		driver.findElement(By.xpath("//form[@id='model']/div/div[2]/div/div/div[2]/a/span")).click();
		driver.findElement(By.cssSelector("a > b")).click();
		try {
			assertEquals(price, driver.findElement(By.cssSelector("div.summaryValue > ul > li.bold")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (! "".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
        
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
}