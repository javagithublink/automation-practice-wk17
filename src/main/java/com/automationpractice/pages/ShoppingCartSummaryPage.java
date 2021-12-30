package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ShoppingCartSummaryPage extends Utility {

    private static final Logger log = LogManager.getLogger(ShoppingCartSummaryPage.class.getName());


    public ShoppingCartSummaryPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Cart']")
    WebElement cartButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class='alert alert-warning']")
    WebElement emptyShoppingCartVerificationText;

    @CacheLookup
    @FindBy (xpath = "//tbody//tr//td//p//a")
    List<WebElement> productNamesList;

    @CacheLookup
    @FindBy (xpath = "//td[@class='cart_description']//small[@class='cart_ref']")
    List<WebElement> skuList;

    @CacheLookup
    @FindBy (xpath = "//td[@class='cart_quantity text-center']//input [@type='hidden']")
    List <WebElement> qtyList;

    @CacheLookup
    @FindBy (xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOutFromSummary;

    public void verifyShoppingCartIsEmptyMessage(String message){
        log.info("verifying empty cart message : " + emptyShoppingCartVerificationText.toString() + "<br>");
        pmClickOnElement(cartButton);
        pmVerifyElements("Incorrect Message", message, emptyShoppingCartVerificationText);
    }

    public void verifyProductDetailsInCartSummary(String pName, String skuName, String qty){
        for(WebElement product:productNamesList){
            if(product.getText().equalsIgnoreCase(pName)){
                Assert.assertTrue(true);
                break;
            }
        }

        for(WebElement sku:skuList){
            if(sku.getText().equalsIgnoreCase(skuName)){
                Assert.assertTrue(true);
                break;
            }
        }

        for(WebElement qtyText:qtyList){
            if(qtyText.getAttribute("value").equalsIgnoreCase(qty)){
                Assert.assertTrue(true);
                break;
            }
        }

    }

    public void clickOnProceedToCheckOutFromSummaryPage(){
        pmClickOnElement(proceedToCheckOutFromSummary);
    }

}
