



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestDropDownToLink extends BaseTestCase {
	@Test public void testDropDownToLink() throws Exception {
		selenium.open("/");
		selenium.click("link=Bags & Cases");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Briefcases");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=McKleinUSA Scottsdale Leather Flapover Double Compartment Briefcase (Black)");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("23312602"));
	}
}
