package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By registerNav = By.xpath("//span[text()='Register']");
    private By loginNav = By.xpath("//button[@routerlink='/login']");
    private By adminLoginNav = By.xpath("//button[@routerlink='/admin-login']");

    public SignUpPage navigateToRegisterPage(){
        driver.findElement(registerNav).click();
        return new SignUpPage(driver);
    }

    public LoginPage navigateToLoginPage(){
        driver.findElement(loginNav).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.urlContains("login"));
        return new LoginPage(driver);
    }

    public AdminLoginPage navigateToAdminLoginPage(){
        driver.findElement(adminLoginNav).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.urlContains("admin-login"));
        return new AdminLoginPage(driver);

    }

    public DashboardPage navigateToDashboardViaSignUp(String email,String phone){
        SignUpPage signup = navigateToRegisterPage();
        signup.signUp("ValidUser",email,phone,"cognizant","Password@123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert1.getText();
        alert1.accept();
        Assert.assertTrue(alertText.contains("successful"));
        wait.until(ExpectedConditions.urlContains("login"));
        LoginPage loginPage = navigateToLoginPage();
        loginPage.login(email,"Password@123");

        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        alert2.accept();
        wait.until(ExpectedConditions.urlContains("dashboard"));
        return new DashboardPage(driver);

    }

    public WebDriverWait pageWait(){
        return new WebDriverWait(driver,Duration.ofSeconds(30));
    }



    public DashboardPage navigateToDashboardViaLogin(String email,String password){
        LoginPage loginPage = navigateToLoginPage();
        loginPage.login(email,password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        alert2.accept();
        wait.until(ExpectedConditions.urlContains("dashboard"));
        return new DashboardPage(driver);
    }


}
