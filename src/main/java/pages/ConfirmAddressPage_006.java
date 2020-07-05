package pages;

import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * ConfirmAddressPage Class represents Address Confirmation for billing process to complete
 * Contains Element locator of proceedToCheckout Button
 */

/**
 * @author Diaa AlHaref
 */
public class ConfirmAddressPage_006 {

    UiActions uiActions = new UiActions();

    By proceedToCheckOutButtonLocator = By.xpath("//button[@name='processAddress']");

    /**
     * Method to scrollDown to proceedToCheckout Button and click on it
     */
    public void confirmAddressesForBilling() {
        uiActions.scrollDownToBottom(400);
        uiActions.waitForElement(proceedToCheckOutButtonLocator, "clickable")
                .findElementAndReturn(proceedToCheckOutButtonLocator)
                .takeActionOnElement("click");
    }
}

