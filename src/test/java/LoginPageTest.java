import buyme.base.BaseClass;
import buyme.pageObjects.*;
import buyme.utilities.Constants;

import org.testng.annotations.*;

import java.io.IOException;


public class LoginPageTest extends BaseClass {
    HomePage homePage;
    SearchResultPage searchResultPage;
    GiftCardPage giftCardPage;
    WhoToSendPage whoToSendPage;
    HowToSendPage howToSendPage;
    LoginPage loginPage;



    @Parameters({"browser","URL"})
    @BeforeMethod
    public void setup(String browserType,String url) {
        Loader(browserType, url);
        homePage = new HomePage();
        searchResultPage = homePage.navBarSearchGift(Constants.PRICE_VALUE, Constants.AREA_VALUE, Constants.CATEGORY_VALUE);
        giftCardPage = searchResultPage.clickGift(Constants.business);
        whoToSendPage=giftCardPage.insertMoney(Constants.Money);
        howToSendPage=whoToSendPage.pickAll(Constants.FRIEND,Constants.WISH,Constants.BLESS,Constants.PATH);
        loginPage=howToSendPage.setEmail(Constants.EMAIL,Constants.NAME);

    }

    @Test(dataProvider = "A")
    public void loginTest(String em,String pw) throws IOException{
        loginPage.Login(em, pw);

    }
    @DataProvider(name="A")
    public Object[][] getData() throws IOException {
        Object data[][] = {
                {"a1b1c1d1@xyz.com", "a1b1c1d1X"}
        };

        return data;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
