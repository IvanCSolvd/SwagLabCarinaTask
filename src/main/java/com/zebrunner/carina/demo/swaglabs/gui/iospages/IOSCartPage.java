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
}
