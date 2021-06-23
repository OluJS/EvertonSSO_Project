package com.example.pages;

import com.example.ConfigFileReader;
import com.example.common.BaseTest;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class RegistrationPage extends BaseTest {

    public RegistrationPage() throws IOException, ParseException {
    }

    /**
     * Navigates to Everton's registration page by remove the pop-up modal
     * on the home page thus allowing the webDriver to click the registration
     * link
     */

    public static void navigateToRegistrationPage() throws IOException, ParseException {
        navigateToEvertonHomePage();
        JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        WebElement modal = driver.findElement(By.className(getGlossaryTerm("Homepage Modal")));
        js.executeScript("var element = arguments[0];element.parentNode.removeChild(element);", modal);
        clickElement(getGlossaryTerm("Everton Register"));
        acceptCookiesRegisterPage();
    }

    /**
     * Completes the 'Account Details' section of registration form
     *
     * Using a random email has been commented out so Everton isn't
     * spammed with new registration requests when this test suite
     * is run
     */

    public static void populateAccountDetails() throws IOException, ParseException {
        /*
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
        String randomEmail = "JohnDoe" + randomInt + "@gmail.com";
        */

        clickElement(getGlossaryTerm("Account Details"));

        fill(getGlossaryTerm("Email"), ConfigFileReader.prop.getProperty("email"));
        fill(getGlossaryTerm("Password"), ConfigFileReader.prop.getProperty("password"));
        fill(getGlossaryTerm("Confirm Password"), ConfigFileReader.prop.getProperty("password"));
    }

    /**
     * Completes the 'Your Details' section of registration form
     */

    public static void populateYourDetails() throws IOException, ParseException {
        clickElement(getGlossaryTerm("Your Details"));

        fill(getGlossaryTerm("First Name"), "John");
        fill(getGlossaryTerm("Last Name"), "Doe");
        fill(getGlossaryTerm("DoB Day"), "07");
        fill(getGlossaryTerm("DoB Month"), "01");
        fill(getGlossaryTerm("DoB Year"), "1999");
        fill(getGlossaryTerm("Mobile Number"), "00000000000");

    }

    /**
     * Completes the 'Your Details' section of registration form
     */

    public static void populateYourAddress() throws IOException, ParseException {

        clickElement(getGlossaryTerm("Your Address"));

        fill(getGlossaryTerm("Postcode"), "RM6 6UU");
        clickElement(getGlossaryTerm("Find Address"));
        clickElement(getGlossaryTerm("Address Options"));
        clickElement(getGlossaryTerm("First Address"));
        fill(getGlossaryTerm("County"), "Essex");

    }

    /**
     * Completes the 'Communication Preferences' section of registration form
     */

    public static void chooseCommunicationPreferences() throws IOException, ParseException {
        clickElement(getGlossaryTerm("Your Communication Preferences"));
        clickElement(getGlossaryTerm("Opt Out"));
        clickElement(getGlossaryTerm("TOS"));
    }

    /**
     * Accepts cookie on the register page to remove
     */

    public static void acceptCookiesRegisterPage() {
        driver.findElement(By.cssSelector(".button--icon-left")).click();
    }

}
