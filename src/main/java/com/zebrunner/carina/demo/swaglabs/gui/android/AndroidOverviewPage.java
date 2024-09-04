package com.zebrunner.carina.demo.swaglabs.gui.android;

import com.zebrunner.carina.demo.swaglabs.gui.commonpages.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OverviewPageBase.class)
public class AndroidOverviewPage extends OverviewPageBase {
    @ExtendedFindBy()
    ExtendedWebElement cancelButton;

    @ExtendedFindBy()
    ExtendedWebElement finishButton;

    protected AndroidOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AndroidCompletePage tapFinish() {
        finishButton.click();
        return new AndroidCompletePage(driver);
    }

    @Override
    public AndroidCheckOutPage goBack() {
        cancelButton.click();
        return new AndroidCheckOutPage(driver);
    }
}
