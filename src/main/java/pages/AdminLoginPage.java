package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminLoginPage {

    public WebDriver driver;

    public AdminLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By adminUsername = By.xpath("//input[1]");
    private By adminPassword = By.xpath("//input[@type='password']");

    private By loginBtn = By.xpath("//button/descendant::span[text()='Admin Login']/ancestor::button");

    private By adminText = By.xpath("//h2[text()='Admin Dashboard']");

    public void login(String username,String password){
        WebElement adminName = driver.findElement(adminUsername);
        WebElement adminPass = driver.findElement(adminPassword);
        adminName.clear();
        adminName.sendKeys(username);

        adminPass.clear();
        adminPass.sendKeys(password);

        driver.findElement(loginBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminText));



    }
}
