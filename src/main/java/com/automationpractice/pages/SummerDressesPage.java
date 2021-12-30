package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SummerDressesPage extends Utility {

    private static final Logger log = LogManager.getLogger(SummerDressesPage.class.getName());


    public SummerDressesPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Printed Chiffon Dress']")
    WebElement printedChiffonDress;

    @CacheLookup
    @FindBy(xpath = "(//span[@class='cat-name'])[1]")
    WebElement summerDressesPageVerificationText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='layered_price_slider']")
    WebElement mainSlider;

    @CacheLookup
    @FindBy(xpath = "//div[@id='left_column']//a[2]")
    WebElement slider;

    public void addPrintedChiffonDressToCart() {
        pmClickOnElement(printedChiffonDress);
        pmClickOnElement(addToCart);
    }

    public void verifySummerDressesPageVerificationText(String message){
       log.info("verifying summer page text : " + summerDressesPageVerificationText.toString());
        pmVerifyElements("Incorrect page", message, summerDressesPageVerificationText);
    }

    public void moveSliderToChangePrice(){
        log.info("moving slider to change price : " + slider.toString() );
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, -183, 0).build().perform();
    }

}
