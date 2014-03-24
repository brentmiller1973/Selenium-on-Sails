



import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class TestCategoryClickCategoryItems extends BaseTestCase {
	@Test public void testCategoryClickCategoryItems() throws Exception {
		selenium.open("/office-supplies/pens-pencils-markers/pens/ballpoint-pens");
		selenium.click("//div[@class='browseby']/div[@title='Brand']/div[@class='facetContainerContent']/div/label[@class='facetLabel']/input");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@class='browseby']/div[@title='Ink Color']/div[@class='facetContainerContent']/div/label[@class='facetLabel']/input");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("BIC 4-Color RT Grip Ballpoint Pen"));
	}
}
