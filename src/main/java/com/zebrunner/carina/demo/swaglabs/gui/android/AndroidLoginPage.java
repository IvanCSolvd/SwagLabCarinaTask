package com.zebrunner.carina.demo.swaglabs.gui.android;

import com.zebrunner.carina.demo.swaglabs.gui.commonpages.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class AndroidLoginPage extends LoginPageBase {
    @ExtendedFindBy()
    ExtendedWebElement userInput;

    @ExtendedFindBy()
    ExtendedWebElement passwordInput;

    @ExtendedFindBy()
    ExtendedWebElement submitButton;

    @ExtendedFindBy()
    ExtendedWebElement logo;

    protected AndroidLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AndroidProductStorePage login(String username, String password) {
        userInput.type(username);
        passwordInput.type(password);
        submitButton.click();
        return new AndroidProductStorePage(driver);
    }

    @Override
    public boolean accountIsLogged() {
        return !logo.isPresent();
    }
}
