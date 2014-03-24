



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestSearchToBreadCrumb extends BaseTestCase {
	@Test public void testSearchToBreadCrumb() throws Exception {
		selenium.open("/");
		selenium.type("id=freeText", "pen");
		selenium.click("css=input[name=\"search\"]");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Ballpoint Pens')])[2]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=OFFICE SUPPLIES");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Pens, Pencils, & Markers')])[4]");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Pens')])[14]");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Ballpoint Pens')])[2]");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
	}
}
