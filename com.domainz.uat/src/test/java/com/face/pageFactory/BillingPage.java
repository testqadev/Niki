package com.face.pageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import core.generic.StepBase;
import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class BillingPage {

	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();

	// textbox
	By txtCardOwner = By.xpath("//*[@id='btbilling.owner']");
	By txtCardNumber = By.xpath("//*[@id='credit-card-number']");
	By txtCardCVV = By.xpath("//*[@id='cvv']");
	// label
	By lblCardOwnerMsg = By.xpath("//*[text()='Card Owner is a required field']");
	By lblCardNumberMsg = By.xpath("//*[text()='Card Number is a required field']");
	By lblCardCvvMsg = By.xpath("//*[text()='Card Security Code is a required field']");
	By lblinvalidCardNumber = By.xpath("//*[text()='Card Number is invalid']");
	By lblinvalidCvvNumber = By.xpath("//*[text()='Card Security Code is invalid']");
	By lblinvalidCardNumberAmex = By.xpath("//*[text()='Card type is not supported']");
	By lblinvalidCardNumberDiner = By.xpath("//*[text()='Card type is not supported']");
	By lblinvalidCardNumberJCB = By.xpath("//*[text()='Card type is not supported']");
	// button
	By btnPlaceOrder = By.xpath("//*[@id='processOrderButton']");
	// checkbox
	By chkboxTermsCondition = By.xpath("//*[@name='agreeTOS']");
	// dropdown
	By drpdwnCardExpiryMonth = By.xpath("//*[@id='expiration-month']");
	By drpdwnCardExpiryYear = By.xpath("//*[@id='expiration-year']");
	// Iframes
	By frameIdCardNumber = By.xpath("//*[@id='braintree-hosted-field-number']");
	By frameIdCardExpiryMonth = By.xpath("//*[@id='braintree-hosted-field-expirationMonth']");
	By frameIdCardExpiryYear = By.xpath("//*[@id='braintree-hosted-field-expirationYear']");
	//By frameIdCardCvv = By.xpath("//*[@id='braintree-hosted-field-cvv']");
	By frameIdCardCvv = By.id("braintree-hosted-field-cvv");

	public boolean enterCardOwner(String CardOwner) {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.setText(txtCardOwner, CardOwner);
	}

	public boolean switchToFrame() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.switchToFrameUsingIframeElement(frameIdCardNumber);
	}

	public boolean enterCardNumber(String CardNumber) {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.setText(txtCardNumber, CardNumber);
	}

	public boolean switchToFrameExpiryMonth() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.switchToFrameUsingIframeElement(frameIdCardExpiryMonth);
	}

	public boolean enterCardExpiryMonth(String dropdownmonth) {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.selectDropDownOption(drpdwnCardExpiryMonth, dropdownmonth, "Value");
	}

	public boolean switchToFrameExpiryYear() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.switchToFrameUsingIframeElement(frameIdCardExpiryYear);
	}

	public boolean enterCardExpiryYear(String dropdownyear) {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.selectDropDownOption(drpdwnCardExpiryYear, dropdownyear, "Value");
	}

	public boolean switchToFrameCVV() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.switchToFrameUsingNameOrId("braintree-hosted-field-cvv");
	}

	public boolean enterCardCVV(String CVV) {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.setText(txtCardCVV, CVV);
	}

	public boolean selectTermsAndConditions() {
		StepBase.driver.switchTo().defaultContent();
		return objWrapperFunctions.click(chkboxTermsCondition);
	}

	public boolean clickOnContinueButton() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(btnPlaceOrder);
	}

	public boolean clearCardOwnerName() {
		return objWrapperFunctions.clearText(txtCardOwner);
	}

	public boolean clearCardNumber() throws InterruptedException, AWTException {
		objWrapperFunctions.waitForElement(5);
		objWrapperFunctions.clearText(txtCardNumber);
		objWrapperFunctions.wait(8000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		return true;
	}

	public boolean clearCardCvv() throws InterruptedException {
		objWrapperFunctions.clearText(txtCardCVV);
		objWrapperFunctions.waitForElement(5);
		return true;
	}

	public String verifyAlertMsgCardOwner(String msgcardowner) {
		msgcardowner = objWrapperFunctions.getText(lblCardOwnerMsg, "Text");
		return msgcardowner;
	}

	public String verifyAlertMsgCardNumber(String msgcardnumber) throws InterruptedException {
		objWrapperFunctions.waitForElement(5);
		msgcardnumber = objWrapperFunctions.getText(lblCardNumberMsg, "Text");
		return msgcardnumber;
	}

	public String verifyAlertMsgCardCvv(String msgcvv) throws InterruptedException {
		objWrapperFunctions.waitForElement(5);
		msgcvv = objWrapperFunctions.getText(lblCardCvvMsg, "Text");
		return msgcvv;
	}

	public String verifyAlertMsgInvalidCardNumber(String invalidCardNum) {
		invalidCardNum = objWrapperFunctions.getText(lblinvalidCardNumber, "Text");
		return invalidCardNum;
	}

	public String verifyAlertMsgInvalidCvvNumber(String invalidCvvNum) {
		invalidCvvNum = objWrapperFunctions.getText(lblinvalidCvvNumber, "Text");
		System.out.println(invalidCvvNum);
		return invalidCvvNum;
	}

	public String verifyAlertMsgInvalidCardNumberAmex(String invalidCardNumAmex) {
		invalidCardNumAmex = objWrapperFunctions.getText(lblinvalidCardNumberAmex, "Text");
		return invalidCardNumAmex;
	}

	public String verifyAlertMsgInvalidCardNumberDiner(String invalidCardNumDiner) {
		invalidCardNumDiner = objWrapperFunctions.getText(lblinvalidCardNumberDiner, "Text");
		return invalidCardNumDiner;
	}

	public String verifyAlertMsgInvalidCardNumberJCB(String invalidCardNumJCB) {
		invalidCardNumJCB = objWrapperFunctions.getText(lblinvalidCardNumberJCB, "Text");
		return invalidCardNumJCB;
	}
}
