package com.zebrunner.carina.demo.swaglabs.gui.iospages;

import com.zebrunner.carina.demo.swaglabs.gui.commonpages.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class IOSCartPage extends CartPageBase {

    @ExtendedFindBy(iosPredicate = "name == 'test-CONTINUE SHOPPING'")
    ExtendedWebElement continueShoppingCartButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-CHECKOUT'")
    ExtendedWebElement checkoutButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-REMOVE'")
    ExtendedWebElement removeFromCartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`][1]")
    ExtendedWebElement item1InCart;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`][2]")
    ExtendedWebElement item2InCart;

    protected IOSCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IOSProductStorePage tapContinueShoppingButton() {
        continueShoppingCartButton.click();
        return new IOSProductStorePage(driver);
    }

    @Override
    public IOSCheckOutPage tapCheckoutButton() {
        checkoutButton.click();
        return new IOSCheckOutPage(driver);
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
