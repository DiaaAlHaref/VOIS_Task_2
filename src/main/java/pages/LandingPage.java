package pages;

import fileReaders.PropertiesFile;
import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * LandingPage Class represents the homepage that URL Navigate to
 * Contains Element locators for SignIn Button
 */

/**
 * @author Diaa AlHaref
 */
public class LandingPage {

    UiActions uiActions = new UiActions();

    private final String[] view = PropertiesFile.propertiesFileReader(new String[]{"signInLocator"});
    private final By signInLocator = By.className(view[0]);

    /**
     * Method To Find Element locator and click on SignIn button
     */

    public void clickOnSignInButton() {
        uiActions.waitForElement(signInLocator, "clickable").findElementAndReturn(signInLocator)
                .takeActionOnElement("click");
    }
}
