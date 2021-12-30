package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AuthenticationPage extends Utility {

    private static final Logger log = LogManager.getLogger(AuthenticationPage.class.getName());


    public AuthenticationPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (id = "email_create")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAnAccount;

    @CacheLookup
    @FindBy (xpath = "//input[@id='passwd']")
    WebElement registeredPasswordField;

    @CacheLookup
    @FindBy (xpath = "//input[@id='email']")
    WebElement registeredEmailAddressField;

    @CacheLookup
    @FindBy (xpath = "//span[normalize-space()='Sign in']")
    WebElement signInButton;

    public static String emailAddress = randomString();

    public void enterRandomEmailInTheEmailAddressField(){
        log.info("entering random email : "+"<br>");
        pmSendTextToElement(emailAddressField, emailAddress+"@gmail.com");

    }

    public void clickOnCreateAnAccountTab(){
        log.info("Click on the create an account tab : " + createAnAccount.toString() + "<br>");
        pmClickOnElement(createAnAccount);

    }

    public void enterRegisteredEmailAddress(){
        pmSendTextToElement(registeredEmailAddressField,emailAddress+"@gmail.com");
    }

    public void enterRegisteredPassword(){
        pmSendTextToElement(registeredPasswordField,"abc12456");
    }

    public void clickOnSignInButton(){
        pmClickOnElement(signInButton);
    }
}
