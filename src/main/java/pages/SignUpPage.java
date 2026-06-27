package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SignUpPage {

    public WebDriver driver;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }


    private By fullName = By.xpath("//mat-card/descendant::input[1]");
    private By email = By.xpath("//mat-card/descendant::input[2]");
    private By phoneNumber = By.xpath("//mat-card/descendant::input[3]");
    private By address = By.xpath("//mat-card/descendant::input[4]");
    private By password = By.xpath("//mat-card/descendant::input[5]");

    private By registerBtn = By.xpath("//app-register/descendant::button");



    public void signUp(String fullName,String email,String phoneNumber,String address,String password){
        WebElement name = driver.findElement(this.fullName);
        name.clear();
        name.sendKeys(fullName);


        WebElement emailField = driver.findElement(this.email);
        emailField.clear();
        emailField.sendKeys(email);


        WebElement phone = driver.findElement(this.phoneNumber);
        phone.clear();
        phone.sendKeys(phoneNumber);

        WebElement add = driver.findElement(this.address);
        add.clear();
        add.sendKeys(address);


        WebElement pass = driver.findElement(this.password);
        pass.clear();
        pass.sendKeys(password);

        driver.findElement(registerBtn).click();

//        return new DashboardPage();

    }


}
