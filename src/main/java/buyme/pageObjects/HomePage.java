package buyme.pageObjects;

import buyme.base.BaseClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage extends BaseClass {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inner a img")
    @CacheLookup
    private WebElement logo;

    @FindBy(css = "form>label>input")
    @CacheLookup
    private WebElement txtBox;

    @FindBy(css="form>a")
    @CacheLookup
    private WebElement searchBtn;

    @FindBy(css="div[class='dropdown'] li span")
    @CacheLookup
    private List<WebElement>list;

    @FindBy(css="div[class='dropdown'] li")
    @CacheLookup
    private List<WebElement> itemList;

    @FindBy(css = ".selected-text")
    @CacheLookup
    private List<WebElement> NavBarList;


    public boolean IsLogoDisplay() {
        return logo.isDisplayed();
    }

    public Dimension getLogoSize() {
        return logo.getSize();
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public SearchResultPage searchBox(String txt,String searchTxt){
        txtBox.sendKeys(txt);
        for(WebElement element:list){
           if(element.getText().contains(searchTxt))
                element.click();
                break;
            }
        searchBtn.click();
        return new SearchResultPage();
    }
    public SearchResultPage navBarSearchGift(String txt, String txt2, String txt3){
        WebElement element= NavBarList.get(0);
        element.click();
        pickItem(txt);
        WebElement element1= NavBarList.get(1);
        element1.click();
        pickItem(txt2);
        WebElement element2= NavBarList.get(2);
        element2.click();
        pickItem(txt3);
        clickSearchBtn();
        return new SearchResultPage();

        }



    public void pickItem(String id) {
          for(WebElement element:itemList){
              if(element.getAttribute("value").equals(id)){
                  element.click();
                  break;
              }
          }
    }
    public SearchResultPage clickSearchBtn(){
        searchBtn.click();
        return new SearchResultPage();
    }



}
