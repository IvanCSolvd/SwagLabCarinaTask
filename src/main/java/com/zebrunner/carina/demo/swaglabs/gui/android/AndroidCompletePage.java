package com.zebrunner.carina.demo.swaglabs.gui.android;

import com.zebrunner.carina.demo.swaglabs.gui.commonpages.CompletePageBase;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.ProductStorePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CompletePageBase.class)
public class AndroidCompletePage extends CompletePageBase {
    @ExtendedFindBy(accessibilityId = "test-BACK HOME")
    ExtendedWebElement goHomeButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().text('THANK YOU FOR YOU ORDER')")
    ExtendedWebElement successText;

    protected AndroidCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSuccessTextPresent() {
        return successText.isPresent();
    }

    @Override
    public ProductStorePageBase goBackHome() {
        goHomeButton.click();
        return new AndroidProductStorePage(driver);
    }
}
