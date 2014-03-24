



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestCategoryClickSeeAll extends BaseTestCase {
	@Test public void testCategoryClickSeeAll() throws Exception {
		selenium.open("/");
		selenium.click("css=div.topleveldisplaydiv");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Pens, Pencils, & Markers')])[4]");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Pens')])[14]");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Ballpoint Pens')])[2]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=See All Brand");
		selenium.click("link=See All Quantity");
		selenium.click("link=See Less Brand");
		selenium.click("link=See Less Quantity");
	}
}
