package com.zebrunner.carina.demo.swaglabs.iospages;

import com.zebrunner.carina.demo.swaglabs.commonpages.CartPageBase;
import com.zebrunner.carina.demo.swaglabs.commonpages.LoginPageBase;
import com.zebrunner.carina.demo.swaglabs.commonpages.ProductStorePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductStorePageBase.class)
public class IOSProductStorePage extends ProductStorePageBase {
    @ExtendedFindBy(iosPredicate = "name == 'test-Menu'")
    ExtendedWebElement menuButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Cart'")
    ExtendedWebElement cartButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Modal Selector Button'")
    ExtendedWebElement filterButton;

    @ExtendedFindBy(iosPredicate = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    List<ExtendedWebElement> products;

    protected IOSProductStorePage(WebDriver driver) {
        super(driver);
    }

    public IOSCartPage tapCartButton() {
        cartButton.click();
        return new IOSCartPage(driver);
    }
}
