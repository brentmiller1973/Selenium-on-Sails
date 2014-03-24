



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestLeftNavToImageClick extends BaseTestCase {
	@Test public void testLeftNavToImageClick() throws Exception {
		selenium.open("/");
		selenium.click("css=div.topleveldisplaydiv");
		selenium.waitForPageToLoad("30000");
		selenium.click("//img[@alt='Bags & Cases']");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@class='productImage']/a/img[@alt='Briefcases']");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=McKleinUSA Scottsdale Leather Flapover Double Compartment Briefcase (Black)");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("23312602"));
	}
}
