import buyme.base.BaseClass;
import buyme.pageObjects.HomePage;
import buyme.pageObjects.SearchResultPage;
import buyme.utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    HomePage homePage;
    SearchResultPage searchResultPage;

    @Parameters({"browser", "URL"})
    @BeforeMethod
    public void setup(String browserType,String url){
       Loader(browserType,url);
       homePage= new HomePage();
    }
    @Test(priority = 1)
    public void getCurrentUrl(){
        logger.info("Verifying HomePage url");
        Assert.assertEquals(homePage.getCurrentUrl(),Constants.HOME_PAGE_URL);
    }

    @Test(priority = 2)
    public void getHomePageTitle(){
        logger.info("Verifying homePage title");
        Assert.assertTrue(homePage.getHomePageTitle().contains(Constants.HOME_PAGE_TITLE));
    }

    @Test(priority = 3)
    public void getLogoDimension(){
        logger.info("Validate Logo Image");
        Assert.assertTrue(homePage.IsLogoDisplay());
        System.out.println(homePage.getLogoSize());
    }
    @Test(priority = 4)
    public void searchGiftFromAutoCompleteTextBox(){
        try {
            logger.info("searching gift from AutoComplete search box");
            searchResultPage = homePage.searchBox(Constants.WINE, Constants.WINE_TYPE);
            Assert.assertFalse(searchResultPage.validateImage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test(priority = 5)
    public void searchGiftFromNavNBar() {
        logger.info("verify price pick");
        searchResultPage=homePage.navBarSearchGift(Constants.PRICE_VALUE, Constants.AREA_VALUE, Constants.CATEGORY_VALUE);
        boolean flag=searchResultPage.validateImage();
        if(flag){
            logger.info("No result from the current search pattern");
        }
        else
            logger.info("Successes to find results from the navbar search");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
