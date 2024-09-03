package com.zebrunner.carina.demo.swaglabs.commonpages;

import com.zebrunner.carina.demo.swaglabs.iospages.IOSProductStorePage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    protected LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductStorePageBase login(String username, String password);

    public abstract boolean accountIsLogged();
}
