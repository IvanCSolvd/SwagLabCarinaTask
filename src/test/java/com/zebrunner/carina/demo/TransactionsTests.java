package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.swaglabs.enums.SortingType;
import com.zebrunner.carina.demo.swaglabs.gui.commonpages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionsTests extends AbstractTest {
    @Test
    public void correctCheckOutTest() {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        CartPageBase cartPage = productStorePageBase.tapCartButton();
        CheckOutPageBase checkOutPageBase = cartPage.tapCheckoutButton();
        OverviewPageBase overviewPageBase = checkOutPageBase.fillData("Test", "Test", "1000");
        CompletePageBase completePageBase = overviewPageBase.tapFinish();
        Assert.assertTrue(completePageBase.isSuccessTextPresent());
    }

    @Test
    public void missingNameCheckOutTest() {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        CartPageBase cartPage = productStorePageBase.tapCartButton();
        CheckOutPageBase checkOutPageBase = cartPage.tapCheckoutButton();
        checkOutPageBase.fillDataTriggerError("", "Test", "1000");
        Assert.assertTrue(checkOutPageBase.errorOnCheckOutTextPresent());
    }


    @Test(description = "Sort Items by price from low to high")
    public void verifyProductSortInAscendingOrder() throws InterruptedException {
        ProductStorePageBase productStorePageBase = initPage(getDriver(), ProductStorePageBase.class);
        productStorePageBase.sortBy(SortingType.PRICE_LOW_TO_HIGH);
        Thread.sleep(3000);
        Assert.assertTrue(productStorePageBase.areItemsSortedBy(SortingType.PRICE_LOW_TO_HIGH));
    }
}
