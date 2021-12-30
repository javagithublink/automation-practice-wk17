package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//strong[normalize-space()='pradeep']")
    WebElement orderRefText;

   //public String orderReferenceNumber = getOrderReferenceNumber();

    public OrderConfirmationPage() {
        PageFactory.initElements(driver, this);
    }

    public void getOrderReferenceNumber() {
       pmWaitWithThreadSleep(10);
        pmGetTextFromElement(orderRefText);
        System.out.println(orderRefText.getText());
        //return orderRefText.getText().substring(49,57);
                //substring(49,57);
    }



}
