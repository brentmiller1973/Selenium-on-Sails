



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationSortProductAtoZ extends BaseTestCase {
	@Test public void testPaginationSortProductAtoZ() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pencils/colored-pencils");
		selenium.click("link=View All");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=sort", "label=Products (A-Z)");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
	}
}
