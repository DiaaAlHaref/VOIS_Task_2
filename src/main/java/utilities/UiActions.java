package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.attribute.standard.MultipleDocumentHandling;
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

    /**
     * Handle scroll Down action until element found
     *
     * @param locator represents the locator of the element to scroll until it found
     */
    public void scrollTillElementFound(By locator) {
        try {
            JavascriptExecutor scroll = (JavascriptExecutor) driver;
            scroll.executeScript("arguments[0].scrollIntoView();", element.findElement(locator));
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        }

    }

    /**
     * Method select from drop down menu using either index or value string
     *
     * @param type    represents type of selection
     * @param locator represents locator of an element
     * @param value   represents string selected from the dropDown menu
     * @return object from type UiActions for concept of chaining
     */
    public UiActions selectFromDropMenu(String type, By locator, String value) {
        Select element = new Select(driver.findElement(locator));
        try {
            switch (type) {
                case "selectByValue":
                    element.selectByValue(value);
                case "selectByIndex":
                    element.selectByIndex(Integer.parseInt(value));
            }
        } catch (InvalidSelectorException e) {
            HandleExceptions.InvalidSelectorExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        } catch (ElementNotInteractableException e) {
            HandleExceptions.ElementNotInteractableExceptionHandling(e);
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        }
        return this;
    }

    /**
     * Method used to hover with mouse on element
     *
     * @param locator represents locator of an element
     * @return object from type UiActions for concept of chaining
     */
    public UiActions hoverOnElement(By locator) {
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(driver.findElement(locator)).perform();
        } catch (InvalidSelectorException e) {
            HandleExceptions.InvalidSelectorExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        } catch (ElementNotInteractableException e) {
            HandleExceptions.ElementNotInteractableExceptionHandling(e);
        }
        return this;
    }

    /**
     * Method interact with Bootstrap Modal Popup window and take action on elements
     *
     * @param modalLocator  represents locator of the window
     * @param buttonLocator represents locator of the element placed inside the window to take action
     * @return object from type UiActions for concept of chaining
     */
    public UiActions switchToPopUpWindow(By modalLocator, By buttonLocator) {
        try{
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(modalLocator));
            modal.findElement(buttonLocator).click();
        }catch (InvalidSelectorException e){
            HandleExceptions.InvalidSelectorExceptionHandling(e);
        }catch (NoSuchElementException e){
            HandleExceptions.NoSuchElementExceptionHandling(e);
        }catch (ElementNotVisibleException e){
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        }catch (ElementNotInteractableException e){
            HandleExceptions.ElementNotInteractableExceptionHandling(e);
        }
        return this;
    }
    /*public String getTextForAssertion(By locator) {
        element= driver.findElement(locator);
        return element.getText();
    }*/
}