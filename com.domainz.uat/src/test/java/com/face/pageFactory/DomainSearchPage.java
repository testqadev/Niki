package com.face.pageFactory;

import org.openqa.selenium.By;
import core.generic.Utilities;
import core.generic.WrapperFunctions;

public class DomainSearchPage {

	// Local variables
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	private Utilities objUtilities = new Utilities();
	// textfields
	By txtDomainName = By.xpath("//*[contains(@id,'domainSearchBox')]/preceding::input[56]");
	// checkbox
	By checkboxCom = By.xpath("//*[@id='search-tlds']/li[8]/input");
	By checkboxComAu = By.xpath("//*[@id='search-tlds']/li[9]/input");
	// button
	By btnSearch = By.xpath("//*[@id='domainSearchBox']/div[1]/div[3]/input");

	public boolean setDomainName(String domainname) {
		return objWrapperFunctions.setText(txtDomainName, domainname);
	}

	public boolean clickCheckBox() {
		return objWrapperFunctions.click(checkboxCom);
	}

	public boolean unCheckBox() {
		return objWrapperFunctions.click(checkboxComAu);
	}

	public boolean clickOnSearch() {
		return objWrapperFunctions.click(btnSearch);
	}

}
