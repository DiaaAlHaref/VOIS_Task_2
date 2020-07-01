package pages;

import fileReaders.PropertiesFile;
import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * LoginPage Class represents Account creation with email address
 * Contains Element locators for create account Button
 */

/**
 * @author Diaa AlHaref
 */
public class LoginPage_001 {
    UiActions uiActions = new UiActions();

    String[] view = PropertiesFile.propertiesFileReader(new String[]{"emailAddressLocator", "createAccountButtonLocator", "email"});
    By emailAddressLocator = By.id(view[0]);
    By createAccountButtonLocator = By.id(view[1]);
    String email = view[2];

    /**
     * Method to type email address and then click on create account button
     */
    public void sendKeysToEmailAddressFieldAndClickOnCreateAccountButton() {
        uiActions.scrollDownToBottom(700);
        uiActions.waitForElement(emailAddressLocator, "clickable")
                .findElementAndReturn(emailAddressLocator)
                .sendKeysToElement(email);
        uiActions.findElementAndReturn(createAccountButtonLocator)
                .takeActionOnElement("click");
    }
}
