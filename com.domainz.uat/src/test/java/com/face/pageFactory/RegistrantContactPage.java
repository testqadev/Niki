package com.face.pageFactory;

import org.openqa.selenium.By;

import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class RegistrantContactPage {

	// Local variables
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();

	// textboxes
	By txtOrganisationName = By.xpath("//*[text()='Organisation']/following::input[1]");
	By txtFirstName = By.xpath("//*[text()='First Name']/following::input[1]");
	By txtLastName = By.xpath("//*[text()='Last Name']/following::input[1]");
	By txtAddress = By.xpath("//*[text()='Address']/following::input[1]");
	By txtCity = By.xpath("//*[text()='City']/following::input[1]");
	By txtState = By.xpath("//*[text()='State']/following::input[1]");
	By txtPostCode = By.xpath("//*[text()='Postcode']/following::input[1]");
	By txtPhoneNumber = By.xpath("//*[text()='Phone Number']/following::input[1]");
	By txtEmail = By.xpath("//*[@name='contact.email']");
	By txtConfirmationEmail = By.xpath("//*[text()='Email Confirmation']/following::input[1]");

	// Button
	By btnSaveRegistrant = By.xpath("//*[@name='saveRegistrant']");
	By btnContinueSaveContact = By.xpath("//*[@name='saveContact']");

	public boolean enterOrganisationName(String Organisationname) {
		return objWrapperFunctions.setText(txtOrganisationName, Organisationname);
	}

	public boolean enterFirstName(String FirstName) {
		return objWrapperFunctions.setText(txtFirstName, FirstName);
	}

	public boolean enterLastName(String LastName) {
		return objWrapperFunctions.setText(txtLastName, LastName);
	}

	public boolean enterAddress(String Address) {
		return objWrapperFunctions.setText(txtAddress, Address);
	}

	public boolean enterCity(String CityName) {
		return objWrapperFunctions.setText(txtCity, CityName);
	}

	public boolean enterState(String State) {
		return objWrapperFunctions.setText(txtState, State);
	}

	public boolean enterPostCode(String PostCode) {
		return objWrapperFunctions.setText(txtPostCode, PostCode);
	}

	public boolean enterPhoneNumber(String PhoneNumber) {
		return objWrapperFunctions.setText(txtPhoneNumber, PhoneNumber);
	}

	public boolean enterEmail(String Email) {
		return objWrapperFunctions.setText(txtEmail, Email);
	}

	public boolean enterConfirmationEmail(String ConfirmationEmail) {
		return objWrapperFunctions.setText(txtConfirmationEmail, ConfirmationEmail);
	}

	public boolean clickOnContinueSaveContact() {
		return objWrapperFunctions.click(btnContinueSaveContact);
	}

	public boolean clickSaveRegisterConstrant() {
		return objWrapperFunctions.click(btnSaveRegistrant);
	}
}
