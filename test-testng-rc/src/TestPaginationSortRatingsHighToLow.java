



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationSortRatingsHighToLow extends BaseTestCase {
	@Test public void testPaginationSortRatingsHighToLow() throws Exception {
		selenium.open("/office-supplies/arts-crafts-supplies/arts-crafts-paper");
		selenium.select("name=sort", "label=Ratings (Low-High)");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=View All");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
	}
}
