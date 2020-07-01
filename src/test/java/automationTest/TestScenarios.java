package automationTest;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.*;
/**
 * TestScenario Class Demonstrates test steps run and assertions
 */
public class TestScenarios extends BaseTest {


    LandingPage landingPage = new LandingPage();
    LoginPage_001 loginPage_001 = new LoginPage_001();
    AuthenticationPage_002 authenticationPage_002 = new AuthenticationPage_002();
    MyAccountPage_003 myAccountPage_003 = new MyAccountPage_003();
    BlousesPage_004 blousesPage_004 = new BlousesPage_004();
    ShoppingCartPage_005 shoppingCartPage_005 = new ShoppingCartPage_005();
    ConfirmAddressPage_006 confirmAddressPage_006 = new ConfirmAddressPage_006();
    ShippingPage_007 shippingPage_007 = new ShippingPage_007();
    PaymentPage_008 paymentPage_008 = new PaymentPage_008();
    OrderHistoryPage_009 orderHistoryPage_009 = new OrderHistoryPage_009();

    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Create a new account user </p>
     * <p> Step.2) Authenticate as new user </p>
     * <p> Step.3) Select “Blouses” Subcategory in “Women” Category </p>
     * <p> Step.4) Select resulted product </p>
     * <p> Step.5) Follow checkout procedure </p>
     * <p> Step.6) Confirm order by selecting bank wire option </p>
     * <p> Step.7) Validate order was placed from order history page </p>
     */
    @Test
    @Description("Test User Authentication, Select Blouse Product Then assert on the History page")
    public void test_NewUserAccountThenProductSelectionThenAssertOnProductPlacement() {
        Log.log4PropertiesConfiguration();
        Log.runTestCase("test_NewUserAccountThenProductSelectionThenAssertOnProductPlacement");

        landingPage.clickOnSignInButton();
        Log.info("Clicked On SignIn Button");

        loginPage_001.sendKeysToEmailAddressFieldAndClickOnCreateAccountButton();
        Log.info("Typed email in email-address text field");

        authenticationPage_002.authenticationPersonalInformation();
        Log.info("Filled all information for user authentication");

        myAccountPage_003.selectBlousesSectionFromWomenList();
        Log.info("Selected blouse product from women category");

        blousesPage_004.clickOnAddToCart();
        Log.info("Clicked on add to cart button and then clicked proceed to checkout");

        shoppingCartPage_005.shoppingCartSummaryProceedToCheckOut();
        Log.info("Listing shopping cart summary and then clicked proceed to checkout");

        confirmAddressPage_006.confirmAddressesForBilling();
        Log.info("Confirmed address for billing");

        shippingPage_007.confirmShippingOptionAndProceedToCheckOut();
        Log.info("Confirmed shipping option and proceed to checkout");

        paymentPage_008.confirmOrderBySelectingBankWire();
        Log.info("Selected type of payment as Bank Wire");
        paymentPage_008.confirmOrderWithBankWirePayment();
        Log.info("Confirmed bank wire payment method");

        orderHistoryPage_009.checkOrderPlacementInOrderHistory();
        Log.info("Viewing order history to confirm product placement");

        String referenceNumber = orderHistoryPage_009.validateOrderPlacementInOrderHistory();
        System.out.println("This is the text Order: " + referenceNumber);
        Assertion assertion = new Assertion();
        assertion.assertTrue(referenceNumber.contains("placed on 07/01/2020"));
        Log.warn("Asserted true as the product is placed in history page");


        Log.endTestCase("test_NewUserAccountThenProductSelectionThenAssertOnProductPlacement");

    }
}
