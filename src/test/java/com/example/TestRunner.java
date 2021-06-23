package com.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Class initiator for Everton SSO BDD tests
 */

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html"
        },
        features = {"src/test/resources/features"},
        glue = {"com.example.stepDefinitions"},
        tags = "@everton"

)

public class TestRunner extends AbstractTestNGCucumberTests {

}
