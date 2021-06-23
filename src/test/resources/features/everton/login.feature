@everton
@everton-sso
Feature: Everton Single Sign-On
  As a Visitor
  I want to be able to utilise Everton's SSO functionality
  So that I have access to my own account

  @visitor
  Scenario: Visitor is able to successfully register on the Everton website
    Given a Visitor navigates to the Everton registration page
    And the Visitor can see the Registration Form is displayed
    When the Visitor completes the registration form
    And the Visitor clicks the Register Button element
    Then the Visitor can see the Verify Email Alert matches the text 'You need to verify your email address to activate your account.'
