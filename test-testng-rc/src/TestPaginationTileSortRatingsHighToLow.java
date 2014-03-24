



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationTileSortRatingsHighToLow extends BaseTestCase {
	@Test public void testPaginationTileSortRatingsHighToLow() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pens/ballpoint-pens");
		selenium.click("link=Tile");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=ipp", "label=90");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=sort", "label=Ratings (High-Low)");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='browseModWrapper']"));
	}
}
