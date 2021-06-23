package com.example.common;

import com.example.ConfigFileReader;
import com.example.ElementSelectorReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class BaseClass {

    public static WebDriver driver;

    public static WebDriver startDriver() throws IOException, ParseException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ConfigFileReader.readPropertiesFile();
        ElementSelectorReader.readElementSelectors();
        return driver;
    }

    public static WebDriver getDriver() throws IOException, ParseException {
        if (driver != null){
            return driver;
        }
        WebDriver driver = startDriver();
        return driver;
    }

    public static void tearDown(){
        driver.quit();
    }
}
