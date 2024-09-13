package com.zebrunner.carina.demo.swaglabs.gui.iospages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductListItemComponent extends AbstractUIObject {

    public ProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ExtendedWebElement getProduct();

    public abstract ExtendedWebElement getProductByIndex(String index);

    public abstract String getProductPrice();

    public abstract String getProductTitle();

    public abstract ExtendedWebElement getProductTitleWebElement();

    public abstract void clickAddToCartButton();

    public abstract ExtendedWebElement getProductPriceWebElement();
}
