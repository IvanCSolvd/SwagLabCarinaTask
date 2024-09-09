package com.zebrunner.carina.demo.swaglabs.gui.android;

import com.zebrunner.carina.demo.swaglabs.gui.commonpages.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class AndroidCartPage extends CartPageBase {

    @ExtendedFindBy(accessibilityId = "test-CONTINUE SHOPPING")
    ExtendedWebElement continueShoppingCartButton;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    ExtendedWebElement checkoutButton;

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    ExtendedWebElement removeFromCartButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description('test-Item').instance(0)")
    ExtendedWebElement item1InCart;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description('test-Item').instance(1)")
    ExtendedWebElement item2InCart;

    protected AndroidCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AndroidProductStorePage tapContinueShoppingButton() {
        continueShoppingCartButton.click();
        return new AndroidProductStorePage(driver);
    }

    @Override
    public AndroidCheckOutPage tapCheckoutButton() {
        checkoutButton.click();
        return new AndroidCheckOutPage(driver);
    }

    @Override
    public void removeFromCart() {
        removeFromCartButton.click();
    }

    @Override
    public boolean isCartEmpty() {
        return !item1InCart.isPresent() && !item2InCart.isPresent();
    }


}
