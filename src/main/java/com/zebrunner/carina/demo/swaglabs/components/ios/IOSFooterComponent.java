package com.zebrunner.carina.demo.swaglabs.components.ios;

import com.zebrunner.carina.demo.swaglabs.components.common.FooterComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class IOSFooterComponent extends FooterComponent {

    @ExtendedFindBy(iosPredicate = "label == \"© 2024 Sauce Labs. All Rights Reserved.\"")
    ExtendedWebElement allRightsReservedText;

    public IOSFooterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public ExtendedWebElement getAllRightsReservedText() {
        return allRightsReservedText;
    }
}
