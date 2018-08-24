package com.face.pageFactory;

import org.openqa.selenium.By;
import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class InvoicesPage {

	// Local variables
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();

	By clickPrepaidAccountDetail = By.xpath("//*[contains(text(),'Prepaid Account Details')]");

	// Click on prepaid account details
	public boolean clickOnprepaidaccountdetails() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(clickPrepaidAccountDetail);
	}
}
