package pages;

import org.openqa.selenium.By;
import utilities.UiActions;

/**
 * BlousesPage Class represents products shown of type blouses
 * Contains Element locators of addToCart, productImage, modalPopupWindow, proceedToCheckout Buttons
 */

/**
 * @author Diaa AlHaref
 */
public class BlousesPage_004 {
    UiActions uiActions = new UiActions();
    By addToCartLocator = By.xpath("//a[@title='Add to cart']");
    By productImageLocator = By.xpath("//img[@title='Blouse']");
    By modalPopupWindowLocator = By.xpath("//div[@class='clearfix']");
    By proceedToCheckoutButtonLocator = By.xpath("//div[@class='button-container']//a[@title='Proceed to checkout']");

    /**
     * Method to scrollDown to the product image and click on it then interact with
     * bootstrap modal to click on proceedToCheckout Button
     */
    public void clickOnAddToCart() {
        uiActions.scrollDownToBottom(700);
        uiActions.waitForElement(productImageLocator, "clickable")
                .hoverOnElement(productImageLocator)
                .findElementAndReturn(addToCartLocator)
                .takeActionOnElement("click");

        uiActions.switchToPopUpWindow(modalPopupWindowLocator, proceedToCheckoutButtonLocator);
    }
}
