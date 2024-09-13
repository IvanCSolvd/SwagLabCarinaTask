package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.CartPageBase;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.ProductStorePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends AbstractTest {
    @Test(description = "Add items to the cart")
    public void addItemToCartTest() {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        productStorePageBase.addItemToCart();
        Assert.assertTrue(productStorePageBase.wasItemAdded(), "Items was not added to the cart");
        productStorePageBase.addSecondItemToCart();
        Assert.assertFalse(productStorePageBase.wasTwoItemsAdded(),"Second items were not added to the cart");
        CartPageBase cartPage = productStorePageBase.tapCartButton();
        Assert.assertFalse(cartPage.isCartEmpty(), "Cart is empty");
    }

    @Test
    public void deleteItemFromCartTest() {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        productStorePageBase.addItemToCart();
        Assert.assertTrue(productStorePageBase.wasItemAdded(),"Items was not added to the cart");
        CartPageBase cartPage = productStorePageBase.tapCartButton();
        cartPage.removeFromCart();
        Assert.assertFalse(productStorePageBase.wasItemAdded(), "Item is still present in the cart");
    }
}
