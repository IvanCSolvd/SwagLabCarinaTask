package com.zebrunner.carina.demo.swaglabs.gui.commonpages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class OverviewPageBase extends AbstractPage {
    protected OverviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CompletePageBase tapFinish();

    public abstract CheckOutPageBase goBack();
}
