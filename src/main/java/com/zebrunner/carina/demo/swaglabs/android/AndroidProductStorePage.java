package com.zebrunner.carina.demo.swaglabs.android;

import com.zebrunner.carina.demo.swaglabs.commonpages.ProductStorePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductStorePageBase.class)
public class AndroidProductStorePage extends ProductStorePageBase {
    @ExtendedFindBy()
    ExtendedWebElement menuButton;

    @ExtendedFindBy()
    ExtendedWebElement cartButton;

    @ExtendedFindBy()
    ExtendedWebElement filterButton;

    @ExtendedFindBy()
    List<ExtendedWebElement> products;

    protected AndroidProductStorePage(WebDriver driver) {
        super(driver);
    }

    public AndroidCartPage tapCartButton() {
        cartButton.click();
        return new AndroidCartPage(driver);
    }

    public void tapMenuButton() {
        menuButton.click();
    }

    public void filterByASCName(){
        filterButton.click();
        //todo: Add filter by name a-z
    }

    public void filterByDESCName(){
        filterButton.click();
        //todo: Add filter by name z-a
    }

    public void filterByASCPrice(){
        filterButton.click();
        //todo: Add filter by price low to high
    }

    public void filterByDESCPrice(){
        filterButton.click();
        //todo: Add filter by price high to low
    }
}
