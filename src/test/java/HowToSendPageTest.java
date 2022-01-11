import buyme.base.BaseClass;
import buyme.pageObjects.*;
import buyme.utilities.Constants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HowToSendPageTest extends BaseClass {
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
        howToSendPage=whoToSendPage.pickAll(Constants.FRIEND,Constants.WISH,Constants.BLESS,Constants.PATH);

    }
    @Test(priority = 1)
    public void sendSenderInfo() throws InterruptedException {
        logger.info("Send sender information...");
        howToSendPage.setEmail(Constants.EMAIL,Constants.NAME);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
