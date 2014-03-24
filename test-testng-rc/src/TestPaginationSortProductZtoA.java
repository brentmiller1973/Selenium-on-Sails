



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationSortProductZtoA extends BaseTestCase {
	@Test public void testPaginationSortProductZtoA() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pencils/colored-pencils");
		selenium.select("name=sort", "label=Products (Z-A)");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=View All");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
	}
}
