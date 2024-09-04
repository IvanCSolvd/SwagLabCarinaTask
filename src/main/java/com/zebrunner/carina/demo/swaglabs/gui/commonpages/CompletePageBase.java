package com.zebrunner.carina.demo.swaglabs.gui.commonpages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CompletePageBase extends AbstractPage {
    protected CompletePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isSuccessTextPresent();

    public abstract ProductStorePageBase goBackHome();
}
