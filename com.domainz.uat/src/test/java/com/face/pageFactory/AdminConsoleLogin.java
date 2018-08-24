package com.face.pageFactory;

import org.junit.Assert;
import org.openqa.selenium.By;

import core.generic.StepBase;
import core.generic.Utilities;
import core.generic.WrapperFunctions;
import cucumber.api.java.en.Then;

public class AdminConsoleLogin {
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();
	
	String consoleURL = "https://theconsole-2.uat.a2development.net/admin/";
	//textboxes
	By txtadminUserName = By.xpath("//*[contains(text(),'Username')]/following::input[1]");
	By txtadminPassword = By.xpath("//*[contains(text(),'Password')]/following::input[1]");
	//button
	By btnSubmit = By.name("submit");
	

	public boolean enterUserName(String userName) {
		StepBase.driver.get(consoleURL);
		return objWrapperFunctions.setText(txtadminUserName, userName);
	}

	public boolean enterPassword(String password) {
		return objWrapperFunctions.setText(txtadminPassword, password);
	}

	public boolean clickOnLoginButton() {
		objUtilities.waitForPageLoad();
		return objWrapperFunctions.click(btnSubmit);
	}
}
