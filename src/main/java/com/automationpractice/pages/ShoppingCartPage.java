package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//a[@class='ajax_cart_block_remove_link']")
    WebElement deleteCross;

    @CacheLookup
    @FindBy (xpath = "//b[normalize-space()='Cart']")
    WebElement cartButton;

    @CacheLookup
    @FindBy (xpath = "//span[@title='Close window']")
    WebElement closeShoppingCartWindow;

    public void closeShoppingCartWindow(){
        log.info("closing shopping cart window : " + closeShoppingCartWindow.toString() + "<br>");
        pmClickOnElement(closeShoppingCartWindow);
    }

    public void confirmDeleteIconLogoInShoppingCart(){
        log.info("verifying delete icon : " + deleteCross.toString() + "<br>");
        pmDoMouseHoverNoClick(cartButton);
        pmWaitUntilVisibilityOfElementLocated(By.xpath("//a[@class='ajax_cart_block_remove_link']"), 30);
        //boolean logoPresent = deleteCross.isDisplayed();
        Assert.assertTrue(deleteCross.isDisplayed());
    }

    public void removeItemFromCart(){
        log.info("removing item from cart : " + deleteCross.toString() + "<br>");
        pmClickOnElement(deleteCross);
    }





}
