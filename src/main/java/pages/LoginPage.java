package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    private By emailInput = By.xpath("//mat-card/descendant::input[1]");
    private By passwordInput = By.xpath("//mat-card/descendant::input[2]");
    private By loginBtnXpath = By.xpath("//button[contains(@class,'login-btn')]");


    private By adminLoginBtn = By.xpath("//a[@routerlink='/admin-login']");

    public void enterEmail(String email){
        type(driver,emailInput,email);
    }

    public void enterPassword(String password){
        type(driver,passwordInput,password);
    }

    public void clickLoginBtn(){

        click(driver,loginBtnXpath);
    }

    public void login(String email, String password){
        enterEmail( email);
        enterPassword(password);
        clickLoginBtn();

    }



    public boolean isLoggedIn(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
        return driver.findElement(By.xpath("//h2[contains(text(),'Welcome')]")).isDisplayed();
    }

    public void handleAlert(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public AdminLoginPage navigateToAdminLoginPage(){
        driver.findElement(adminLoginBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("admin-login"));
        return new AdminLoginPage(driver);
    }
}
