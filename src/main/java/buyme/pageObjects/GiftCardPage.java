package buyme.pageObjects;

import buyme.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GiftCardPage  extends BaseClass {
    public GiftCardPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div>h2")
    @CacheLookup
    private WebElement businessTitle;

    @FindBy(css="input[type='tel']")
    @CacheLookup
    private WebElement insertMoneyBox;

    @FindBy(xpath = "  //div[@class='mx-12 money-btn']//button")
    @CacheLookup
    private WebElement btn;

    @FindBy(css="div[class='mx-12'] >button")
    @CacheLookup
    private List<WebElement> list;

    public String getPageHeader(){
        return businessTitle.getText();
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public boolean isMoneyBoxDisplay(){
        return insertMoneyBox.isDisplayed();
    }
    public WhoToSendPage insertMoney(String txt){
        insertMoneyBox.sendKeys(txt);
        btn.click();
        return new WhoToSendPage();

    }
    public WhoToSendPage clickBtn(){
        btn.click();
        return new WhoToSendPage();
    }
    public WhoToSendPage pickBtn(){
        WebElement x=list.get(0);
        x.click();
        return new WhoToSendPage();
    }


}
