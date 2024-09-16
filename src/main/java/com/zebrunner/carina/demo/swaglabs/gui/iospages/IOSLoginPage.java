package com.zebrunner.carina.demo.swaglabs.gui.iospages;

import com.zebrunner.carina.demo.swaglabs.gui.commonpages.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class IOSLoginPage extends LoginPageBase {
    @ExtendedFindBy(iosPredicate = "name == 'test-Username'")
    ExtendedWebElement userInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-Password'")
    ExtendedWebElement passwordInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-LOGIN'")
    ExtendedWebElement submitButton;

    @ExtendedFindBy(iosPredicate = "name == 'assets/src/img/swag-labs-logo.png'")
    ExtendedWebElement logo;

    @ExtendedFindBy(image = "images/SwagLabMascot.png")
    ExtendedWebElement mascotImage;

    protected IOSLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IOSProductStorePage login(String username, String password) {
        userInput.type(username);
        passwordInput.type(password);
        submitButton.click();
        return new IOSProductStorePage(driver);
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
