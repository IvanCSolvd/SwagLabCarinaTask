package com.zebrunner.carina.demo.swaglabs.gui.android;

import com.zebrunner.carina.demo.swaglabs.gui.commonpages.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class AndroidLoginPage extends LoginPageBase {
    @ExtendedFindBy(androidUIAutomator = "new UiSelector().text('Username')")
    ExtendedWebElement userInput;

    @ExtendedFindBy(accessibilityId = "test-Password")
    ExtendedWebElement passwordInput;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    ExtendedWebElement submitButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className('android.widget.ImageView').instance(0)")
    ExtendedWebElement logo;

    @ExtendedFindBy(image = "images/SwagLabMascot.png")
    ExtendedWebElement mascotImage;

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

    @Override
    public boolean isMascotPresent() {
        return mascotImage.isPresent();
    }
}
