



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestSearchToBreadCrumb2 extends BaseTestCase {
	@Test public void testSearchToBreadCrumb2() throws Exception {
		selenium.open("/");
		selenium.click("css=div.topleveldisplaydiv");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Pens, Pencils, & Markers')])[4]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Ballpoint Pens");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=PENS");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Ballpoint Pens')])[2]");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
	}
}
