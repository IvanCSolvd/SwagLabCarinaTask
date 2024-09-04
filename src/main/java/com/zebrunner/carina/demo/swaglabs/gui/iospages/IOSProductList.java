package com.zebrunner.carina.demo.swaglabs.gui.iospages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IOSProductList extends ProductListItemComponent {
    public IOSProductList(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public ExtendedWebElement getProduct() {
        return null;
    }

    @Override
    public ExtendedWebElement getProductByIndex(String index) {
        return null;
    }

    @Override
    public String getProductPrice() {
        return "";
    }

    @Override
    public String getProductTitle() {
        return "";
    }

    @Override
    public WebElement getProductTitleWebElement() {
        return null;
    }

    @Override
    public void clickAddToCartButton() {

    }

    @Override
    public ExtendedWebElement getProductPriceWebElement() {
        return null;
    }
}
