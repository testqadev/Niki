package com.face.pageFactory;

import org.openqa.selenium.By;

import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class AccountContactPage {

	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();

	By btnViewInvoicePrepaidDetail = By.xpath("//*[contains(text(),'View Invoice & Prepaid detail')]");

	public boolean clickOnViewinvoiceandprepaiddetail() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(btnViewInvoicePrepaidDetail);
	}
}
