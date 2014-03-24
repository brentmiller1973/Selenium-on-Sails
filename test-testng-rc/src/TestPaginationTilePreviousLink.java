



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationTilePreviousLink extends BaseTestCase {
	@Test public void testPaginationTilePreviousLink() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pencils/mechanical-pencils");
		selenium.click("link=4");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Tile");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
		selenium.click("link=PREVIOUS");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
		selenium.click("link=PREVIOUS");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
		selenium.click("link=PREVIOUS");
		selenium.waitForPageToLoad("30000");
	}
}
