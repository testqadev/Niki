package com.face.stepDefinitions;

import org.junit.Assert;

import com.face.pageFactory.AccountContactPage;
import com.face.pageFactory.AdminConsoleLogin;
import com.face.pageFactory.BillingPage;
import com.face.pageFactory.BrainTreePage;
import com.face.pageFactory.ClientAccountPage;
import com.face.pageFactory.DomainCheckOutPage;
import com.face.pageFactory.DomainSearchPage;
import com.face.pageFactory.HostingAndExtrasPage;
import com.face.pageFactory.InvoicesPage;
import com.face.pageFactory.MainMenuPage;
import com.face.pageFactory.PrepaidCreditPage;
import com.face.pageFactory.RegistrantContactPage;
import com.face.pageFactory.WorkflowDetailsPage;

import core.generic.Utilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DomainZ {

	// Local variables
	private Utilities objUtilities = new Utilities();
	private AccountContactPage objAccountContactPage = new AccountContactPage();
	private AdminConsoleLogin objAdminConsoleLogin = new AdminConsoleLogin();
	private BillingPage objBillingPage = new BillingPage();
	private ClientAccountPage objClientAccountPage = new ClientAccountPage();
	private DomainCheckOutPage objDomainCheckOutPage = new DomainCheckOutPage();
	private DomainSearchPage objDomainSearchPage = new DomainSearchPage();
	private HostingAndExtrasPage objHostingAndExtrasPage = new HostingAndExtrasPage();
	private InvoicesPage objInvoicesPage = new InvoicesPage();
	private MainMenuPage objMainMenuPage = new MainMenuPage();
	private PrepaidCreditPage objPrepaidCreditPage = new PrepaidCreditPage();
	private RegistrantContactPage objRegistrantContactPage = new RegistrantContactPage();
	private BrainTreePage objBrainTreePage = new BrainTreePage();
	private WorkflowDetailsPage objWorkflowDetailsPage = new WorkflowDetailsPage();

	@Given("^Enter domain name (.*)$")
	public void enterDomainName(String domainname) {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objDomainSearchPage.setDomainName(domainname));
	}

	@Then("^Select domain service$")
	public void Select_domain_service() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objDomainSearchPage.clickCheckBox());
	}

	@Then("^Uncheck au domain service$")
	public void Uncheck_au_domain_service() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objDomainSearchPage.unCheckBox());
	}

	@Then("^Click on search button$")
	public void Click_on_search_button() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objDomainSearchPage.clickOnSearch());
	}

	@Then("^Click on cotinue to checkout button$")
	public void Click_on_cotinue_to_checkout_button() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objDomainCheckOutPage.clickOnContinueToCheckout());
	}

	@Then("^Click on No thanks pop up$")
	public void Click_on_No_thanks_pop_up() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objDomainCheckOutPage.clickOnNoThanksPopup());
	}

	@Then("^Click on continue to account$")
	public void Click_on_continue_to_account() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objHostingAndExtrasPage.clickOnContinueHosting());
	}

	@Then("^Enter organisation name (.*)$")
	public void Enter_organisation_name_Payment_Gateway_Test(String Organisationname) {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.enterOrganisationName(Organisationname));
	}

	@Then("^Enter first name (.*)$")
	public void Enter_first_name_Payment_Gateway_Test(String FirstName) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.enterFirstName(FirstName));
	}

	@Then("^Enter last name (.*)$")
	public void Enter_last_name_Payment_Gateway_Test(String LastName) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.enterLastName(LastName));
	}

	@Then("^Enter address (.*)$")
	public void Enter_address(String Address) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.enterAddress(Address));
	}

	@Then("^Enter city name (.*)$")
	public void Enter_city_name(String CityName) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.enterCity(CityName));
	}

	@Then("^Select state (.*)$")
	public void Select_state(String State) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.enterState(State));
	}

	@Then("^Enter post code (.*)$")
	public void Enter_post_code(String PostCode) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.enterPostCode(PostCode));
	}

	@Then("^Enter phone number (.*)$")
	public void Enter_phone_number(String PhoneNumber) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.enterPhoneNumber(PhoneNumber));
	}

	@Then("^Enter email (.*)$")
	public void Enter_email(String Email) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.enterEmail(Email));
	}

	@Then("^Enter confirmation mail (.*)$")
	public void Enter_confirmation_mail(String ConfirmationEmail) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.enterConfirmationEmail(ConfirmationEmail));
	}

	@Then("^Click on continue to payment page$")
	public void Click_on_continue_to_payment_page() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.clickOnContinueSaveContact());
	}

	@Then("^Click on continue to registrant page$")
	public void Click_on_continue_to_registrant_page() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objRegistrantContactPage.clickSaveRegisterConstrant());
	}

	@Then("^Enter card owner name (.*)$")
	public void Enter_card_owner_name_AlphaNumeric(String CardOwner) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.enterCardOwner(CardOwner));
	}

	@Then("^Switch to iframe card number$")
	public void switch_to_iframe() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.switchToFrame());
	}

	@Then("^Enter card number (.*)$")
	public void Enter_card_number(String CardNumber) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.enterCardNumber(CardNumber));
	}

	@Then("^Switch to iframe card expiry month$")
	public void switch_to_iframe_expity_month() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.switchToFrameExpiryMonth());
	}

	@Then("^Select card expiry month (.*)$")
	public void Select_card_expiry_month(String dropdownmonth) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.enterCardExpiryMonth(dropdownmonth));
	}

	@Then("^Switch to iframe card expiry year$")
	public void switch_to_iframe_expity_year() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.switchToFrameExpiryYear());
	}

	@Then("^Select card expiry year (.*)$")
	public void Select_card_expiry_year(String dropdownyear) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.enterCardExpiryYear(dropdownyear));
	}

	@Then("^Switch to iframe card cvv$")
	public void switch_to_iframe_CVV() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.switchToFrameCVV());
	}

	@Then("^Enter card CVV number (.*)$")
	public void Enter_card_CVV_number(String CVV) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.enterCardCVV(CVV));
	}

	@Then("^Select I agree checkbox$")
	public void Select_I_agree_checkbox() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.selectTermsAndConditions());
	}

	@Then("^Click on continue button$")
	public void Click_on_continue_button() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.clickOnContinueButton());
	}

	@Then("^Clear text from card owner field$")
	public void Clear_text_card_owner() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.clearCardOwnerName());
	}

	@Then("^Verify alert message for card owner field (.*)$")
	public void Verify_message_card_owner(String msgcardowner) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertEquals(msgcardowner, objBillingPage.verifyAlertMsgCardOwner(msgcardowner));
	}

	@Then("^Clear number from card number field$")
	public void Clear_text_card_number() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.clearCardNumber());
	}

	@Then("^Verify alert message for card number field (.*)$")
	public void Verify_message_card_number(String msgcardnumber) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertEquals(msgcardnumber, objBillingPage.verifyAlertMsgCardNumber(msgcardnumber));
	}

	@Then("^Clear number from card CVV field$")
	public void Clear_number_card_cvv() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objBillingPage.clearCardCvv());
	}

	@Then("^Verify alert message for CVV field (.*)$")
	public void Verify_message_card_cvv(String msgcvv) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertEquals(msgcvv, objBillingPage.verifyAlertMsgCardCvv(msgcvv));
	}

	@Then("^Verify alert message invalid card number (.*)$")
	public void Verify_message_invalid_card_num(String invalidCardNum) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertEquals(invalidCardNum, objBillingPage.verifyAlertMsgInvalidCardNumber(invalidCardNum));
		objUtilities.waitForPageLoad();
	}

	@Then("^Verify alert message invalid cvv number (.*)$")
	public void Verify_message_invalid_cvv_num(String invalidCvvNum) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertEquals(invalidCvvNum, objBillingPage.verifyAlertMsgInvalidCvvNumber(invalidCvvNum));
		objUtilities.waitForPageLoad();
	}

	@Then("^Verify alert message for Amex card (.*)$")
	public void Verify_message_invalid_card_number_Amex(String invalidCardNumAmex) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertEquals(invalidCardNumAmex, objBillingPage.verifyAlertMsgInvalidCardNumberAmex(invalidCardNumAmex));
		objUtilities.waitForPageLoad();
	}

	@Then("^Verify alert message for Diner card (.*)$")
	public void Verify_message_invalid_card_number_Diner(String invalidCardNumDiner) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertEquals(invalidCardNumDiner,
				objBillingPage.verifyAlertMsgInvalidCardNumberDiner(invalidCardNumDiner));
		objUtilities.waitForPageLoad();
	}

	@Then("^Verify alert message for JCB card (.*)$")
	public void Verify_message_invalid_card_number_JCB(String invalidCardNumJCB) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertEquals(invalidCardNumJCB, objBillingPage.verifyAlertMsgInvalidCardNumberJCB(invalidCardNumJCB));
		objUtilities.waitForPageLoad();
	}

	@Given("^Enter User name (.*)$")
	public void Enter_user_name(String userName) throws Throwable {
		//objUtilities.waitForPageLoad();
		Assert.assertTrue(objAdminConsoleLogin.enterUserName(userName));
	}

	@Then("^Enter Password (.*)$")
	public void Enter_password(String Password) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objAdminConsoleLogin.enterPassword(Password));
	}

	@Then("^Click on Login button$")
	public void Click_on_login_button() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objAdminConsoleLogin.clickOnLoginButton());
	}

	@Then("^Enter Greencode in Account reference field (.*)$")
	public void Enter_greencode(String AccountReference) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objMainMenuPage.enterGreencode(AccountReference));
	}

	@Then("^Click on Submit button$")
	public void Click_on_submit_button() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objMainMenuPage.clickOnSubmitButton());
	}

	@Then("^Click on View invoice and prepaid detail$")
	public void Click_on_viewe_invoice() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objAccountContactPage.clickOnViewinvoiceandprepaiddetail());
	}

	@Then("^Click on prepaid account details$")
	public void Click_on_prepaid_account() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objInvoicesPage.clickOnprepaidaccountdetails());
	}

	@Then("^Select existing credit card$")
	public void Select_existing_credit_card() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.selectexistingcreditcard());
	}

	@Then("^Enter amount in purchase credit field (.*)$")
	public void Enter_amount_purchase_credit(String prepaidamount) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.enterAmountPrepaid(prepaidamount));
	}

	@Then("^Click on purchase credit button$")
	public void Click_on_purchase_credit() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.Clickpurchasecredit());
	}

	@Then("^Verify success message (.*)$")
	public void Verify_success_message(String prepaidsuccess) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertEquals(prepaidsuccess, objPrepaidCreditPage.verifySuccessMSG(prepaidsuccess));
	}

	@Then("^Enter visa card owner name (.*)$")
	public void Enter_card_owner_name_purchase_credit(String CardOwnerName) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.enterCardOwnerName(CardOwnerName));
	}

	@Then("^Switch admin to iframe card number$")
	public void switch_ato_iframe() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.switchAdminToFrame());
	}

	@Then("^Enter credit card number (.*)$")
	public void Enter_credit_card_number_purchase_credit(String CardNumber) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.enterPrepaidCardNumber(CardNumber));
	}

	@Then("^Switch admin iframe to emp months$")
	public void Switch_admin_iframe_to_emp_months() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.switchAdminToFrameExpiryMonth());
	}

	@Then("^Enter expiry month (.*)$")
	public void Enter_credit_card_expiry_month(String CardExpiryMonth) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.enterPrepaidCardExpiryMonth(CardExpiryMonth));
	}

	@Then("^Switch admin to iframe card expiry year$")
	public void switch_ato_iframe_expity_year() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.switchAdminToFrameExpiryYear());
	}

	@Then("^Enter expiry year (.*)$")
	public void Enter_credit_card_expiry_year(String CardExpiryYear) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.enterPrepaidCardExpiryYear(CardExpiryYear));
	}

	@Then("^Switch admin to iframe card cvv$")
	public void switch_ato_iframe_CVV() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.switchAdminToFrameCVV());
	}

	@Then("^Enter CVV (.*)$")
	public void Enter_credit_card_CVV_number(String CardCVV) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objPrepaidCreditPage.enterPrepaidCardCVVNumber(CardCVV));
	}

	@Then("^Click on Login As Client$")
	public void Click_on_Login_As_Client() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objClientAccountPage.ClickloginAsClient());
	}

	@Then("^Click on Account tab$")
	public void Click_on_Account_Tab() throws Throwable {
		objUtilities.waitForPageLoad();
	}

	@Then("^Click on Edit button for credit cards on file$")
	public void Click_on_Edit_Button_Account_Tab() throws Throwable {
		objUtilities.waitForPageLoad();
	}

	@Then("^Click on Edit for prepaid account$")
	public void Click_on_Edit_Button_Prepaid_Account() throws Throwable {
		objUtilities.waitForPageLoad();
	}

	@Then("^Click on rechrge using credit card$")
	public void Click_on_Recharge_Using_Credit_Card() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objClientAccountPage.ClickOnRechrgeUsingCreditCardButton());
	}

	@Then("^Check using new credit card$")
	public void Check_on_new_Credit_Card() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objClientAccountPage.ClickOnRechrgeUsingNewCreditCardButton());
	}

	@Then("^Enter Card owner name (.*)$")
	public void Enter_new_Credit_Card_name(String cardOwner) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objClientAccountPage.enterCardOwnerNameDomainZ(cardOwner));
	}

	@Then("^Enter domainZ Card number (.*)$")
	public void Enter_domainZ_credit_card_number_purchase_credit(String cardNumber) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objClientAccountPage.enterPrepaidCardNumberDomainZ(cardNumber));
	}

	@Then("^Select expiry month (.*)$")
	public void Enter_domainZ_credit_card_expiry_month(String expiryMonth) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objClientAccountPage.enterPrepaidCardExpiryMonthDomainZ(expiryMonth));
	}

	@Then("^Select expiry year (.*)$")
	public void Enter_domainZ_credit_card_expiry_year(String expiryYear) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objClientAccountPage.enterPrepaidCardExpiryYearDomainZ(expiryYear));
	}

	@Then("^Enter domainZ CVV number (.*)$")
	public void Enter_domainZ_credit_card_CVV_number(String CVVnumber) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objClientAccountPage.enterPrepaidCardCVVNumberDomainZ(CVVnumber));
	}

	@Then("^Enter prepaid amount (.*)$")
	public void Enter_domainZ_enter_Amount(String prepaidamount) throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objClientAccountPage.enterPrepaidAmountDomainZ(prepaidamount));
	}

	@Then("^Click on submit button$")
	public void Click_on_Submit_Recharge_Using_Credit_Card() throws Throwable {
		objUtilities.waitForPageLoad();
		Assert.assertTrue(objClientAccountPage.ClickOnSubmitButton());
	}

	@Then("^search the workflow$")
	public void searchtheworkflow() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objClientAccountPage.searchtheworkflow());
	}

	@Then("^Get preauth number$")
	public void GetPreauthNumber() throws Throwable {
		objUtilities.waitForPageLoad();

		objClientAccountPage.GetPreauthNumber();
	}

	@Then("^Open Braintree portal$")
	public void OpenBraintreePortal() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objBrainTreePage.OpenBraintreePortal());
	}

	@Then("^Navigate to transactions$")
	public void NavigateToTransactions() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objBrainTreePage.NavigateToTransactions());
	}

	@Then("^Search for the preauth number$")
	public void SearchForThePreauthNumber() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objBrainTreePage.SearchForThePreauthNumber());
	}

	@Then("^Open the transaction$")
	public void OpenTheTransaction() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objBrainTreePage.OpenTheTransaction());
	}

	@Then("^Void the transaction$")
	public void VoidTheTransaction() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objBrainTreePage.VoidTheTransaction());
	}

	@Then("^Navigate to this workflow$")
	public void NavigateToThisWorkflow() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objWorkflowDetailsPage.NavigateToThisWorkflow());
	}

	@Then("^Execute the workflow$")
	public void ExecuteTheWorkflow() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objWorkflowDetailsPage.ExecuteTheWorkflow());
	}

	@Then("^Edit the billing details$")
	public void EditTheBillingDetails() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objWorkflowDetailsPage.EditTheBillingDetails());
	}

	@Then("^Add new billing details$")
	public void AddNewBillingDetails() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objWorkflowDetailsPage.AddNewBillingDetails());
	}

	@Then("^Execute the workflow Again$")
	public void ExecuteTheWorkflowAgain() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objWorkflowDetailsPage.ExecuteTheWorkflowAgain());
	}

	@Then("^Get preauth number after reexecuting workflow$")
	public void getPreauthAfterReexecuting() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objWorkflowDetailsPage.getPreauthAfterReexecuting());
	}

	@Then("^Search for the new preauth number$")
	public void searchForTheNewPreauthNumber() throws Throwable {
		objUtilities.waitForPageLoad();

		Assert.assertTrue(objBrainTreePage.searchForTheNewPreauthNumber());
	}

}
