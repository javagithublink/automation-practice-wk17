package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//p[@class='payment_module']//a[@class='cheque']")
    WebElement payByCheckTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='I confirm my order']")
    WebElement confirmOrderTab;

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnPayByCheckPaymentMethod() {
        pmWaitWithThreadSleep(10);
        pmClickOnElement(payByCheckTab);
    }

    public void clickOnConfirmOrderTab() {
        pmClickOnElement(confirmOrderTab);
    }
}
