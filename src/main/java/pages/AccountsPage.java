package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

    public WebDriver driver;

    public AccountsPage(WebDriver driver){
        this.driver=driver;
    }

    private By aadharInput = By.xpath("//input[contains(@placeholder,'Aadhar')]");
    private By panInput = By.xpath("//input[contains(@placeholder,'e.g. ABCDE1234F')]");

    private By createButton = By.xpath("//button/child::span[text()=' Create Savings Account ']/parent::button");

    public void createAccount(String aadharNumber, String panNumber) {
        WebElement aadhar = driver.findElement(aadharInput);
        aadhar.clear();
        aadhar.sendKeys(aadharNumber);

        WebElement pan = driver.findElement(panInput);
        pan.clear();
        pan.sendKeys(panNumber);

        driver.findElement(createButton).click();


    }
}
