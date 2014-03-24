



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationBottomNextLink extends BaseTestCase {
	@Test public void testPaginationBottomNextLink() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pens/ballpoint-pens");
		selenium.select("name=sort", "label=Products (A-Z)");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
		selenium.click("xpath=(//a[contains(text(),'Next')])[2]");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
		selenium.click("xpath=(//a[contains(text(),'Next')])[2]");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
		selenium.click("xpath=(//a[contains(text(),'Next')])[2]");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
		selenium.click("xpath=(//a[contains(text(),'Next')])[2]");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
	}
}
