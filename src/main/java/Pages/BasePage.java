package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected void clickElement(By element) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected List<WebElement> getListOfElements(By locator){
        return driver.findElements(locator);
    }

    protected void enterText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    protected void enterText(By locator, String value) {
        wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(value);
    }

    protected void waitForClickable(By locator) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
