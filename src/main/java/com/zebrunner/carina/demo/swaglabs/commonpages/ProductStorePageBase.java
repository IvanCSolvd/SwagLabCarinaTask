package com.zebrunner.carina.demo.swaglabs.commonpages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductStorePageBase extends AbstractPage {
    protected ProductStorePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase tapCartButton();
}
