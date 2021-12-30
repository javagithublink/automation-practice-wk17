package com.automationpractice.steps;

import com.automationpractice.pages.ProductPage;
import com.automationpractice.pages.ShoppingCartSummaryPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

public class AddProductSteps {
    @And("^I add below product to cart$")
    public void iAddBelowProductToCart(DataTable dataTable) {
        List<List<String>> products = dataTable.asLists(String.class);


            for (List<String> e : products.subList(1,products.size())) {
                new ProductPage().selectProducts(e.get(0), e.get(1), e.get(2), e.get(3), e.get(4));

                new ProductPage().clickOnAddToCartButton();
                new ProductPage().clickOnProceedToCheckOutButton();
            }



    }


    @Then("^I shall validate shopping cart as below$")
    public void iShallValidateShoppingCartAsBelow(DataTable dataTable) {
        List<List<String>> verifyProducts = dataTable.asLists(String.class);

            for (List<String> f : verifyProducts.subList(1,verifyProducts.size())) {

                new ShoppingCartSummaryPage().verifyProductDetailsInCartSummary(f.get(0), f.get(1), f.get(2));


        }
    }
}
