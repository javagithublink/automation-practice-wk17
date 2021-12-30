package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends Utility {

    @CacheLookup
    @FindBy (xpath = "//select[@id='id_contact']")
    WebElement customerServiceText;

    @CacheLookup
    @FindBy (xpath = "//select [@name='id_order']")
    WebElement orderReferenceText;

    @CacheLookup
    @FindBy (xpath = "//textarea[@id='message']")
    WebElement messageBox;


    @CacheLookup
    @FindBy (xpath = "//div[@class='selector']//select [@name='id_product']")
    WebElement productList;

    @CacheLookup
    @FindBy (xpath = "//span[normalize-space()='Send']")
    WebElement sendButton;

    @CacheLookup
    @FindBy (xpath =  "//p[@class='alert alert-success']")
    WebElement messageSentText;


    public ContactUsPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectCustomerServiceFromSubjectHeading (){
        pmSelectByContainsTextFromDropDown(customerServiceText,"Customer service".trim());
    }

    public void selectOrderReferenceNumber(){

        pmselectByIndexFromDropDown(orderReferenceText,1);
    }

    public void selectProductFromDropDown(){

        pmselectByIndexFromDropDown(productList,1);
    }

    public void enterRefundMessageInToMessageBox(){
        pmSendTextToElement(messageBox,"I have now cancelled this order, so please give me refund");
    }


    public void clickOnSendButton(){
        pmClickOnElement(sendButton);
    }

    public void verifyMessageSentSuccessfully(){
        String expected = "Your message has been successfully sent to our team.";
        String actual = messageSentText.getText();
        Assert.assertTrue(actual.toLowerCase().contains("successfully"));
    }


}
