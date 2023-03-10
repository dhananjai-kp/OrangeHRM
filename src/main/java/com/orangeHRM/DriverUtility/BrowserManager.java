package com.orangeHRM.DriverUtility;

import com.orangeHRM.Constants.ConfigConstant;
import com.orangeHRM.Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
public class BrowserManager {
    public static WebDriver driver;
    public static void driverInit() throws IOException {
        if (ReadConfig.readConfigFile(ConfigConstant.BROWSERNAME).equalsIgnoreCase("chrome") ) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (ReadConfig.readConfigFile(ConfigConstant.BROWSERNAME).equalsIgnoreCase("edge") ) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (ReadConfig.readConfigFile(ConfigConstant.BROWSERNAME).equalsIgnoreCase("firefox") ) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(ReadConfig.readConfigFile(ConfigConstant.URL));
    }
    public static void driverQuit() {
        driver.close();
    }


}
