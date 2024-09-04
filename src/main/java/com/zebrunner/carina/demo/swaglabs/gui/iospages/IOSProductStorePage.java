package com.zebrunner.carina.demo.swaglabs.gui.iospages;

import com.zebrunner.carina.demo.swaglabs.gui.commonpages.ProductStorePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductStorePageBase.class)
public class IOSProductStorePage extends ProductStorePageBase {
    @ExtendedFindBy(iosPredicate = "name == 'test-Menu'")
    ExtendedWebElement menuButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Cart'")
    ExtendedWebElement cartButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Modal Selector Button'")
    ExtendedWebElement filterButton;

    @ExtendedFindBy(iosPredicate = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    List<IOSProductList> products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`][1]")
    ExtendedWebElement addToCartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == '1'`][4]")
    ExtendedWebElement addToCartSecondProductButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`][1]")
    ExtendedWebElement cartWithItemAdded;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`][2]")
    ExtendedWebElement cartWithTwoItemAdded;


    protected IOSProductStorePage(WebDriver driver) {
        super(driver);
    }

    public IOSCartPage tapCartButton() {
        cartButton.click();
        return new IOSCartPage(driver);
    }

    public void addItemToCart() {
        addToCartButton.click();
    }

    public void addSecondItemToCart() {
        addToCartSecondProductButton.click();
    }

    @Override
    public void removeItemFromCart() {

    }

    @Override
    public boolean wasItemAdded() {
        return cartWithItemAdded.clickIfPresent();
    }

    @Override
    public boolean wasTwoItemsAdded() {
        return cartWithItemAdded.clickIfPresent();
    }

    @Override
    public boolean areItemsSortedByAscendingPrice() {
        List<Long> prices = new ArrayList<>();
        for (IOSProductList productListItem : products
        ) {
            try {
                if (productListItem.getProductPriceWebElement().isElementPresent()) {
                    String priceString = productListItem.getProductPrice();
                    Long price = Long.parseLong(priceString);
                    if (!prices.contains(price)) {
                        prices.add(price);
                    } else {
                        break;
                    }
                } else {
                    swipe(productListItem.getProductPriceWebElement());
                    String priceString = productListItem.getProductPrice();
                    Long price = Long.parseLong(priceString);
                    if (!prices.contains(price)) {
                        prices.add(price);
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
