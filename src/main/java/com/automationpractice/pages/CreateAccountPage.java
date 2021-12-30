package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(CreateAccountPage.class.getName());


    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstNameLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastNameLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='city']")
    WebElement cityLink;
    @CacheLookup
    @FindBy(xpath = "//select[@id='id_state']")
    WebElement stateLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='postcode']")
    WebElement zipPostalLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement mobilePhoneLink;
    @CacheLookup
    @FindBy(xpath = "//button[@id='submitAccount']")
    WebElement registerLink;
    @CacheLookup
    @FindBy (css = "div[class='alert alert-danger'] p")
    WebElement errorMessage;


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    WebElement myAccountTextLink;

    public static String userName = randomString();

    public void fillMandatoryFields(String firstName, String lastName, String password, String address, String city, String state, String postcode, String mobileNumber) {



        log.info("Entering firstname" + firstNameLink.toString());
        pmSendTextToElement(firstNameLink, firstName);
        log.info("Entering lastname" + lastNameLink.toString());
        pmSendTextToElement(lastNameLink, lastName);
        log.info("Entering password" + passwordLink.toString());
        pmSendTextToElement(passwordLink, password);
        log.info("Entering address" + addressLink.toString());
        pmSendTextToElement(addressLink, address);
        log.info("Entering city" + cityLink.toString());
        pmSendTextToElement(cityLink, city);
        log.info("Selecting the state" + stateLink.toString());
        pmSelectByVisibleTextFromDropDown(stateLink, state);
        log.info("Entering postalcode" + zipPostalLink.toString());
        pmSendTextToElement(zipPostalLink, postcode);
        log.info("Entering contact number" + mobilePhoneLink.toString());
        pmSendTextToElement(mobilePhoneLink, mobileNumber);


    }

    public void clickOnRegister() {
        log.info("Clicking on register link" + registerLink.toString());
        pmClickOnElement(registerLink);
    }
    public void verifyMyAccountText(String message){
        log.info("Verifying the message" + myAccountTextLink.toString());
        pmVerifyElements("Message is not displayed correctly",message, myAccountTextLink );
    }

    public void verifyErrorMessage(String error) {
        log.info("verifying error message : " + errorMessage.toString() );
        Assert.assertTrue(errorMessage.getText().contains(error));
    }

}
