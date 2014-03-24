



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationSortRatingsLowToHigh extends BaseTestCase {
	@Test public void testPaginationSortRatingsLowToHigh() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pencils/colored-pencils");
		selenium.click("link=View All");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=sort", "label=Ratings (Low-High)");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
	}
}
