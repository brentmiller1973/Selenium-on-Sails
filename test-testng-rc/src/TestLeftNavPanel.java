



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestLeftNavPanel extends BaseTestCase {
	@Test public void testLeftNavPanel() throws Exception {
		selenium.open("/");
		selenium.click("css=div.topleveldisplaydiv");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Bags & Cases')])[2]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Briefcases");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=McKleinUSA Scottsdale Leather Flapover Double Compartment Briefcase (Black)");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("23312602"));
	}
}
