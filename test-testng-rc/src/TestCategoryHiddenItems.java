



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestCategoryHiddenItems extends BaseTestCase {
	@Test public void testCategoryHiddenItems() throws Exception {
		selenium.open("/");
		selenium.click("css=div.topleveldisplay");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Pens, Pencils, & Markers')])[4]");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Pens')])[14]");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Ballpoint Pens')])[2]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=See All Brand");
		verifyTrue(selenium.isElementPresent("//div[@class='facetContainerContent']/div/label[@class='facetLabel facetLabelSelector']"));
	}
}
