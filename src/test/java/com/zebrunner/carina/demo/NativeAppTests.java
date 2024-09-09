package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.swaglabs.enums.SortingType;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NativeAppTests implements IAbstractTest {
    @Test(description = "Login with Standard credentials")
    public void correctLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductStorePageBase productStorePageBase = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.accountIsLogged());
    }

    @Test(description = "Try to LogIn with False credentials")
    public void falseCredentialsLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.login("false_sauce", "false_sauce");
        Assert.assertFalse(loginPage.accountIsLogged());
    }

    @Test(description = "Try to LogIn with Missing Username credentials")
    public void missingUserLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.login("", "false_sauce");
        Assert.assertFalse(loginPage.accountIsLogged());
    }

    @Test(description = "Try to LogIn with Missing Password credentials")
    public void missingPasswordLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.login("standard_user", "");
        Assert.assertFalse(loginPage.accountIsLogged());
    }

    @Test(description = "Add items to the cart")
    public void addItemToCartTest() {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        productStorePageBase.addItemToCart();
        Assert.assertTrue(productStorePageBase.wasItemAdded());
        productStorePageBase.addSecondItemToCart();
        Assert.assertFalse(productStorePageBase.wasTwoItemsAdded());
        CartPageBase cartPage = productStorePageBase.tapCartButton();
        Assert.assertFalse(cartPage.isCartEmpty());
    }

    @Test
    public void deleteItemFromCartTest() {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        productStorePageBase.addItemToCart();
        Assert.assertTrue(productStorePageBase.wasItemAdded());
        CartPageBase cartPage = productStorePageBase.tapCartButton();
        cartPage.removeFromCart();
        Assert.assertFalse(productStorePageBase.wasItemAdded());
    }

    @Test
    public void logOutTest() {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        LoginPageBase loginPage = productStorePageBase.logOut();
        Assert.assertFalse(loginPage.accountIsLogged());
    }

    @Test
    public void correctCheckOutTest() {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        CartPageBase cartPage = productStorePageBase.tapCartButton();
        CheckOutPageBase checkOutPageBase = cartPage.tapCheckoutButton();
        OverviewPageBase overviewPageBase = checkOutPageBase.fillData("Test", "Test", "1000");
        CompletePageBase completePageBase = overviewPageBase.tapFinish();
        Assert.assertTrue(completePageBase.isSuccessTextPresent());
    }

    @Test
    public void missingNameCheckOutTest() {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        CartPageBase cartPage = productStorePageBase.tapCartButton();
        CheckOutPageBase checkOutPageBase = cartPage.tapCheckoutButton();
        checkOutPageBase.fillDataTriggerError("", "Test", "1000");
        Assert.assertTrue(checkOutPageBase.errorOnCheckOutTextPresent());
    }


    @Test(description = "Sort Items by price from low to high")
    public void verifyProductSortInAscendingOrder() throws InterruptedException {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        productStorePageBase.sortBy(SortingType.PRICE_LOW_TO_HIGH);
        Thread.sleep(3000);
        Assert.assertTrue(productStorePageBase.areItemsSortedByAscendingPrice());
    }
}
