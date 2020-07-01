package pages;

import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * MyAccountPage Class represents contains historypage for any order reference
 * Contains Element locators of women category and blouse subCategory
 */

/**
 * @author Diaa AlHaref
 */
public class MyAccountPage_003 {
    UiActions uiActions = new UiActions();

    By womenListLocator = By.xpath("//a[@title='Women']");
    By blousesSectionLocator = By.xpath("//a[@title='Blouses']");

    /**
     * Method to hover on Women Category and click on blouse subCategory
     */
    public void selectBlousesSectionFromWomenList() {
        uiActions.waitForElement(womenListLocator, "clickable")
                .hoverOnElement(womenListLocator)
                .findElementAndReturn(blousesSectionLocator)
                .takeActionOnElement("click");
    }
}
