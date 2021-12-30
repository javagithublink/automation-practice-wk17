package com.automationpractice.steps;

import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MyAccountPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInSteps {
    @Given("^I am on the Sign In Page$")
    public void iAmOnTheSignInPage() {
        new HomePage().clickOnSignInButton();
    }

    @When("^Login using newly create credentials$")
    public void loginUsingNewlyCreateCredentials() {
        new AuthenticationPage().enterRegisteredEmailAddress();
        new AuthenticationPage().enterRegisteredPassword();
        new AuthenticationPage().clickOnSignInButton();
    }

    @Then("^I shall verify the address information in my address section$")
    public void iShallVerifyTheAddressInformationInMyAddressSection() {
        new MyAccountPage().verifyUserAddressUnderMyAddressesSection();
    }
}
