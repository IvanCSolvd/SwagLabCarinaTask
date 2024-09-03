package com.zebrunner.carina.demo.swaglabs.android;

import com.zebrunner.carina.demo.swaglabs.commonpages.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class AndroidCartPage extends CartPageBase {

    @ExtendedFindBy()
    ExtendedWebElement continueShoppingCartButton;

    @ExtendedFindBy()
    ExtendedWebElement checkoutButton;

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
}
