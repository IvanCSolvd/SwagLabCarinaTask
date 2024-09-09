package com.zebrunner.carina.demo.swaglabs.gui.android;

import com.zebrunner.carina.demo.swaglabs.gui.commonpages.CheckOutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutPageBase.class)
public class AndroidCheckOutPage extends CheckOutPageBase {
    @ExtendedFindBy(accessibilityId = "test-First Name")
    ExtendedWebElement nameInput;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    ExtendedWebElement lastNameInput;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    ExtendedWebElement postalCodeInput;

    @ExtendedFindBy(accessibilityId = "test-CANCEL")
    ExtendedWebElement cancelButton;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    ExtendedWebElement continueButton;

    @ExtendedFindBy(accessibilityId = "test-Error message")
    ExtendedWebElement errorOnCheckOutText;

    protected AndroidCheckOutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AndroidOverviewPage fillData(String firstName, String lastName, String zipCode) {
        nameInput.type(firstName);
        lastNameInput.type(lastName);
        postalCodeInput.type(zipCode);
        continueButton.click();
        return new AndroidOverviewPage(driver);
    }

    @Override
    public AndroidCartPage goBack() {
        cancelButton.click();
        return new AndroidCartPage(driver);
    }

    @Override
    public void fillDataTriggerError(String firstName, String lastName, String zipCode) {
        nameInput.type(firstName);
        lastNameInput.type(lastName);
        postalCodeInput.type(zipCode);
        continueButton.click();
    }

    @Override
    public boolean errorOnCheckOutTextPresent() {
        return errorOnCheckOutText.isPresent();
    }
}
