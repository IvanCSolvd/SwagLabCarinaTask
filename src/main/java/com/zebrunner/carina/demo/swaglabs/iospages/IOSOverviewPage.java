package com.zebrunner.carina.demo.swaglabs.iospages;

import com.zebrunner.carina.demo.swaglabs.commonpages.CheckOutPageBase;
import com.zebrunner.carina.demo.swaglabs.commonpages.CompletePageBase;
import com.zebrunner.carina.demo.swaglabs.commonpages.LoginPageBase;
import com.zebrunner.carina.demo.swaglabs.commonpages.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = OverviewPageBase.class)
public class IOSOverviewPage extends OverviewPageBase {
    @ExtendedFindBy(iosPredicate = "name == 'test-CANCEL'")
    ExtendedWebElement cancelButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-FINISH'")
    ExtendedWebElement finishButton;

    protected IOSOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IOSCompletePage tapFinish() {
        finishButton.click();
        return new IOSCompletePage(driver);
    }

    @Override
    public IOSCheckOutPage goBack() {
        cancelButton.click();
        return new IOSCheckOutPage(driver);
    }
}
