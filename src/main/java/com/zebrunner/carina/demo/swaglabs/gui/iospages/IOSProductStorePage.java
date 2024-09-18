package com.zebrunner.carina.demo.swaglabs.gui.iospages;

import com.zebrunner.carina.demo.swaglabs.components.ios.IOSFilterComponent;
import com.zebrunner.carina.demo.swaglabs.components.ios.IOSFooterComponent;
import com.zebrunner.carina.demo.swaglabs.enums.SortingType;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.ProductStorePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ExtendedFindBy(iosClassChain = "test-ADD TO CART")
    ExtendedWebElement addToCartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"Selector container\"`][1]")
    IOSFilterComponent filterOption;

    @ExtendedFindBy(iosPredicate = "name == 'test-REMOVE'")
    ExtendedWebElement removeItemButton;

    @ExtendedFindBy(iosPredicate = "label == \"© 2024 Sauce Labs. All Rights Reserved.\"")
    IOSFooterComponent iosFooter;

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
        while (!addToCartButton.isPresent()){
            swipe(addToCartButton);
        }
        addToCartButton.click();
    }

    @Override
    public void addProductsToCartByTitle(List<String> productTitles) {
        Set<String> addedProducts = new HashSet<>();
        int maxIterations = 5;

        while (maxIterations > 0) {
            for (String product : productTitles) {
                if (addedProducts.contains(product)) {
                    continue;
                }
                for (IOSProductList productListItem : products) {
                    try {
                        String productTitle = productListItem.getProductTitle();
                        if (product.equals(productTitle)) {
                            productListItem.clickAddToCartButton();
                            addedProducts.add(product);
                            break;
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (addedProducts.size() == productTitles.size()) {
                break;
            }
            if (!swipe(iosFooter.getAllRightsReservedText(), Direction.UP, 2, 600)) {
                maxIterations--;
            }
        }
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
