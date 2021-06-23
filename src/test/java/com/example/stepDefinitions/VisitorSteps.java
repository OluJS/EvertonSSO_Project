package com.example.stepDefinitions;

import com.example.common.BaseTest;
import com.example.common.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import com.example.pages.RegistrationPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class VisitorSteps extends BaseTest {

    public VisitorSteps() throws IOException, ParseException {
    }

    @Given("^a Visitor navigates to the Everton registration page$")
    public void navigatesToRegistrationPage() throws IOException, ParseException {
        navigateToEvertonHomePage();
        RegistrationPage.navigateToRegistrationPage();
    }

    @Given(("^the Visitor can see the (.*) (?:is|are) (clickable|ready|displayed)$"))
    public void canSee(final String element, final String elementState) throws IOException, ParseException {
        seeElement(element);
    }

    @Given("^the Visitor enters (.*) into the (.*) field$")
    public void inputValue(final String value, final String element) throws IOException, ParseException {
        navigateToEvertonHomePage();
        RegistrationPage.navigateToRegistrationPage();
    }

    @When(("^the Visitor completes the registration form$"))
    public void completeRegistrationForm() throws IOException, ParseException {
        RegistrationPage.populateAccountDetails();
        RegistrationPage.populateYourDetails();
        RegistrationPage.populateYourAddress();
        RegistrationPage.chooseCommunicationPreferences();
    }

    @When(("^the Visitor clicks (?:on|the) (.*) element$"))
    public void clicksTheComponent(String element) throws IOException, ParseException {
        clickElement(element);
    }

    @Then(("^the Visitor can see the (.*) matches the text '(.*)'$"))
    public void matchElementAndText(final String element, final String matchOption) throws IOException, ParseException {
        seeElementAndText(element, matchOption);

    }

    @After
    public void shutdown() {
        BaseClass.tearDown();
    }


}
