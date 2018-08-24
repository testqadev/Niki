package com.face.pageFactory;

import org.openqa.selenium.By;

import core.generic.StepBase;
import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class WorkflowDetailsPage {

	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();

	// Links
	By lnkWorkflowOk = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[3]/td[3]/a");
	By lnkThisWorkflow = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/a[2]");
	By lnkEditbBillingDetails = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/div/table[3]/tbody/tr/td[1]/a");
	By lnkBackToworkflow = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/a");
	By lnkWorkflowDetails = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/div/a[2]");
	By lnkRetryPayment = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[3]/td/input");

	public String preauth2 = "before";
	static String lblpreauthNumber = "//*[text()[contains(.,'PreAuthNumber')]]/following::td[1]";
	// button
	By btnExecuteAction = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[3]/td/input");
	By rBtnBillingDetails = By.xpath("//*[@id=\'cardForm\']/table/tbody/tr[2]/td[1]/input");
	By btnSubmit = By.xpath("//*[@id=\'cardForm\']/table/tbody/tr[5]/td/input[2]");
	By btnretryPayment = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[3]/td[3]/a");
	By btnexecuteAction = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[3]/td/input");

	public boolean ExecuteTheWorkflow() throws Throwable {
		objUtilities.waitForPageLoad();
		objWrapperFunctions.click(lnkWorkflowOk);
		return objWrapperFunctions.click(btnExecuteAction);

	}

	public boolean NavigateToThisWorkflow() throws Throwable {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(lnkThisWorkflow);
	}

	public boolean EditTheBillingDetails() throws Throwable {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(lnkEditbBillingDetails);
	}

	public boolean AddNewBillingDetails() throws Throwable {
		objUtilities.waitForPageLoad();

		objWrapperFunctions.click(rBtnBillingDetails);
		return objWrapperFunctions.click(btnSubmit);
	}

	public boolean ExecuteTheWorkflowAgain() throws Throwable {
		objUtilities.waitForPageLoad();
		objWrapperFunctions.click(lnkBackToworkflow);
		objWrapperFunctions.click(lnkWorkflowDetails);
		objWrapperFunctions.click(btnretryPayment);
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(btnexecuteAction);
	}

	public boolean getPreauthAfterReexecuting() throws Throwable {
		objUtilities.waitForPageLoad();
		String getPreauthNumber = StepBase.driver.findElement(By.xpath(lblpreauthNumber)).getText();
		this.preauth2 = getPreauthNumber;
		return true;
	}
}
