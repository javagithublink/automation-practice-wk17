package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy (xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li//a")
    List<WebElement> categoryList;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Printed Dress']")
    WebElement printedDressName;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Faded Short Sleeve T-shirts']")
    WebElement sSTShirt;

    @CacheLookup
    @FindBy (xpath = "//ul[@class='product_list grid row']//li//h5//a")
    List<WebElement> casualDressList;

    @CacheLookup
    @FindBy (xpath = "//ul[@class='product_list grid row']//li//h5//a")
    List<WebElement> TopsList;

    @CacheLookup
    @FindBy (xpath = "//ul[@class='product_list grid row']//li//h5//a")
    List<WebElement> productList;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Printed Dress']")
    WebElement moreDetailsTab;

    @CacheLookup
    @FindBy (xpath = "//p[@id='product_reference']//span")
    List<WebElement> modelNameList;

    @CacheLookup
    @FindBy (xpath = "//input[@id='quantity_wanted']")
    WebElement qtyText;

    @CacheLookup
    @FindBy (xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy (xpath = "//span[normalize-space()='Proceed to checkout']")
    WebElement proceedToCheckOutButton;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectProducts(String category, String subCategory, String name, String model, String qty){

        for(WebElement category1: categoryList){
            if (category1.getText().equalsIgnoreCase(category)){
                pmDoMouseHoverNoClick(category1);
                for (WebElement subCategory1:categoryList){
                 if(subCategory1.getText().equalsIgnoreCase(subCategory)) {
                     pmClickOnElement(subCategory1);
                     break;
                 }
                 }
                break;
            }
        }

        for (WebElement productName: productList){
            if(productName.getText().equalsIgnoreCase(name)){
                pmClickOnElement(productName);
                break;
            }

        }

     /*   if(name.equalsIgnoreCase(printedDressName.getText())){
            pmClickOnElement(printedDressName);
        }*/

        for (WebElement modelName:modelNameList){
            if (modelName.getText().equalsIgnoreCase(model)){
                Assert.assertTrue(true);
            }

        }

        /*if (model.equalsIgnoreCase(modelName.getText())){
            Assert.assertTrue(true);
        }*/

        pmFindElementAndClearText(qtyText);
        pmSendTextToElement(qtyText,qty.trim());

    }

    public void clickOnAddToCartButton(){
        pmClickOnElement(addToCartButton);
    }

    public void clickOnProceedToCheckOutButton(){
        pmClickOnElement(proceedToCheckOutButton);
    }


}
