package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OurStoresPage extends Utility {
    private static final Logger log = LogManager.getLogger(OurStoresPage.class.getName());


    public OurStoresPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (css = ".dismissButton")
    WebElement dismissAlert;

    @CacheLookup
    @FindBy (xpath = "//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[@id='map']/div/div[@class='gm-style']/div[@aria-label='Map']/div[1]/div[1]/div[1]")
    WebElement map;

    public void acceptTheGooglePopUpAlert(){
        log.info("accepting the alert : " + dismissAlert.toString());
        pmClickOnElement(dismissAlert);
    }

    public void scrollMapToSeeWestPalmBeach(){

        pmDoMouseHoverNoClick(map);
        Actions actions = new Actions(driver);
        Action movement = actions.moveToElement(map)
                .clickAndHold()
                .moveToElement(map, -100, -670)
                .release(map)
                .build();
        movement.perform();
    }

    public void scrollPageDown() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 500);");
    }

    public void takeScreenshot(){
        log.info("taking screenshot" );
        takeScreenShot("OurStores Screenshot");
    }
}
