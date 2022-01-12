import buyme.base.BaseClass;
import buyme.pageObjects.GiftCardPage;
import buyme.pageObjects.HomePage;
import buyme.pageObjects.SearchResultPage;
import buyme.pageObjects.WhoToSendPage;
import buyme.utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GiftCardPageTest extends BaseClass {
    HomePage homePage;
    SearchResultPage searchResultPage;
    GiftCardPage giftCardPage;
    WhoToSendPage whoToSendPage;

    @Parameters({"browser","URL"})
    @BeforeMethod
    public void setup(String browserType,String url) {
        Loader(browserType, url);
        homePage = new HomePage();
        searchResultPage = homePage.navBarSearchGift(Constants.PRICE_VALUE, Constants.AREA_VALUE, Constants.CATEGORY_VALUE);
        giftCardPage = searchResultPage.clickGift(Constants.business);
    }
    @Test(priority = 1)
    public void checkHeaderTitle(){
        logger.info("Validate Page main header");
        Assert.assertTrue(giftCardPage.getPageHeader().contains(Constants.business));
    }
    @Test(priority = 2)
    public void validatePageTitle(){
        logger.info("Validate Page Title");
        Assert.assertFalse(giftCardPage.getPageTitle().contains(Constants.business));//*CHECK
    }
    @Test(priority = 3)
    public void InsertMoneyToTextBox(){
        logger.info("Verify Money Box");
        boolean flag=giftCardPage.isMoneyBoxDisplay();
        if(flag){
            logger.info("Found money box input ");
            giftCardPage.insertMoney(Constants.Money);
            logger.info("Insert Money Success");
            logger.info("Moved to WhoToSend Page");
        }
        else {
            logger.info("Click First Pick gift Button with Suggest Value");
            giftCardPage.pickBtn();
            logger.info("Moved to WhoToSend Page");
        }
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
        }
    }

