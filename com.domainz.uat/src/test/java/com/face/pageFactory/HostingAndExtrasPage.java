package com.face.pageFactory;

import org.openqa.selenium.By;

import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class HostingAndExtrasPage {

	// Local variables
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();

	//button
	By btnContinueHostingAndExtras = By.xpath("//*[@id='save-order-form']/input");

	public boolean clickOnContinueHosting() {
		return objWrapperFunctions.click(btnContinueHostingAndExtras);
	}
}
