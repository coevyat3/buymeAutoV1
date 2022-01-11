package buyme.pageObjects;

import buyme.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WhoToSendPage extends BaseClass {
    public WhoToSendPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="span>b")
    @CacheLookup
    private WebElement priceLabel;

    @FindBy(css="div>label>input[xpath]")
    @CacheLookup
    private WebElement someoneElseCheck;

    @FindBy(css = "label#friendName input")
    @CacheLookup
    private WebElement tx;

    @FindBy(css = ".selected-text")
    @CacheLookup
    private WebElement dropdownClick;

    @FindBy(css = "ul[style='width: auto'] li ")
    @CacheLookup
    private List <WebElement> eventList;

    @FindBy(css="label>textarea")
    @CacheLookup
    private WebElement txtArea;

    @FindBy(css="input[name='logo']")
    @CacheLookup
    private WebElement photo;

    @FindBy(css = "button[type='submit']")
    @CacheLookup
    private WebElement btn;


    public void setFriendName(String txt){
        new WebDriverWait(driver, Duration.ofSeconds(5000)).until(ExpectedConditions.visibilityOfAllElements(tx));
        tx.sendKeys(txt);


    }
    public void clickOnDropDown() {
        dropdownClick.click();
        for (WebElement element : eventList) {
          if(element.getAttribute("value").equalsIgnoreCase("39")){
              element.click();
              break;
          }
        }

    }

    public void WriteABless(String txt){
        txtArea.clear();
        txtArea.sendKeys(txt);
    }
    public void SendPhoto(String path){
        photo.sendKeys(path);
    }
    public HowToSendPage clickContinueBtn(){
        btn.click();
        return  new HowToSendPage();
    }
    public String checkPrice() {
        return priceLabel.getText();

    }
    public HowToSendPage pickAll(String a,String b,String c,String d){
        new WebDriverWait(driver, Duration.ofSeconds(5000)).until(ExpectedConditions.visibilityOfAllElements(tx));
        tx.sendKeys(a);
        dropdownClick.click();
        for (WebElement element : eventList) {
            if(element.getAttribute("value").contains(b)){
                element.click();
                break;
            }
        }
        txtArea.clear();
        txtArea.sendKeys(c);
        photo.sendKeys(d);
        btn.click();
        return  new HowToSendPage();
    }


}
