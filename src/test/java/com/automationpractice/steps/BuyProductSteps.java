package com.automationpractice.steps;

import com.automationpractice.pages.OrderConfirmationPage;
import com.automationpractice.pages.PaymentPage;
import com.automationpractice.pages.ShippingAddressPage;
import com.automationpractice.pages.ShoppingCartSummaryPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class BuyProductSteps {
    @Then("^I shall be able to Buy the product$")
    public void iShallBeAbleToBuyTheProduct() {
        new ShoppingCartSummaryPage().clickOnProceedToCheckOutFromSummaryPage();

        new ShippingAddressPage().clickOnProceedToCheckOutFromShippingPage();
        new ShippingAddressPage().acceptTermsAndCondition();
        new ShippingAddressPage().clickOnProceedToCheckOutFromShippingPage();

    }

    @And("^I shall be able to Buy using cheque payment$")
    public void iShallBeAbleToBuyUsingChequePayment() {
        new PaymentPage().clickOnPayByCheckPaymentMethod();
        new PaymentPage().clickOnConfirmOrderTab();

        new OrderConfirmationPage().getOrderReferenceNumber();

    }
}
