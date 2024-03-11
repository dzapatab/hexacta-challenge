package com.hexacta.pages;
import java.util.List;
import net.thucydides.core.webdriver.exceptions.ElementShouldBePresentException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.hexacta.drivers.Driver.getDriver;
public class BasePage {

    public static WebDriverWait wait;
    private static Actions action ;

    public static WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public static void writeTextWebElement(String locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public static void selectFromDropdownByValue(String locator, String valueToSelect){
        Select Dropdown = new Select(find(locator));
        Dropdown.selectByValue(valueToSelect);
    }

    public static void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select Dropdown = new Select(find(locator));
        Dropdown.selectByIndex(valueToSelect);
    }

    public static void selectFromDropdownByText(String locator, String valueToSelect){
        Select Dropdown = new Select(find(locator));
        Dropdown.selectByVisibleText(valueToSelect);
    }

    public String getFirstSelected(String locator){
        Select mySelect = new Select(find(locator));
        return mySelect.getFirstSelectedOption().getText().toString();
    }

    public void scrollDown(String pixels){
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0," + pixels + ")");
    }

    public static void hoverOverElement(String locator){
        action.moveToElement(find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(find(locator)).perform();;
    }

    public String getValueFromTable(String locator, int row, int columna){
        String cell = locator + "/table/tbody/tr["+row+"]/td["+columna+"]";
        return find(cell).getText();
    }
    public void setValueOnTable(String locator, int row, int columna, String value){
        String cell = locator + "/table/tbody/tr["+row+"]/td["+columna+"]";
        find(cell).sendKeys(value);
    }
    public void acceptAlert() {
        try {
            getDriver().switchTo().alert().dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToiFrame(int iFrameIndex) {
        getDriver().switchTo().frame(iFrameIndex);
    }
    public void switchToParentFrame(int iFrameIndex) {
        getDriver().switchTo().parentFrame();
    }

    public static String getTextFromElement(String locator){
        return getDriver().findElement(By.xpath(locator)).getText();
    }

    public List<WebElement> getAllElements(String locator){
        return getDriver().findElements(By.className(locator));
    }

    public static void clickJavaScript(String xpath){
        WebElement element_two = getDriver().findElement(By.xpath(xpath));
        JavascriptExecutor executor_two = (JavascriptExecutor)getDriver();
        executor_two.executeScript("arguments[0].click();", element_two);
    }

    public static void clickElementInSelectById(String id, String element){
        WebElement selectElement = getDriver().findElement(By.id(id));
        Select select = new Select(selectElement);
        select.selectByVisibleText(element);
    }

    public static void clearAndSendKeys(String xpath, String sendKeysValue){
        getDriver().findElement(By.xpath(xpath)).clear();
        getDriver().findElement(By.xpath(xpath)).sendKeys(sendKeysValue);
    }

    public static void waitAndClickByCssSelector(String css){
        waitExplicit(css);
        WebElement continueButton = getDriver().findElement(By.cssSelector(css));
        continueButton.click();
    }

    public static void waitElement(String xpath){
        waitExplicit(xpath);
    }

    public static void waitElementAndClick(String xpath){
        waitExplicit(xpath);
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public static void waitExplicit(String xpath){
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        wait.until(webDriver -> askForThe(xpath));
    }

    public static boolean askForThe(String xpath) {
        try {
            return (getDriver().findElement(By.xpath(xpath)) != null && getDriver().findElement(By.xpath(xpath)).isEnabled() && getDriver().findElement(By.xpath(xpath)).isDisplayed() && !getDriver().findElement(By.xpath(xpath)).isSelected());
        } catch(ElementShouldBePresentException | IllegalArgumentException | NoSuchElementException var4){
            return false;
        }
    }
}
