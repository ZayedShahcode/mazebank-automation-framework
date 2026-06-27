package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.admin.AdminLoginPage;
import pages.customer.DashboardPage;
import pages.customer.LoginPage;
import pages.customer.SignUpPage;

public class HomePage extends BasePage {

    public WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By registerNav = By.xpath("//span[text()='Register']");
    private By loginNav = By.xpath("//button[@routerlink='/login']");
    private By adminLoginNav = By.xpath("//button[@routerlink='/admin-login']");

    public SignUpPage navigateToRegisterPage(){
        click(driver,registerNav);
        return new SignUpPage(driver);
    }

    public LoginPage navigateToLoginPage(){
        click(driver,loginNav);
        waitForUrlContains(driver,"login");
        return new LoginPage(driver);
    }

    public AdminLoginPage navigateToAdminLoginPage(){
        click(driver,adminLoginNav);
        waitForUrlContains(driver,"admin-login");
        return new AdminLoginPage(driver);

    }

    public DashboardPage navigateToDashboardViaSignUp(String email, String phone){
        SignUpPage signup = navigateToRegisterPage();
        LoginPage loginPage = signup.signUp("ValidUser",email,phone,"cognizant","Password@123");
        return loginPage.login(email,"Password@123");

    }


    public DashboardPage navigateToDashboardViaLogin(String email,String password){
        LoginPage loginPage = navigateToLoginPage();
        return loginPage.login(email,password);

    }


}
