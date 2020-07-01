package pages;

import fileReaders.PropertiesFile;
import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * AuthenticationPage Class represents Information of the account to be created
 * Contains Element locators of Gender, FirstName, LastName, emailAddress, Password , etc...
 */

/**
 * @author Diaa AlHaref
 */
public class AuthenticationPage_002 {

    UiActions uiActions = new UiActions();

    String[] locators = PropertiesFile.propertiesFileReader(new String[]{"genderRadioButtonLocator", "customerFirstNameFieldLocator"
            , "customerLastNameFieldLocator", "emailFieldLocator", "passwordFieldLocator"
            , "addressFirstNameLocator", "addressLastNameLocator", "addressFieldLocator"
            , "cityFieldLocator", "stateDropMenuLocator", "postalCodeFieldLocator"
            , "countryDropMenuLocator", "mobilePhoneFieldLocator", "myAddressAliasFieldLocator"
            , "registerButtonLocator"});
    By genderRadioButtonLocator = By.xpath(locators[0]);
    By customerFirstNameFieldLocator = By.id(locators[1]);
    By customerLastNameFieldLocator = By.id(locators[2]);
    By emailFieldLocator = By.id(locators[3]);
    By passwordFieldLocator = By.id(locators[4]);

    By addressFirstNameLocator = By.id(locators[5]);
    By addressLastNameLocator = By.id(locators[6]);
    By addressFieldLocator = By.id(locators[7]);
    By cityFieldLocator = By.id(locators[8]);
    By stateDropMenuLocator = By.id(locators[9]);
    By postalCodeFieldLocator = By.id(locators[10]);
    By countryDropMenuLocator = By.id(locators[11]);
    By mobilePhoneFieldLocator = By.id(locators[12]);
    By myAddressAliasFieldLocator = By.id(locators[13]);
    By registerButtonLocator = By.id(locators[14]);

    String[] keywords = PropertiesFile.propertiesFileReader(new String[]{"firstName", "lastName", "email",
            "password", "address", "city", "postalCode", "mobilePhone", "addressAlias"});
    String firstName = keywords[0];
    String lastName = keywords[1];
    String email = keywords[2];
    String password = keywords[3];
    String address = keywords[4];
    String city = keywords[5];
    String postalCode = keywords[6];
    String mobilePhone = keywords[7];
    String addressAlias = keywords[8];

    /**
     * Method filling the information with sendkeys option to all test fields in order
     */
    public void authenticationPersonalInformation() {
        uiActions.waitForElement(genderRadioButtonLocator, "clickable")
                .findElementAndReturn(genderRadioButtonLocator)
                .takeActionOnElement("click"); //gender radio button_01

        uiActions.findElementAndReturn(customerFirstNameFieldLocator)
                .sendKeysToElement(firstName);

        uiActions.findElementAndReturn(customerLastNameFieldLocator)
                .sendKeysToElement(lastName);

        uiActions.findElementAndReturn(emailFieldLocator)
                .sendKeysToElement(email);

        uiActions.findElementAndReturn(passwordFieldLocator)
                .sendKeysToElement(password);

        uiActions.findElementAndReturn(addressFirstNameLocator)
                .sendKeysToElement(firstName);

        uiActions.findElementAndReturn(addressLastNameLocator)
                .sendKeysToElement(lastName);

        uiActions.findElementAndReturn(addressFieldLocator)
                .sendKeysToElement(address);

        uiActions.findElementAndReturn(cityFieldLocator)
                .sendKeysToElement(city);

        uiActions.selectFromDropMenu("selectByIndex", stateDropMenuLocator, "4");

        uiActions.findElementAndReturn(postalCodeFieldLocator)
                .sendKeysToElement(postalCode);

        uiActions.selectFromDropMenu("selectByIndex", countryDropMenuLocator, "1");

        uiActions.findElementAndReturn(mobilePhoneFieldLocator)
                .sendKeysToElement(mobilePhone);

        uiActions.findElementAndReturn(myAddressAliasFieldLocator)
                .sendKeysToElement(addressAlias)
                .findElementAndReturn(registerButtonLocator).takeActionOnElement("click");
    }
}
