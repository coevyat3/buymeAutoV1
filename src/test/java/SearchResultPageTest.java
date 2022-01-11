import buyme.base.BaseClass;
import buyme.pageObjects.GiftCardPage;
import buyme.pageObjects.HomePage;
import buyme.pageObjects.SearchResultPage;
import buyme.utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {
   HomePage homePage;
   SearchResultPage searchResultPage;
   GiftCardPage giftCardPage;


    @Parameters({"browser", "URL"})
    @BeforeMethod
    public void setup(String browserType,String url){
        Loader(browserType,url);
        homePage=new HomePage();
        searchResultPage=homePage.navBarSearchGift(Constants.PRICE_VALUE,Constants.AREA_VALUE,Constants.CATEGORY_VALUE);
   }
   @Test(priority = 1)
   public void TestCurrentUrl(){
        logger.info("Validate URL address Response");
        Assert.assertTrue(searchResultPage.validatePageSource().contains(Constants.PRICE_VALUE) );
        Assert.assertTrue(searchResultPage.validatePageSource().contains(Constants.CATEGORY_VALUE));
        Assert.assertTrue(searchResultPage.validatePageSource().contains(Constants.AREA_VALUE));
   }

   @Test(priority = 2)
    public void checkNoResultImg() throws InterruptedException {
        logger.info("Verify if Error image is not display..");
       Assert.assertFalse(searchResultPage.validateImage());
    }
    @Test(priority = 3)
    public void checkHeaderTitle(){
        logger.info("Verify header title is display..");
      Assert.assertFalse(searchResultPage.getSearchResultTitle());
    }
    @Test(priority = 4)
    public void pickGift() throws InterruptedException {
        logger.info("Pick a Business Gift");
        giftCardPage=searchResultPage.clickGift(Constants.business);

    }

   @AfterMethod
    public void tearDown(){
        driver.quit();
   }
}
