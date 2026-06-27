package ui;


import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
import utilities.DriverManager;

public class AdminLoginTest extends BaseTest {

    AdminLoginPage adminLoginPage;

    @Test
    public void adminLogin(){
        logger.info("Testing Admin Login");
        adminLoginPage = hp.navigateToAdminLoginPage();
        logger.info("Navigating to Admin Login Page");
        adminLoginPage.login("admin","admin123");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://maze-bank-cts.vercel.app/admin");
        logger.info("Admin Login Successful");
    }
}
