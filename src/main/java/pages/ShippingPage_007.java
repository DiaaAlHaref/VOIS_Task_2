package pages;

import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * ShippingPage Class represents Agreement for the terms and privacy for payment option
 * Contains Element locator of checkButton, proceedToCheckout Button
 */

/**
 * @author Diaa AlHaref
 */
public class ShippingPage_007 {
    UiActions uiActions = new UiActions();

    By checkButtonLocator = By.id("cgv");
    By proceedToCheckOutButtonLocator = By.xpath("//button[@name='processCarrier']");

    /**
     * Method to check on terms and conditions and click on proceedToCheckout Button
     */
    public void confirmShippingOptionAndProceedToCheckOut() {

        uiActions.findElementAndReturn(checkButtonLocator)
                .takeActionOnElement("click");
        uiActions.findElementAndReturn(proceedToCheckOutButtonLocator)
                .takeActionOnElement("click");
    }
}
