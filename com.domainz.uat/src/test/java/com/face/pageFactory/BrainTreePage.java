package com.face.pageFactory;

import org.openqa.selenium.By;

import core.generic.StepBase;
import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class BrainTreePage {

	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private static Utilities objUtilities = new Utilities();

	// public String preauth = "before";
	public String preauth2 = "before";
	String txtBtusername = "makeyanvesh";
	String txtBtpassword = "Me!bourne1t";
	String txtSearchpreauth = "5pnzj9fn";
	String btURL = "https://sandbox.braintreegateway.com";
	static String lblpreauthNumber = "//*[text()[contains(.,'PreAuthNumber')]]/following::td[1]";
	// textbox
	By txtBtUsername = By.xpath("//*[@id=\'login\']");
	By txtBtPassword = By.xpath("//*[@id=\'password\']");
	By txtBtTransaction = By.xpath("//*[@id=\'app-west\']/div[2]/div[2]/ul/li[1]/a");
	By txtBttxtSearch = By.xpath("//*[@id=\'q\']");
	// button
	By btnVoidTransaction = By.xpath("//*[@id=\"void_txn_7cr807y6_form\"]");
	By btnVoidYes = By.xpath("/html/body/div[11]/div[3]/div/button[1]/span");
	By btnBtLogin = By.name("commit");
	By btnSearch = By.xpath("//*[@id=\'advanced_search_form\']/p/input");
	By btnBtSearchtrans = By.xpath("//*[@id=\'app-north\']/div/nav/div/form/input[2]");

	public boolean OpenBraintreePortal() throws Throwable {
		objUtilities.waitForPageLoad();
		StepBase.driver.get(btURL);
		objWrapperFunctions.setText(txtBtUsername, txtBtusername);
		objWrapperFunctions.setText(txtBtPassword, txtBtpassword);
		return objWrapperFunctions.click(btnBtLogin);
	}

	public boolean NavigateToTransactions() throws Throwable {
		objUtilities.waitForPageLoad();

		objWrapperFunctions.click(txtBtTransaction);
		return objWrapperFunctions.click(btnSearch);
	}

	public boolean SearchForThePreauthNumber() throws Throwable {
		objUtilities.waitForPageLoad();
		System.out.println(ClientAccountPage.preauth);
		objWrapperFunctions.setText(txtBttxtSearch, ClientAccountPage.preauth);
		return objWrapperFunctions.click(btnBtSearchtrans);

	}

	public boolean OpenTheTransaction() throws Throwable {
		objUtilities.waitForPageLoad();
		objWrapperFunctions.waitForElement(4);
		StepBase.driver.findElement(By.linkText(ClientAccountPage.preauth)).click();
		return true;
	}

	public boolean VoidTheTransaction() throws Throwable {
		objUtilities.waitForPageLoad();
		objWrapperFunctions.waitForElement(4);
		objWrapperFunctions.click(btnVoidTransaction);
		return objWrapperFunctions.click(btnVoidYes);
	}

	public boolean searchForTheNewPreauthNumber() throws Throwable {
		objUtilities.waitForPageLoad();
		System.out.println(this.preauth2);
		StepBase.driver.findElement(By.linkText(this.preauth2)).click();
		return true;
	}
}
