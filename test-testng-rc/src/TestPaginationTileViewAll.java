



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationTileViewAll extends BaseTestCase {
	@Test public void testPaginationTileViewAll() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pens/environmentally-preferable-writing-instruments");
		selenium.click("link=View All");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Tile");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
	}
}
