package com.zebrunner.carina.demo.swaglabs.commonpages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {
    protected CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductStorePageBase tapContinueShoppingButton();

    public abstract CheckOutPageBase tapCheckoutButton();
}
