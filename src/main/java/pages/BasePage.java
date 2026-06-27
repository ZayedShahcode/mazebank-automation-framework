package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriverWait webWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void type(WebDriver driver,By locator,String text){
        WebElement el = webWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(text);
    }

    public void click(WebDriver driver,By locator){

        driver.findElement(locator).click();
    }
}
