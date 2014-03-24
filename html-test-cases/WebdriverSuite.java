import junit.framework.Test;
import junit.framework.TestSuite;

public class WebdriverSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestCategoryClickCategoryItems.class);
		suite.addTestSuite(TestCategoryClickSeeAll.class);
		suite.addTestSuite(TestCategoryHiddenItems.class);
		suite.addTestSuite(TestPaginationItemsPerPage.class);
		suite.addTestSuite(TestPaginationNextLink.class);
		suite.addTestSuite(TestPaginationNumericalLinks.class);
		suite.addTestSuite(TestPaginationPreviousLink.class);
		suite.addTestSuite(TestPaginationSortHighToLow.class);
		suite.addTestSuite(TestPaginationSortLowToHigh.class);
		suite.addTestSuite(TestPaginationSortProductAtoZ.class);
		suite.addTestSuite(TestPaginationSortProductZtoA.class);
		suite.addTestSuite(TestPaginationSortRatingsHighToLow.class);
		suite.addTestSuite(TestPaginationSortRatingsLowToHigh.class);
		suite.addTestSuite(TestPaginationTileItemsPerPage.class);
		suite.addTestSuite(TestPaginationTileNextLink.class);
		suite.addTestSuite(TestPaginationTileNumericalLinks.class);
		suite.addTestSuite(TestPaginationTilePreviousLink.class);
		suite.addTestSuite(TestPaginationTileSortHighToLow.class);
		suite.addTestSuite(TestPaginationTileSortLowToHigh.class);
		suite.addTestSuite(TestPaginationTileSortProductAtoZ.class);
		suite.addTestSuite(TestPaginationTileSortProductZtoA.class);
		suite.addTestSuite(TestPaginationTileSortRatingsHighToLow.class);
		suite.addTestSuite(TestPaginationTileSortRatingsLowToHigh.class);
		suite.addTestSuite(TestPaginationTileViewAll.class);
		suite.addTestSuite(TestPaginationViewAll.class);
		suite.addTestSuite(TestDropDownToImage.class);
		suite.addTestSuite(TestDropDownToLink.class);
		suite.addTestSuite(TestLeftNavPanel.class);
		suite.addTestSuite(TestLeftNavToBoldLink.class);
		suite.addTestSuite(TestLeftNavToImageClick.class);
		suite.addTestSuite(TestLeftNavToMoreLink.class);
		suite.addTestSuite(TestLeftNavToSubMember.class);
		suite.addTestSuite(TestSearchToBreadCrumb.class);
		suite.addTestSuite(TestSearchToBreadCrumb2.class);
		suite.addTestSuite(TestSearchToBrowseBy.class);
		suite.addTestSuite(TestSearchToList.class);
		suite.addTestSuite(TestSearchToTile.class);
		suite.addTestSuite(TestPaginationBottomItemsPerPage.class);
		suite.addTestSuite(TestPaginationBottomNextLink.class);
		suite.addTestSuite(TestPaginationBottomPreviousLink.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
