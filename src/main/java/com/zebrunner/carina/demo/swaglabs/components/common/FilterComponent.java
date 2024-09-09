package com.zebrunner.carina.demo.swaglabs.components.common;

import com.zebrunner.carina.demo.swaglabs.enums.SortingType;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FilterComponent extends AbstractUIObject {

    public FilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void sortBy(SortingType sortingType);
}
