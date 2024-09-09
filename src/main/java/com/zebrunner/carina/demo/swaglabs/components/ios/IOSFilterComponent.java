package com.zebrunner.carina.demo.swaglabs.components.ios;

import com.zebrunner.carina.demo.swaglabs.components.common.FilterComponent;
import com.zebrunner.carina.demo.swaglabs.enums.SortingType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IOSFilterComponent extends FilterComponent {

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement filterDropdownBtn;


    public IOSFilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void sortBy(SortingType sortingType) {
        filterDropdownBtn.format(sortingType.getSortType()).click();
    }
}
