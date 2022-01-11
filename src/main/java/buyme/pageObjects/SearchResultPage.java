package buyme.pageObjects;

import buyme.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends BaseClass {

    public SearchResultPage(){
        PageFactory.initElements(driver,this);
   }
   @FindBy(css = "img.no-results.ember-view")
   @CacheLookup
   private WebElement validateImg;

    @FindBy(css="div>h1")
    @CacheLookup
    private WebElement headerTitle;

    @FindBy(css = "div[class='bottom']>span")
    @CacheLookup
    private List<WebElement> gifts;



    /**
     *
     * @return boolean value-
     * if the current img display on screen there is no result from the search gift option(homePage.searchFromNavBar or homepage.searchFromTextBox) and will return true;
     * else -> return false -> found gifts from the search functionality from homepage.
     */
     public boolean validateImage(){
          return validateImg.isDisplayed();
     }
     public boolean getSearchResultTitle(){
        return headerTitle.isDisplayed();
     }
     public String validatePageSource(){
         return driver.getCurrentUrl();
     }

     public GiftCardPage clickGift(String txt){
         for(WebElement element:gifts){
             if(element.getText().equalsIgnoreCase(txt));
             element.click();
             break;
         }
         return new GiftCardPage();
     }


}

