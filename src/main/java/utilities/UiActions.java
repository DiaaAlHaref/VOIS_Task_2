package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UiActions {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private WebElement element;
    private List<WebElement> elements;

    /**
     * Find Element
     *
     * @param locator ex. by.xpath , by.id , by.name , etc...
     * @return Element
     */
    public UiActions findElementAndReturn(By locator) {
        try {
            element = driver.findElement(locator);
        } catch (InvalidSelectorException e) {
            HandleExceptions.InvalidSelectorExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        }
        return this;
    }

    /**
     * Find List of Elements
     *
     * @param locator
     * @return
     */
    public UiActions findListOfElements(By locator) {
        try {
            elements = driver.findElements(locator);
        } catch (InvalidSelectorException e) {
            HandleExceptions.InvalidSelectorExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        }
        return this;
    }

    /**
     * Send keys to a text field
     *
     * @param text String or keyword to search for
     * @return Element
     */
    public UiActions sendKeysToElement(String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        }
        return this;
    }

    /**
     * Handle type of waits either visible or clickable
     *
     * @param locator    locator of element to wait for
     * @param typeOfWait type of the wait either "visible" or "clickable"
     */
    public UiActions waitForElement(By locator, String typeOfWait) {

        try {
            wait = new WebDriverWait(driver, 1000);
            switch (typeOfWait) {
                case "visible":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                    break;
                case "clickable":
                    wait.until(ExpectedConditions.elementToBeClickable(locator));
                    break;
            }
        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        } catch (ElementNotInteractableException e) {
            HandleExceptions.ElementNotInteractableExceptionHandling(e);
        } catch (TimeoutException e) {
            HandleExceptions.TimeoutExceptionHandling(e);
        }
        return this;
    }

    /**
     * Handle type of actions performed on an element
     *
     * @param action takes type of action either "click" or "submit"
     */
    public void takeActionOnElement(String action) {
        try {
            switch (action) {
                case "click":
                    element.click();
                    break;
                case "submit":
                    element.submit();
                    break;
            }
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        } catch (ElementNotInteractableException e) {
            HandleExceptions.ElementNotInteractableExceptionHandling(e);
        }

    }

    /**
     * Get Size for list of elements have the same path
     *
     * @return elements size
     */
    public int getSizeOfElements() {
        return elements.size();
    }

    /**
     * Handle scroll Down action on the browser
     */
    public void scrollDownToBottom(int height) {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollTo(0," + height + ");");
    }

    public void scrollTillElementFound(By locator) {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("arguments[0].scrollIntoView();", element.findElement(locator));
    }


    public UiActions selectFromDropMenu(String type, By locator, String value) {
        Select element = new Select(driver.findElement(locator));
        switch (type) {
            case "selectByValue":
                element.selectByValue(value);
            case "selectByIndex":
                element.selectByIndex(Integer.parseInt(value));
        }
        return this;
    }

    public UiActions hoverOnElement(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
        return this;
    }

    public UiActions switchToPopUpWindow(By modalLocator, By buttonLocator) {
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(modalLocator));
        modal.findElement(buttonLocator).click();
        return this;
    }

    /*public String getTextForAssertion(By locator) {
        element= driver.findElement(locator);
        return element.getText();
    }*/
}