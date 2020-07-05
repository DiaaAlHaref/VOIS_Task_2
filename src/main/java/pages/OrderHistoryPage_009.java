package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.UiActions;
/**
 * OrderHistoryPage Class represents Orders History for this Account
 * Contains Element locator of accountName, orderHistory, orderReference, details Buttons
 */

/**
 * @author Diaa AlHaref
 */
public class OrderHistoryPage_009 {
    UiActions uiActions = new UiActions();

    //String code;

    By myAccountNameLocator = By.cssSelector(".account");

    By orderHistoryAndDetailsButtonLocator = By.xpath("//a[@title='Orders']");
    By orderReferenceLocator = By.xpath("//p[@class='dark']/strong");

    By detailsButtonLocator = By.xpath("//span[contains(.,'Details')]");
    //By orderNumberCodeLocator = By.xpath("//tr[@class='first_item ' and contains(.,'"+code+"')] ");

    /**
     * Method to check placement of the order checked
     */
    public void checkOrderPlacementInOrderHistory() {
        uiActions.findElementAndReturn(myAccountNameLocator).takeActionOnElement("click");

        uiActions.waitForElement(orderHistoryAndDetailsButtonLocator, "clickable")
                .findElementAndReturn(orderHistoryAndDetailsButtonLocator)
                .takeActionOnElement("click");

        uiActions.waitForElement(detailsButtonLocator, "clickable")
                .findElementAndReturn(detailsButtonLocator)
                .takeActionOnElement("click");
    }

    /**
     * Method to validate on the order reference placed in the history page or not
     *
     * @return order number with the date of confirmation to assert on
     */
    public String validateOrderPlacementInOrderHistory() {
        uiActions.scrollDownToBottom(400);
        uiActions.waitForElement(orderReferenceLocator, "visible");
        WebElement element = UiActions.driver.findElement(orderReferenceLocator);
        return element.getText();
    }

    public String OrderNumberCode() {
        WebElement orderNumber = UiActions.driver.findElement(By.xpath("//tr[@class='first_item ']//a[@class='color-myaccount' and contains(.,'')]"));
        return orderNumber.getText();
    }

}
