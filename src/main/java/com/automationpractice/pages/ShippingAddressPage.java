package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]")
        WebElement proceedToCheckOutButtonFromShippingPage;

    @CacheLookup
    @FindBy (xpath = "//input[@id='cgv']")
    WebElement termsCheckBox;

    public ShippingAddressPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnProceedToCheckOutFromShippingPage(){
        pmClickOnElement(proceedToCheckOutButtonFromShippingPage);
    }

    public void acceptTermsAndCondition(){
        pmClickOnElement(termsCheckBox);
    }

}

