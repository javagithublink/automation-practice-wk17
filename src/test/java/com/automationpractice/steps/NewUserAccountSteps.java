package com.automationpractice.steps;

import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class NewUserAccountSteps {
    @Given("^I am on home page$")
    public void iAmOnHomePage() {
        new HomePage().clickOnSignInButton();
    }

    @Then("^Navigate to SignUp page$")
    public void navigateToSignUpPage() {
        new AuthenticationPage().enterRandomEmailInTheEmailAddressField();
        new AuthenticationPage().clickOnCreateAnAccountTab();
    }

    @And("^create an account with random username$")
    public void createAnAccountWithRandomUsername() {
        new CreateAccountPage().fillMandatoryFields("James","Bond","abc12456","123 Abc Street","London","Florida","12345","01234567890");
        new CreateAccountPage().clickOnRegister();
        new MyAccountPage().userCanLogOut();
    }


}
