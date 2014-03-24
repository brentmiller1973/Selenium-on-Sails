



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestSearchToTile extends BaseTestCase {
	@Test public void testSearchToTile() throws Exception {
		selenium.open("/");
		selenium.type("id=freeText", "pens");
		selenium.click("css=input[name=\"search\"]");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Ballpoint Pens')])[2]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Tile");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
	}
}
