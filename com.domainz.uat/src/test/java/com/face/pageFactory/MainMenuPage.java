package com.face.pageFactory;

import org.openqa.selenium.By;

import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class MainMenuPage {

	// Local variables
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();

	By txtSearchGreen = By.xpath("//input[@name='greencode'][@size='8']");
	By btnSubmit = By.xpath("(//input[@name='submit'])[2]");

	// Enter GreenCode
	public boolean enterGreencode(String greencode) {
		return objWrapperFunctions.setText(txtSearchGreen, greencode);
	}

	// Click on Submit
	public boolean clickOnSubmitButton() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(btnSubmit);
	}
}
