package com.example.common;

import com.example.ElementSelectorReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.json.simple.parser.ParseException;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;

import java.io.IOException;

import static com.example.common.BddConstants.WAIT_IN_SECONDS;


public class BaseTest {


    protected static WebDriver driver;

    public BaseTest() throws IOException, ParseException {
        driver = BaseClass.getDriver();
    }

    /**
     * Navigate to the Everton home page
     */
    public static void navigateToEvertonHomePage() {
        driver.get("https://www.evertonfc.com/home");
    }

    /**
     * Get the value from the glossary by term (key)
     *
     * @param key The key in the glossary
     * @return The key's value in the glossary
     */
    public static String getGlossaryTerm(String key) throws IOException, ParseException {
        String object = (String) ElementSelectorReader.readElementSelectors().get(key);

        if (object != null) {
            return object;
        }
        return key;
    }

    /**
     * Populates fields with the given value
     *
     * @param locator Element needing to be populated
     * @param value   Content to populate the element with
     */
    public static void fill(String locator, String value) throws IOException, ParseException {
        driver.findElement(By.cssSelector(getGlossaryTerm(locator))).sendKeys(value);
    }

    /**
     * Click on the element
     *
     * @param locator The element selector
     */
    public static void clickElement(String locator) throws IOException, ParseException {
        new WebDriverWait(driver, WAIT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(By.cssSelector(getGlossaryTerm(locator))));
        driver.findElement(By.cssSelector(getGlossaryTerm(locator))).click();
    }

    /**
     * Check the element is being displayed on the page
     *
     * @param locator The element selector
     */
    public static void seeElement(final String locator) throws IOException, ParseException {
        WebElement element = driver.findElement(By.cssSelector(getGlossaryTerm(locator)));
        Assert.assertTrue(element.isDisplayed());
    }

    /**
     * Locate the element with matching text
     *
     * @param locator The element selector
     * @param text    The text to match
     */
    public static void seeElementAndText(final String locator, final String text) throws IOException, ParseException {
        WebElement element = driver.findElement(By.cssSelector(getGlossaryTerm(locator)));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), text);

    }

}
