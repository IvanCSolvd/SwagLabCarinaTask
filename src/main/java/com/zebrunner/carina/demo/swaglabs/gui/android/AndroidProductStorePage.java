package com.zebrunner.carina.demo.swaglabs.gui.android;

import com.zebrunner.carina.demo.swaglabs.components.android.AndroidFooterComponent;
import com.zebrunner.carina.demo.swaglabs.components.android.AndroidProductListComponent;
import com.zebrunner.carina.demo.swaglabs.components.ios.IOSFilterComponent;
import com.zebrunner.carina.demo.swaglabs.enums.SortingType;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.LoginPageBase;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.ProductStorePageBase;
import com.zebrunner.carina.demo.swaglabs.gui.iospages.IOSProductList;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    List<AndroidProductListComponent> products;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description('test-ADD TO CART')")
    ExtendedWebElement addToCartButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className('android.widget.ImageView').instance(5)")
    IOSFilterComponent filterOption;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description('test-REMOVE').instance(0)")
    ExtendedWebElement removeItemButton;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
    AndroidFooterComponent androidFooterComponent;

    protected AndroidProductStorePage(WebDriver driver) {
        super(driver);
    }

    public AndroidCartPage tapCartButton() {
        cartButton.click();
        return new AndroidCartPage(driver);
    }

    @Override
    public void addItemToCart() {
        while (!addToCartButton.isPresent()){
            swipe(addToCartButton);
        }
        addToCartButton.click();
    }

    @Override
    public LoginPageBase logOut() {
        tapMenuButton();
        logOutButton.click();
        return new AndroidLoginPage(driver);
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
                for (AndroidProductListComponent productListItem : products) {
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
            if (!swipe(androidFooterComponent.getAllRightsReservedText(), Direction.UP, 2, 600)) {
                maxIterations--;
            }
        }
    }

    //todo: add logic to use the parameter to check sorting
    @Override
    public boolean areItemsSortedBy(SortingType sortingType) {
        List<Long> prices = new ArrayList<>();
        for (AndroidProductListComponent productList : products) {
            try {
                if (productList.getProductPriceWebElement().isElementPresent()) {
                    String priceString = productList.getProductPrice();
                    Long price = Long.parseLong(priceString);
                    if (!prices.contains(price)) {
                        prices.add(price);
                    } else {
                        break;
                    }
                } else {
                    swipe(productList.getProductPriceWebElement());
                    String priceString = productList.getProductPrice();
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
