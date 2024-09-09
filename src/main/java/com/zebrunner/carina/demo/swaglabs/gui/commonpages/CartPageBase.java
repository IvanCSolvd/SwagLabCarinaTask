package com.zebrunner.carina.demo.swaglabs.gui.commonpages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {
    protected CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductStorePageBase tapContinueShoppingButton();

    public abstract CheckOutPageBase tapCheckoutButton();

    public abstract void removeFromCart();

    public abstract boolean isCartEmpty();
}
