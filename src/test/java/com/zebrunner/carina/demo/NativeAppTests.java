package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.CartPageBase;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.LoginPageBase;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.ProductStorePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NativeAppTests implements IAbstractTest {
    @Test(description = "Login with Standard credentials")
    public void CorrectLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductStorePageBase productStorePageBase = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.accountIsLogged());
    }

    @Test(description = "Try to LogIn with False credentials")
    public void FalseCredentialsLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.login("false_sauce", "false_sauce");
        Assert.assertFalse(loginPage.accountIsLogged());
    }

    @Test(description = "Try to LogIn with Missing Username credentials")
    public void MissingUserLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.login("", "false_sauce");
        Assert.assertFalse(loginPage.accountIsLogged());
    }

    @Test(description = "Try to LogIn with Missing Password credentials")
    public void MissingPasswordLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.login("standard_user", "");
        Assert.assertFalse(loginPage.accountIsLogged());
    }

    @Test(description = "Add items to the cart")
    public void AddItemToCartTest() {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        productStorePageBase.addItemToCart();
        Assert.assertTrue(productStorePageBase.wasItemAdded());
        productStorePageBase.addSecondItemToCart();
        Assert.assertFalse(productStorePageBase.wasTwoItemsAdded());
        CartPageBase cartPage = productStorePageBase.tapCartButton();
    }
}
