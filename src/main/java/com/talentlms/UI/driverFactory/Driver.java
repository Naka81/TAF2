package com.talentlms.UI.driverFactory;


import com.talentlms.UI.dataProvider.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {

    private Driver() {
        //Singleton patten шаблон синглтон
    }

    private static WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "Safari":
                    driver = SafariWebiDriver.loadSafariDriver();
                    break;
                default:
                    driver = SafariWebiDriver.loadSafariDriver();
            }

        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}