package com.zebrunner.carina.demo.swaglabs.gui.commonpages;

import com.zebrunner.carina.demo.swaglabs.enums.SortingType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductStorePageBase extends AbstractPage implements IMobileUtils {
    protected ProductStorePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase tapCartButton();

    public abstract void tapMenuButton();

    public abstract void addItemToCart();

    public abstract LoginPageBase logOut();

    public abstract void removeItemFromCart();

    public abstract boolean wasItemAdded();

    public abstract boolean wasTwoItemsAdded();

    public abstract void addSecondItemToCart();

    public abstract boolean areItemsSortedBy(SortingType sortingType);

    public abstract void sortBy(SortingType sortingType);

    public abstract void removeFromCart();
}
