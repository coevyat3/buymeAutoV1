package buyme.base;

import buyme.utilities.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseClass {
    protected static WebDriver driver ;
    protected static Logger logger= LogManager.getLogger("Automation");
   // protected FluentWait<WebDriver> wait;
    protected JavascriptExecutor jse;

    @Parameters({"browser","URL"})
     public void Loader(String browserType,String url){

         if(browserType.equalsIgnoreCase("chrome")) {
             WebDriverManager.chromedriver().setup();
             ChromeOptions options= new ChromeOptions();
             options.addArguments("--ignore-certificate-errors");
             options.addArguments("--incognito");
             driver = new ChromeDriver(options);
         }
         else if(browserType.equalsIgnoreCase("Firefox")){
             WebDriverManager.firefoxdriver().setup();
             driver= new FirefoxDriver();
         }
         PropertyConfigurator.configure("log4j.properties");
         JavascriptExecutor jse = (JavascriptExecutor)driver;
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
         driver.get(url);



    }

}
