package com.face.pageFactory;

import org.openqa.selenium.By;

import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class DomainCheckOutPage {

	// Local variables
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();
	
	//Buttons
	By btnContinueToCheckout = By.xpath("//*[@id='continueCart']");
	By btnNoThanks = By.xpath("//*[@value='No thanks']");
	
	public boolean clickOnContinueToCheckout(){
		return objWrapperFunctions.click(btnContinueToCheckout);
	}

	public boolean clickOnNoThanksPopup(){
		return objWrapperFunctions.click(btnNoThanks);
	}
}
