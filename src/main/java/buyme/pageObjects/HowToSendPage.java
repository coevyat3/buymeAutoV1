package buyme.pageObjects;

import buyme.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HowToSendPage extends BaseClass {
    public HowToSendPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="div.step.active div.number")
    @CacheLookup
    private WebElement activePage;

    @FindBy(css="svg[gtm='method-email']")
    @CacheLookup
    private WebElement clickEmail;

    @FindBy(css="input#email")
    @CacheLookup
    private WebElement email;

    @FindBy(css="input[type='text']")
    @CacheLookup
    private WebElement name;

    @FindBy(css = "button[class*='ember']")
    @CacheLookup
    private WebElement btn;

    public boolean isPageNumberAppear(){
        new WebDriverWait(driver, Duration.ofSeconds(5000)).until(ExpectedConditions.visibilityOfAllElements(activePage));
        return activePage.isDisplayed();
    }
    public LoginPage setEmail(String em,String n) {
        clickEmail.click();
        email.sendKeys(em);
        name.sendKeys(n);
        btn.click();
        return new LoginPage();
    }


}
