



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationViewAll extends BaseTestCase {
	@Test public void testPaginationViewAll() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/markers/art-markers");
		selenium.click("link=View All");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
	}
}
