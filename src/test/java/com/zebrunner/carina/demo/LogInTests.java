package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.LoginPageBase;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.ProductStorePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends AbstractTest {
    @Test(description = "Login with Standard credentials")
    public void correctLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductStorePageBase productStorePageBase = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.accountIsLogged(), "Account is not logged in");
    }

    @Test(description = "Try to LogIn with False credentials")
    public void falseCredentialsLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.login("false_sauce", "false_sauce");
        Assert.assertFalse(loginPage.accountIsLogged(), "Error message for credentials should be displayed");
    }

    @Test(description = "Try to LogIn with Missing Username credentials")
    public void missingUserLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.login("", "false_sauce");
        Assert.assertFalse(loginPage.accountIsLogged(), "Error message for Name credentials should be displayed");
    }

    @Test(description = "Try to LogIn with Missing Password credentials")
    public void missingPasswordLoginTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.login("standard_user", "");
        Assert.assertFalse(loginPage.accountIsLogged(), "Error message for Password credentials should be displayed");
    }
}
