package com.zebrunner.carina.demo.swaglabs.gui.iospages;

import com.zebrunner.carina.demo.swaglabs.components.ios.IOSFilterComponent;
import com.zebrunner.carina.demo.swaglabs.enums.SortingType;
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

    @ExtendedFindBy(iosPredicate = "name == 'test-LOGOUT'")
    ExtendedWebElement logOutButton;

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

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"Selector container\"`][1]")
    IOSFilterComponent filterOption;

    @ExtendedFindBy(iosPredicate = "name == 'test-REMOVE'")
    ExtendedWebElement removeItemButton;

    protected IOSProductStorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IOSCartPage tapCartButton() {
        cartButton.click();
        return new IOSCartPage(driver);
    }

    @Override
    public void tapMenuButton() {
        menuButton.click();
    }

    @Override
    public IOSLoginPage logOut() {
        tapMenuButton();
        logOutButton.click();
        return new IOSLoginPage(driver);
    }

    @Override
    public void addItemToCart() {
        addToCartButton.click();
    }

    @Override
    public void addSecondItemToCart() {
        addToCartSecondProductButton.click();
    }

    @Override
    public void removeItemFromCart() {

    }

    @Override
    public boolean wasItemAdded() {
        return cartWithItemAdded.isPresent();
    }

    @Override
    public boolean wasTwoItemsAdded() {
        return cartWithTwoItemAdded.isPresent();
    }

    @Override
    public boolean areItemsSortedBy(SortingType sortingType) {
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

    @Override
    public void sortBy(SortingType sortingType) {
        filterButton.click();
        filterOption.sortBy(sortingType);
    }


    @Override
    public void removeFromCart() {
        removeItemButton.click();
    }
}
