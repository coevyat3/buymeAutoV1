package buyme.pageObjects;

import buyme.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseClass {
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div[class*='field bottom-lr'] input[type='email']")
    @CacheLookup
    private WebElement mail;

    @FindBy(css = "div[class*='field bottom-lr'] input[type='password']")
    @CacheLookup
    private WebElement password;

    @FindBy(xpath = "//div[@class='field bottom-lr']//following-sibling::button")
    @CacheLookup
    private WebElement btn;

     public void Login(String em,String pw){
        new WebDriverWait(driver, Duration.ofSeconds(5000)).until(ExpectedConditions.visibilityOfAllElements(mail));
        mail.sendKeys(em);
        password.sendKeys(pw);
        btn.click();
    }



}
