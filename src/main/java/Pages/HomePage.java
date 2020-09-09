package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{

    By loginPopup = By.xpath("//button[@class='_2AkmmA _29YdH8']");
    By searchBox = By.xpath("//input[@name ='q' and @type='text']");
    By searchButton = By.xpath("//button[@class='vh79eN']");

    public void closeLoginPopup(){
        clickElement(loginPopup);
    }

    public void setBrowser(WebDriver driver){
        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }

    public void openPage(String URL){
        driver.get(URL);
    }

    public void search(String search){
        enterText(searchBox, search);
        clickElement(searchButton);

    }
}
