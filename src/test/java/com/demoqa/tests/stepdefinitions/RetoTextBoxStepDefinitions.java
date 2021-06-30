package com.demoqa.tests.stepdefinitions;

import com.demoqa.automation.steps.TextBoxSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RetoTextBoxStepDefinitions {

    @Steps
    TextBoxSteps textBoxSteps;

    @Given("^that a web user wants to practice text box in demoqa$")
    public void thatAWebUserWantsToPracticeTextBoxInDemoqa() throws InterruptedException {
        textBoxSteps.openBrowser();
        Thread.sleep(2000);
    }

    @When("^he fills all the requested fields in text box section$")
    public void heFillsAllTheRequestedFieldsInTextBoxSection() throws InterruptedException {
        textBoxSteps.fillFields();
    }

    @Then("^he should see him data down\\.$")
    public void heShouldSeeHimDataDown() {

        textBoxSteps.quitBrowser();

    }
}
