package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utilities.Config;
import utilities.DriverFactory;
import utilities.DriverManager;
import org.apache.logging.log4j.Logger;


import java.time.Duration;

import static utilities.DriverManager.getDriver;

public class BaseStepDef {
    public HomePage homePage;
    public Logger logger;
    public WebDriver driver;
    public String baseUrl ="https://maze-bank-cts.vercel.app/";

    public BaseStepDef(){

        WebDriver driver = DriverFactory.createDriver(Config.getBrowser(),Config.getHeadless());

        DriverManager.setDriver(driver);

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Config.getImplicitWaitTime()));

        getDriver().get(baseUrl);

        logger = LogManager.getLogger(this.getClass());

        homePage = new HomePage(getDriver());
    }


    public void cleanUp(){
        DriverManager.quitDriver();
    }

}
