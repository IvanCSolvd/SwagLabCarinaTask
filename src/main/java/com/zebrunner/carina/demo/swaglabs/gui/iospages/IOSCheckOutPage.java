package com.zebrunner.carina.demo.swaglabs.gui.iospages;

import com.zebrunner.carina.demo.swaglabs.gui.commonpages.CheckOutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutPageBase.class)
public class IOSCheckOutPage extends CheckOutPageBase {
    @ExtendedFindBy(iosPredicate = "name == 'test-First Name'")
    ExtendedWebElement nameInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-Last Name'")
    ExtendedWebElement lastNameInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-Zip/Postal Code'")
    ExtendedWebElement postalCodeInput;

    @ExtendedFindBy(iosPredicate = "name == 'test-CANCEL'")
    ExtendedWebElement cancelButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-CONTINUE'")
    ExtendedWebElement continueButton;

    @ExtendedFindBy(iosPredicate = "name == 'First Name is required'")
    ExtendedWebElement errorOnCheckOutText;

    protected IOSCheckOutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IOSOverviewPage fillData(String firstName, String lastName, String zipCode) {
        nameInput.type(firstName);
        lastNameInput.type(lastName);
        postalCodeInput.type(zipCode);
        continueButton.click();
        return new IOSOverviewPage(driver);
    }

    @Override
    public void fillDataTriggerError(String firstName, String lastName, String zipCode) {
        nameInput.type(firstName);
        lastNameInput.type(lastName);
        postalCodeInput.type(zipCode);
        continueButton.click();
    }

    @Override
    public IOSCartPage goBack() {
        cancelButton.click();
        return new IOSCartPage(driver);
    }

    @Override
    public boolean errorOnCheckOutTextPresent() {
        return errorOnCheckOutText.isPresent();
    }
}
