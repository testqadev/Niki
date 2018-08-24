package com.face.pageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import core.generic.StepBase;
import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class PrepaidCreditPage {

	// Local variables
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();
	
	
	// Prepaid recharge using New credit card
	By txtcardownername = By.xpath("//*[contains(@name,'cardOwner')]");
	By txtvisacardnumber = By.xpath("//*[contains(@name,'credit-card-number')]");
	By txtcardCVVnumber = By.xpath("//*[@id='cvv']");
	By txtEnterAmount = By.xpath("//*[contains(@id,'creditCardAmount')]");

	// radio button
	By rBtnselectExistingCard = By.xpath("//*[contains(@id,'useExistingBilling')]");

	// Buttons
	By btnPurchaseCredit = By.xpath("//*[contains(@id,'purchaseCredit')]");

	// Frames
	By frameCardnumber = By.xpath("//*[@id='braintree-hosted-field-number']");
	By frameAdminIdCardExpiryMonth = By.xpath("//*[@id='braintree-hosted-field-expirationMonth']");
	By framecardexpiryyear = By.xpath("//*[@id='braintree-hosted-field-expirationYear']");
	By framecardCVV = By.xpath("//*[@id='braintree-hosted-field-cvv']");

	// dropdown
	By drpdwncardexpirymonth = By.xpath("//*[@class='expirationMonth']");
	By drpdwncardexpiryyear = By.xpath("//*[contains(@class,'expirationYear')]");

	// Labels
	By lblSuccessCreditMessage = By.xpath("//*[contains(@id,'msg')]");

	// Select existing credit card
	public boolean selectexistingcreditcard() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(rBtnselectExistingCard);
	}

	// Enter amount in purchase credit field
	public boolean enterAmountPrepaid(String prepaidamount) {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.setText(txtEnterAmount, prepaidamount);
	}

	// Click on purchase credit button
	public boolean Clickpurchasecredit() throws AWTException, InterruptedException {
		try {
			objUtilities.waitForPageLoad();
			objWrapperFunctions.waitForElement(3);
			objWrapperFunctions.waitForElementPresence(btnPurchaseCredit, 3);
			objWrapperFunctions.click(btnPurchaseCredit);
			objWrapperFunctions.waitForElement(3);
			Alert alert = StepBase.driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			objWrapperFunctions.waitForElement(5);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public String verifySuccessMSG(String prepaidsuccess) throws InterruptedException {
		objUtilities.waitForPageLoad();
		try {
			prepaidsuccess = objWrapperFunctions.getText(lblSuccessCreditMessage, "Text");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepaidsuccess;
	}

	public boolean enterCardOwnerName(String CardOwnerName) {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.setText(txtcardownername, CardOwnerName);
	}

	public boolean switchAdminToFrame() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.switchToFrameUsingIframeElement(frameCardnumber);
	}

	public boolean enterPrepaidCardNumber(String CardNumber) throws InterruptedException {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.setText(txtvisacardnumber, CardNumber);
	}

	public boolean switchAdminToFrameExpiryMonth() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.switchToFrameUsingIframeElement(frameAdminIdCardExpiryMonth);
	}

	public boolean enterPrepaidCardExpiryMonth(String CardExpiryMonth) throws InterruptedException {
		return objWrapperFunctions.selectDropDownOption(drpdwncardexpirymonth, CardExpiryMonth, "Value");
	}

	public boolean switchAdminToFrameExpiryYear() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.switchToFrameUsingIframeElement(framecardexpiryyear);
	}

	public boolean enterPrepaidCardExpiryYear(String CardExpiryYear) throws InterruptedException {
		return objWrapperFunctions.selectDropDownOption(drpdwncardexpiryyear, CardExpiryYear, "Value");
	}

	public boolean switchAdminToFrameCVV() {
		objUtilities.waitForPageLoad();
		
		try {
			 objWrapperFunctions.switchToFrameUsingIframeElement(framecardCVV);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean enterPrepaidCardCVVNumber(String CardCVV) throws InterruptedException {
		objWrapperFunctions.setText(txtcardCVVnumber, CardCVV);
		try {
			objWrapperFunctions.switchToDefaultContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
