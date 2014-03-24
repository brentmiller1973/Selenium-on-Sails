



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationBottomItemsPerPage extends BaseTestCase {
	@Test public void testPaginationBottomItemsPerPage() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pens/ballpoint-pens");
		selenium.select("css=div.prodListBottom.no_bg > div.prodListPagination.clearfix > div.dropDowns > div.items > form[name=\"ItemPerPageFrm\"] > select[name=\"ipp\"]", "label=45");
		selenium.waitForPageToLoad("30000");
		assertEquals(selenium.getXpathCount("//div[@class='prodListContent']"), "45");
		selenium.select("css=div.prodListBottom.no_bg > div.prodListPagination.clearfix > div.dropDowns > div.items > form[name=\"ItemPerPageFrm\"] > select[name=\"ipp\"]", "label=90");
		selenium.waitForPageToLoad("30000");
		assertEquals(selenium.getXpathCount("//div[@class='prodListContent']"), "90");
	}
}
