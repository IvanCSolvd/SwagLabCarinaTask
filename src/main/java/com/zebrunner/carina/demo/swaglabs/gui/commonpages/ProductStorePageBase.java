package com.zebrunner.carina.demo.swaglabs.gui.commonpages;

import com.zebrunner.carina.demo.swaglabs.enums.SortingType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductStorePageBase extends AbstractPage implements IMobileUtils {
    protected ProductStorePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase tapCartButton();

    public abstract void tapMenuButton();

    public abstract void addItemToCart();

    public abstract LoginPageBase logOut();

    public abstract boolean areItemsSortedBy(SortingType sortingType);

    public abstract void sortBy(SortingType sortingType);

    public abstract void removeFromCart();

    public abstract void addProductsToCartByTitle(List<String> productTitles);

}
