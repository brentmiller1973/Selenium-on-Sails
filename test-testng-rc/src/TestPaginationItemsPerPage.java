



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestPaginationItemsPerPage extends BaseTestCase {
	@Test public void testPaginationItemsPerPage() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pens/ballpoint-pens");
		assertEquals(selenium.getXpathCount("//div[@class='prodListContent']"), "15");
		selenium.select("name=ipp", "label=45");
		selenium.waitForPageToLoad("30000");
		assertEquals(selenium.getXpathCount("//div[@class='prodListContent']"), "45");
		selenium.select("name=ipp", "label=90");
		selenium.waitForPageToLoad("30000");
		assertEquals(selenium.getXpathCount("//div[@class='prodListContent']"), "90");
	}
}
