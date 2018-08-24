package com.face.pageFactory;

import org.openqa.selenium.By;
import core.generic.StepBase;
import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class ClientAccountPage {

	// Local variables
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();

	String txtWorkflowID = "12967229";
	static String lblpreauthNumber = "//*[text()[contains(.,'PreAuthNumber')]]/following::td[1]";
	public static String preauth = "before";

	// textbox
	By txtCardOwnerNameDomainZ = By.xpath("//*[contains(@name,'creditCardBt.owner')]");
	By txtCardNumber = By.xpath("//*[@id='credit-card-number']");
	By txtcardcvvdomainZ = By.id("cvv");
	By txtEnteramount = By.xpath("//*[contains(@id,'amount')]");
	By WorkflowID = By.xpath("//input[@type='text'][@name='domain']");
	// button
	By btnGetworkflow = By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr[1]/td[4]/form/input[2]");
	By btnViewInvoicePrepaidDetail = By.xpath("//*[contains(text(),'View Invoice & Prepaid detail')]");
	By btnLoginAsClient = By.xpath("//*[contains(text(),'Login as client')]");
	By btnSubmit = By.xpath("//*[@id=\"rechargeOptions\"]/div[3]/input[2]");
	// checkbox
	By chkboxrechargeusingcreditcard = By.xpath("//*[contains(@class,'radio')]//*[contains(@id,'recharge-cc')]");
	By chkboxnewcreditcard = By.xpath("//*[contains(@id,'ccNew')]");
	// dropdown
	By drpdwncardexpirymonthdomainZ = By.id("expiration-month");
	By drpdwncardexpiryyeardomainZ = By.id("expiration-year");

	public boolean clickOnViewinvoiceandprepaiddetail() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(btnViewInvoicePrepaidDetail);
	}

	public boolean ClickloginAsClient() throws InterruptedException {
		objUtilities.waitForPageLoad();
		objWrapperFunctions.click(btnLoginAsClient);
		StepBase.driver.get("https://dmz-2.uat.a2development.net/execute2/account/newinterface/billing/manage-prepaid-account?currentTab=billing");
		objWrapperFunctions.waitForElement(3);
		String originalHandle = StepBase.driver.getWindowHandle();

		for (String handle : StepBase.driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				StepBase.driver.switchTo().window(handle);
				StepBase.driver.get("https://dmz-2.uat.a2development.net/execute2/account/newinterface/billing/manage-prepaid-account?currentTab=billing");
			}
		}
		objWrapperFunctions.waitForElement(4);
		return true;
	}

	public boolean ClickOnRechrgeUsingCreditCardButton() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(chkboxrechargeusingcreditcard);
	}

	public boolean ClickOnRechrgeUsingNewCreditCardButton() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(chkboxnewcreditcard);
	}

	public boolean enterCardOwnerNameDomainZ(String cardOwner) {
		return objWrapperFunctions.setText(txtCardOwnerNameDomainZ, cardOwner);
	}

	public boolean enterPrepaidCardNumberDomainZ(String cardNumber) throws InterruptedException {
		objUtilities.waitForPageLoad();
		objWrapperFunctions.waitForElement(4);
		objWrapperFunctions.switchToFrameUsingNameOrId("braintree-hosted-field-number");
		objWrapperFunctions.waitForElement(4);
		return objWrapperFunctions.setText(txtCardNumber, cardNumber);
	}

	public boolean enterPrepaidCardExpiryMonthDomainZ(String expiryMonth) throws InterruptedException {
		objUtilities.waitForPageLoad();
		objWrapperFunctions.waitForElement(4);
		objWrapperFunctions.switchToFrameUsingNameOrId("braintree-hosted-field-expirationMonth");
		return objWrapperFunctions.selectDropDownOption(drpdwncardexpirymonthdomainZ, expiryMonth, "Value");
	}

	public boolean enterPrepaidCardExpiryYearDomainZ(String expiryYear) throws InterruptedException {
		objUtilities.waitForPageLoad();
		objWrapperFunctions.waitForElement(4);
		objWrapperFunctions.switchToFrameUsingNameOrId("braintree-hosted-field-expirationYear");
		return objWrapperFunctions.selectDropDownOption(drpdwncardexpiryyeardomainZ, expiryYear, "Value");
	}

	public boolean enterPrepaidCardCVVNumberDomainZ(String CVVnumber) throws InterruptedException {
		objUtilities.waitForPageLoad();
		objWrapperFunctions.waitForElement(4);
		objWrapperFunctions.switchToFrameUsingNameOrId("braintree-hosted-field-cvv");
		objWrapperFunctions.setText(txtcardcvvdomainZ, CVVnumber);
		objWrapperFunctions.switchToDefaultContent();
		return true;
	}

	public boolean enterPrepaidAmountDomainZ(String prepaidamount) throws InterruptedException {
		try {
			objUtilities.waitForPageLoad();
			objWrapperFunctions.waitForElement(4);
			By amount = By.xpath("//div[@id='rechargeOptions']//div[@class='controls']//input[@name='amount']");
			objWrapperFunctions.setText(amount, prepaidamount);
			objWrapperFunctions.waitForElement(4);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean ClickOnSubmitButton() {
		objUtilities.waitForPageLoad();
		 objWrapperFunctions.click(btnSubmit);
		 objUtilities.waitForPageLoad();
		 return true;
	}

	public boolean searchtheworkflow() throws Throwable {
		objUtilities.waitForPageLoad();
		objWrapperFunctions.setText(WorkflowID, txtWorkflowID);
		objWrapperFunctions.click(btnGetworkflow);
		StepBase.driver.findElement(By.linkText(txtWorkflowID)).click();
		return true;
	}

	public String GetPreauthNumber() throws Throwable {
		objUtilities.waitForPageLoad();

		String getPreauthNumber = StepBase.driver.findElement(By.xpath(lblpreauthNumber)).getText();
		this.preauth = getPreauthNumber;
		System.out.println(getPreauthNumber);
		return getPreauthNumber;
	}
}
