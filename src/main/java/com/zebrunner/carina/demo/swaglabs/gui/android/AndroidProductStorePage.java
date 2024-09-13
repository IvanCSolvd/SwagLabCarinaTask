package com.zebrunner.carina.demo.swaglabs.gui.android;

import com.zebrunner.carina.demo.swaglabs.components.ios.IOSFilterComponent;
import com.zebrunner.carina.demo.swaglabs.enums.SortingType;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.LoginPageBase;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.ProductStorePageBase;
import com.zebrunner.carina.demo.swaglabs.gui.iospages.IOSProductList;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductStorePageBase.class)
public class AndroidProductStorePage extends ProductStorePageBase {
    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
    ExtendedWebElement menuButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(3)")
    ExtendedWebElement cartButton;

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    ExtendedWebElement logOutButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Cart\")")
    ExtendedWebElement filterButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Item\")")
    List<IOSProductList> products;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description('test-ADD TO CART').instance(0)")
    ExtendedWebElement addToCartButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description('test-ADD TO CART').instance(1)")
    ExtendedWebElement addToCartSecondProductButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className('android.widget.ImageView').instance(3)")
    ExtendedWebElement cartWithItemAdded;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().text('2')")
    ExtendedWebElement cartWithTwoItemAdded;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className('android.widget.ImageView').instance(5)")
    IOSFilterComponent filterOption;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description('test-REMOVE').instance(0)")
    ExtendedWebElement removeItemButton;

    protected AndroidProductStorePage(WebDriver driver) {
        super(driver);
    }

    public AndroidCartPage tapCartButton() {
        cartButton.click();
        return new AndroidCartPage(driver);
    }

    @Override
    public void addItemToCart() {
        addToCartButton.click();
    }

    @Override
    public LoginPageBase logOut() {
        tapMenuButton();
        logOutButton.click();
        return new AndroidLoginPage(driver);
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
    public void addSecondItemToCart() {
        addToCartSecondProductButton.click();
    }

    //todo: add logic to use the parameter to check sorting
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

    public void tapMenuButton() {
        menuButton.click();
    }
}
