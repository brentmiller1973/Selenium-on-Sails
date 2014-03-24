



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationBottomPreviousLink extends BaseTestCase {
	@Test public void testPaginationBottomPreviousLink() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pens/ballpoint-pens");
		selenium.select("name=sort", "label=Products (A-Z)");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'5')])[2]");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
		selenium.click("css=div.prodListBottom.no_bg > div.prodListPagination.clearfix > div.page > a");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
		selenium.click("css=div.prodListBottom.no_bg > div.prodListPagination.clearfix > div.page > a");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
		selenium.click("css=div.prodListBottom.no_bg > div.prodListPagination.clearfix > div.page > a");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
		selenium.click("css=div.prodListBottom.no_bg > div.prodListPagination.clearfix > div.page > a");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isElementPresent("//div[@class='prodListContent']"));
		selenium.click("xpath=(//a[contains(text(),'5')])[2]");
		selenium.waitForPageToLoad("30000");
	}
}
