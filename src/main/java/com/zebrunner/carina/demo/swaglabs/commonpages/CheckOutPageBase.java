package com.zebrunner.carina.demo.swaglabs.commonpages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutPageBase  extends AbstractPage {
    protected CheckOutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract OverviewPageBase fillData(String firstName, String lastName, String zipCode);

    public abstract CartPageBase goBack();
}
