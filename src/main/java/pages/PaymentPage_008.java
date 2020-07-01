package pages;

import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * PaymentPage Class represents select payment method with bank wire
 * Contains Element locator of bank wire, iconfirmMyOrder Buttons
 */

/**
 * @author Diaa AlHaref
 */
public class PaymentPage_008 {
    UiActions uiActions = new UiActions();

    By paymentWithBankWireLocator = By.xpath("//p[@class='payment_module']//a[@class='bankwire']");

    By iConfirmMyOrderButtonLocator = By.xpath("//button[@type='submit']//span[contains(.,'I confirm my order')]");

    /**
     * Method to select bank wire payment method and click on button
     */
    public void confirmOrderBySelectingBankWire() {
        uiActions.scrollDownToBottom(700);
        uiActions.waitForElement(paymentWithBankWireLocator, "visible")
                .findElementAndReturn(paymentWithBankWireLocator)
                .takeActionOnElement("click");

    }

    public void confirmOrderWithBankWirePayment() {
        uiActions.scrollDownToBottom(1000);
        uiActions.findElementAndReturn(iConfirmMyOrderButtonLocator)
                .takeActionOnElement("click");

    }
}
