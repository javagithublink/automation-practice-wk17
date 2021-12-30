package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends Utility {
    private static final Logger log = LogManager.getLogger(MyAccountPage.class.getName());

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (css = "a[title='View my customer account'] span")
    WebElement accountNameVerification;

    @CacheLookup
    @FindBy (xpath = "//span[normalize-space()='My addresses']")
    WebElement myAddressesTab;

    @CacheLookup
    @FindBy (xpath = "//span[@class='address_address1']")
    WebElement addressText;

    @CacheLookup
    @FindBy (xpath = "//a[@title='Log me out']")
    WebElement logOutTab;

    public void verifyUserCanSeeAccountNameOnTopRight(String expectedName){
        log.info("verify the account name : " + accountNameVerification.toString());
        pmVerifyElements("Incorrect Account", expectedName, accountNameVerification);
    }

    public void verifyUserAddressUnderMyAddressesSection(){
        pmClickOnElement(myAddressesTab);
        String expected = "123 Abc Street";
        String actual = pmGetTextFromElement(addressText);
        Assert.assertTrue(actual.contains(expected));
    }

    public void userCanLogOut(){
        pmClickOnElement(logOutTab);
    }
}
