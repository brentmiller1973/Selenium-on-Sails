



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationSortHighToLow extends BaseTestCase {
	@Test public void testPaginationSortHighToLow() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pens/ballpoint-pens");
		selenium.select("name=ipp", "label=90");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=sort", "label=Price (High-Low)");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
	}
}
