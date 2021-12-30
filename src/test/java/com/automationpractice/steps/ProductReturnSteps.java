package com.automationpractice.steps;

import com.automationpractice.pages.ContactUsPage;
import com.automationpractice.pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ProductReturnSteps {
    @And("^I am on the contact page$")
    public void iAmOnTheContactPage() {
        new HomePage().goToContactUsPage();
    }

    @Then("^I send refund request to customer care for previous order$")
    public void iSendRefundRequestToCustomerCareForPreviousOrder() {
        new ContactUsPage().selectCustomerServiceFromSubjectHeading();
        new ContactUsPage().selectOrderReferenceNumber();
        new ContactUsPage().selectProductFromDropDown();
        new ContactUsPage().enterRefundMessageInToMessageBox();
        new ContactUsPage().clickOnSendButton();
        new ContactUsPage().verifyMessageSentSuccessfully();
    }
}
