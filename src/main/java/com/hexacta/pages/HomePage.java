package com.hexacta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.hexacta.drivers.Driver.getDriver;
import static com.hexacta.pages.BasePage.*;

public class HomePage {

    public static final String CLOSE_IMAGE = "//span[@aria-label='close']";
    public static final String HEADER_OPTIONS = "//a[contains(text(), '{0}')]";
    public static final String SELECT_OPTIONS_IN_THE_HEADER = "//ul[@class='sub-menu']/descendant::a[contains(text(), 'About us')]";

    public void clickCloseImage() {
        waitElementAndClick(CLOSE_IMAGE);
    }

    public WebElement headerOptions(String value) {
        waitElement(HEADER_OPTIONS.replace("{0}", value));
        return getDriver().findElement(By.xpath(HEADER_OPTIONS.replace("{0}", value)));
    }

    public void clickSelectOptionsInTheHeader() {
        waitElementAndClick(SELECT_OPTIONS_IN_THE_HEADER);
    }

    public void selectHeaderOption(String headerOption) {
        WebElement headerOptionElement = headerOptions(headerOption);
        new Actions(getDriver()).moveToElement(headerOptionElement).click().perform();
        clickSelectOptionsInTheHeader();
    }
}