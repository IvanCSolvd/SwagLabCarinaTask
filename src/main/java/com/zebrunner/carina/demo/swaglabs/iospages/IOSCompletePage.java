package com.zebrunner.carina.demo.swaglabs.iospages;

import com.zebrunner.carina.demo.swaglabs.commonpages.CheckOutPageBase;
import com.zebrunner.carina.demo.swaglabs.commonpages.CompletePageBase;
import com.zebrunner.carina.demo.swaglabs.commonpages.ProductStorePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CompletePageBase.class)
public class IOSCompletePage extends CompletePageBase {
    @ExtendedFindBy()
    ExtendedWebElement goHomeButton;

    @ExtendedFindBy()
    ExtendedWebElement successText;
    protected IOSCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSuccessTextPresent() {
        return successText.isPresent();
    }

    @Override
    public ProductStorePageBase goBackHome() {
        goHomeButton.click();
        return new IOSProductStorePage(driver);
    }
}
