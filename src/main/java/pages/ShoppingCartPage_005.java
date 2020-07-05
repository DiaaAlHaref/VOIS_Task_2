package pages;

import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * ShoppingCartPage Class represents Summary of the shopping cart
 * Contains Element locator of proceedToCheckout Button
 */

/**
 * @author Diaa AlHaref
 */
public class ShoppingCartPage_005 {
    UiActions uiActions = new UiActions();

    By proceedToCheckOutButtonLocator = By.xpath("//p//a[@title='Proceed to checkout']");

    /**
     * Method to scrollDown to proceedToCheckout Button and click on it
     */
    public void shoppingCartSummaryProceedToCheckOut() {
        uiActions.scrollDownToBottom(400);
        uiActions.findElementAndReturn(proceedToCheckOutButtonLocator)
                .takeActionOnElement("click");
    }
}
