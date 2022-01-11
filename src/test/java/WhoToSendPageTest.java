import buyme.base.BaseClass;
import buyme.pageObjects.*;
import buyme.utilities.Constants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WhoToSendPageTest extends BaseClass {
    HomePage homePage;
    SearchResultPage searchResultPage;
    GiftCardPage giftCardPage;
    WhoToSendPage whoToSendPage;
    HowToSendPage howToSendPage;



    @Parameters({"browser","URL"})
    @BeforeMethod
    public void setup(String browserType,String url) {
        Loader(browserType, url);
        homePage = new HomePage();
        searchResultPage = homePage.navBarSearchGift(Constants.PRICE_VALUE, Constants.AREA_VALUE, Constants.CATEGORY_VALUE);
        giftCardPage = searchResultPage.clickGift(Constants.business);
        whoToSendPage=giftCardPage.insertMoney(Constants.Money);
    }
    @Test(priority = 3)
    public void sendInfo() throws InterruptedException {
        logger.info("Sending contact information");
        howToSendPage=whoToSendPage.pickAll(Constants.FRIEND,Constants.WISH,Constants.BLESS,Constants.PATH);
        boolean flag=howToSendPage.isPageNumberAppear();
        if(flag){
            logger.info("Successes");
        }
        else
            logger.info("failed");


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
