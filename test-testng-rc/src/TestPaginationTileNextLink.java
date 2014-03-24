



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationTileNextLink extends BaseTestCase {
	@Test public void testPaginationTileNextLink() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pens/ballpoint-pens");
		selenium.click("link=Tile");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
		selenium.click("link=Next");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
		selenium.click("link=Next");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
		selenium.click("link=Next");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
		selenium.click("link=Next");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
		selenium.click("link=Next");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
	}
}
