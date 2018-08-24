package core.generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WrapperFunctions
{
	private StepBase objStepBase = new StepBase();
	protected static WebDriver driver = null;
	
	
	
	
	/**
	 * @Method: waitForElementToBeClickable
	 * @Description: This is wrapper method wait for element to be click able
	 * @param locator - By identification of element
	 * @param waitInSeconds - wait time  
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 13 Dec 2017   @Modified Date:
	 */
	public void waitForElementToBeClickable(By locator, int waitInSeconds) 
	{
		try 
		{
			Wait<WebDriver> wait = new WebDriverWait(objStepBase.getDriver(), waitInSeconds).ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} 
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method: waitForElementPresence
	 * @Description: This is wrapper method wait for element presence
	 * @param locator - By identification of element
	 * @param waitInSeconds - wait time 
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 13 Dec 2017   @Modified Date:
	 */
	public void waitForElementPresence(By locator, int waitInSeconds) 
	{
		try 
		{
			Wait<WebDriver> wait = new WebDriverWait(objStepBase.getDriver(), waitInSeconds).ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} 
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	} 

	/**
	 * @Method: checkElement_Existance
	 * @Description: This is wrapper method to check the existence of any web element on the page
	 * @param locator - By identification of element
	 * @param waitInSeconds - wait time 
	 * @return - true if element present  
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 13 Dec 2017   @Modified Date:
	 */
	public boolean checkElementExistence(By locator, int... sTimeInSecond)
	{
		try 
		{
			WebDriverWait wait = null;
			if(sTimeInSecond.length > 0)
			{
				wait = new WebDriverWait(objStepBase.getDriver(), sTimeInSecond[0]);
			}
			else
			{
				wait = new WebDriverWait(objStepBase.getDriver(), 10);
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			WebElement ele= objStepBase.getDriver().findElement(locator);
			return ele.isDisplayed();
		}
		catch(Exception exception)
		{
			exception.printStackTrace(); 
			return false;
		}
	}

	/**
	 * @Method: click
	 * @Description: This is wrapper method to click on web element 
	 * @param locator - By identification of element
	 * @return - true if click successful
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 15 Dec 2017   @Modified Date:
	 */
	public boolean click(By locator) 
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = objStepBase.getDriver().findElement(locator);
		try
		{
			JavascriptExecutor executor = (JavascriptExecutor)objStepBase.getDriver();
			executor.executeScript("arguments[0].click();", webElement);
			return true;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	

	/**
	 * @Method: doubleClick
	 * @Description: This is wrapper method used for doubleClick on element
	 * @param locator - By identification of element
	 * @return - true if double click successful
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 15 Dec 2017   @Modified Date:
	 */
	public boolean doubleClick(By locator)
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = objStepBase.getDriver().findElement(locator);
		try
		{
			Actions actionBuilder = new Actions(objStepBase.getDriver());
			actionBuilder.doubleClick(webElement).build().perform();
			return true;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: setText
	 * @Description: This is wrapper method to set text for input element
	 * @param locator - By identification of element
	 * @param fieldValue - field value as string 
	 * @return - true if text entered successfully
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 15 Dec 2017   @Modified Date:
	 */
	 public boolean setText(By locator, String fieldValue) 
	 {
	  waitForElementPresence(locator, 10);
	  WebElement webElement = objStepBase.getDriver().findElement(locator);
	  try
	  {
	   // replace the text
	   JavascriptExecutor executor = (JavascriptExecutor)objStepBase.getDriver();
	   executor.executeScript("arguments[0].click();", webElement);
	   webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	   webElement.sendKeys(Keys.DELETE);
	   webElement.clear();
	   webElement.sendKeys(fieldValue);
	   //webElement.sendKeys(Keys.TAB);
	   return true;
	  } 
	  catch (Exception exception)
	  {
	   exception.printStackTrace();
	   return false;
	  }
	 }

	/**
	 * @Method: getText
	 * @Description: This is wrapper method to get text form input elements
	 * @param locator - By identification of element
	 * @param textBy - get text by value attribute (set textBy as value)/ by visible text (set textBy as text)
	 * @return - text as string
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 18 Dec 2017   @Modified Date: 
	 */
	public String getText(By locator, String textBy) 
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = objStepBase.getDriver().findElement(locator);
		try
		{
			String strText = "";
			if(textBy.equals("value"))
				strText = webElement.getAttribute("value");
			else if(textBy.equalsIgnoreCase("text"))
				//strText = webElement.getText();
			strText = webElement.getText();
			return strText; 
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method: selectCheckBox
	 * @Description: This is wrapper method select/deselect checkbox
	 * @param locator - By identification of element
	 * @param status - select/deselect 
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 18 Dec 2017   @Modified Date:
	 */
	public boolean selectCheckBox(By locator, boolean status) 
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = objStepBase.getDriver().findElement(locator);
		try
		{
			if(webElement.getAttribute("type").equals("checkbox"))   
			{
				if((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			}
			else
				return false;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: isCheckBoxSelected
	 * @Description: This is wrapper checkbox is selected or not
	 * @param locator - By identification of element
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 18 Dec 2017   @Modified Date:
	 */
	public boolean isCheckBoxSelected(By locator, boolean status) 
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = objStepBase.getDriver().findElement(locator);
		boolean state = false;
		try
		{
			if(webElement.getAttribute("type").equals("checkbox"))   
				state = webElement.isSelected();

			return state;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: selectRadio
	 * @Description: This is wrapper method select/deselect radio button
	 * @param locator - By identification of element
	 * @param status - select/deselect 
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 19 Dec 2017   @Modified Date:
	 */
	public boolean selectRadioButton(By locator, boolean status)
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = objStepBase.getDriver().findElement(locator);
		try
		{
			if(webElement.getAttribute("type").equals("radio"))   
			{
				if((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			}
			else
				return false;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: mouseHover
	 * @Description: This is wrapper method used for Mouse Hovering to the element
	 * @param locator - By identification of element
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 19 Dec 2017   @Modified Date:
	 */
	public boolean mouseHover(By locator)
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = objStepBase.getDriver().findElement(locator);
		try
		{
			Actions actionBuilder = new Actions(objStepBase.getDriver());
			actionBuilder.moveToElement(webElement).build().perform();
			return true;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: switchToWindowUsingTitle
	 * @Description: This is wrapper method used switch to window using the given title
	 * @param locator - Window title
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 19 Dec 2017   @Modified Date:
	 */
	public boolean switchToWindowUsingTitle(String windowTitle)
	{
		try
		{
			String mainWindowHandle = objStepBase.getDriver().getWindowHandle();
			Set<String> openWindows = objStepBase.getDriver().getWindowHandles();

			if (!openWindows.isEmpty()) 
			{
				for (String windows : openWindows) 
				{
					String window = objStepBase.getDriver().switchTo().window(windows).getTitle();
					if (windowTitle.equals(window)) 
						return true;
					else 
						objStepBase.getDriver().switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: selectDropdown
	 * @Description: This is wrapper method select drop down element
	 * @param locator - By identification of element
	 * @param option - drop down element (user may specify text/value/index)
	 * @param selectType - select dorp down element by Text/Value/Index
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 19 Dec 2017   @Modified Date:
	 */
	public boolean selectDropDownOption(By locator, String option, String... selectType) 
	{
		try
		{
			waitForElementPresence(locator, 10);
			WebElement webElement = objStepBase.getDriver().findElement(locator);
			Select sltDropDown = new Select(webElement);
			
			if(selectType.length > 0 && !selectType[0].equals(""))
			{
				if(selectType[0].equals("Value"))
					sltDropDown.selectByValue(option);
				else if(selectType[0].equals("Text"))
					sltDropDown.selectByVisibleText(option);
				else if(selectType[0].equals("Index"))
					sltDropDown.selectByIndex(Integer.parseInt(option));

				return true;
			}
			else
			{
				// Web elements from dropdown list 
				List<WebElement> options = sltDropDown.getOptions();
				boolean blnOptionAvailable = false;
				int iIndex = 0;
				for(WebElement weOptions : options)  
				{  
					if (weOptions.getText().trim().equals(option))
					{
						sltDropDown.selectByIndex(iIndex);
						blnOptionAvailable = true;
					}
					else
						iIndex++;
					if(blnOptionAvailable)
						break;
				}
				if(blnOptionAvailable)
					return true;
				else
					return false;
			}
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: getSelectedValueFormDropDown
	 * @Description: This is wrapper method select drop down element
	 * @param locator - By identification of element
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 20 Dec 2017   @Modified Date:
	 */
	public String getSelectedValueFormDropDown(By locator) 
	{
		try
		{
			waitForElementPresence(locator, 10);
			Select selectDorpDown = new Select(objStepBase.getDriver().findElement(locator));
			String selectedDorpDownValue = selectDorpDown.getFirstSelectedOption().getText();
			return selectedDorpDownValue;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}

	}
	/**
	 * @Method: selectRadioButtonForSpecificColumn
	 * @Description: This is wrapper method to select radio button from table with respect to particular column content
	 * @param locator - By identification of element (table with all rows)
	 * @param columnContent - String column content
	 * @columnNumberForRadio - integer column number for radio button
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 20 Dec 2017   @Modified Date:
	 */
	public boolean selectRadioButtonForSpecificColumn(By locator, String columnContent, int columnNumberForRadio) 
	{
		try
		{
			waitForElementPresence(locator, 10);
			List<WebElement> weResultTable = objStepBase.getDriver().findElements(locator);
			for(WebElement weRow : weResultTable)
			{
				List<WebElement> weColumns = weRow.findElements(By.xpath(".//td"));
				for(WebElement weColumn : weColumns)
				{
					if(weColumn.getText().trim().equals(columnContent))
					{
						WebElement webElement = weRow.findElement(By.xpath(".//td['" + columnNumberForRadio + "']/input[@type='radio']"));
						JavascriptExecutor executor = (JavascriptExecutor)objStepBase.getDriver();
						executor.executeScript("arguments[0].click();", webElement);
					}
				}
			}
			return true;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: selectCheckBoxForSpecificColumn
	 * @Description: This is wrapper method to select check box from table with respect to particular column content
	 * @param locator - By identification of element (table with all rows)
	 * @param columnContent - String column content
	 * @columnNumberForRadio - integer column number for radio button
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 20 Dec 2017   @Modified Date:
	 */
	public boolean selectCheckBoxForSpecificColumn(By locator, String columnContent, int columnNumberForRadio) 
	{
		try
		{
			waitForElementPresence(locator, 10);
			List<WebElement> weResultTable = objStepBase.getDriver().findElements(locator);
			for(WebElement weRow : weResultTable)
			{
				List<WebElement> weColumns = weRow.findElements(By.xpath(".//td"));
				for(WebElement weColumn : weColumns)
				{
					if(weColumn.getText().trim().equals(columnContent))
						weRow.findElement(By.xpath(".//td['" + columnNumberForRadio + "']/span/input[@type='checkbox']")).click();
				}
			}
			return true;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: verifyTableContent
	 * @Description: 
	 * @param locator - By identification of element (table with all rows)
	 * @param columnHeader - String column header
	 * @param columnContent - String column content
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 22 Dec 2017  @Modified Date:
	 */
	public boolean verifyTableContent(By locator, String columnHeader, String columnContent) 
	{
		Hashtable<String , String> dataColumnHeader = new Hashtable<String, String>();
		int intColumnNumber = 1;
		boolean blnverify = false;
		try
		{
			waitForElementPresence(locator, 10);
			WebElement weResultTable = objStepBase.getDriver().findElement(locator);

			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			for(WebElement weColumnHeader : weColumnsHeaders)
			{
				String strHeader = weColumnHeader.getText().trim();
				if(!strHeader.equals(""))
					dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
				intColumnNumber ++;
			}

			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for(WebElement weRow : weRows)
			{
				System.out.println( dataColumnHeader.get(columnHeader));
				WebElement weExceptedClm = weRow.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeader) + "]"));
				if(weExceptedClm.getText().trim().contains(columnContent))
					blnverify = true;
			}

			return blnverify;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: verifyTableContentAndCheckSelected
	 * @Description: 
	 * @param locator - By identification of element (table with all rows)
	 * @param columnHeader - String column header
	 * @param columnContent - String column content
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 22 Dec 2017   @Modified Date:
	 */
	public boolean verifyTableContentAndCheckSelected(By locator, String columnHeader, String columnContent, int checkboxColumnNumber) 
	{
		Hashtable<String , String> dataColumnHeader = new Hashtable<String, String>();
		int intColumnNumber = 1;
		boolean blnverify = false;
		try
		{
			waitForElementPresence(locator, 10);
			WebElement weResultTable = objStepBase.getDriver().findElement(locator);

			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			for(WebElement weColumnHeader : weColumnsHeaders)
			{
				String strHeader = weColumnHeader.getText().trim();
				if(!strHeader.equals(""))
					dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
				intColumnNumber ++;
			}

			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for(WebElement weRow : weRows)
			{
				WebElement weExceptedClm = weRow.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeader) + "]"));
				if(weExceptedClm.getText().trim().contains(columnContent))
				{
					WebElement weCheckBox = weRow.findElement(By.xpath(".//td[" + checkboxColumnNumber + "]/span/input[@type='checkbox']"));
					boolean blnIsSelected = weCheckBox.isSelected();
					if(blnIsSelected)
					{
						blnverify = true;
					}
				}
			}
			return blnverify;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: view table details
	 * @Description: 
	 * @param locator - By identification of table element
	 * @Author: Digvijay Dusane(Aress) @Creation Date : 25 Dec 2017   @Modified Date:
	 */
	public boolean viewTableContent(By locator) 
	{
		try
		{
			PrintStream myconsole = new PrintStream(new File("D://java.txt"));
			WebElement weResultTable = objStepBase.getDriver().findElement(locator);

			int intHeaderNumber = 1;
			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			System.out.println("************************* Table Header details *************");
			myconsole.print("************************* Table Header details *************");
			for(WebElement weColumnHeader : weColumnsHeaders)
			{
				System.out.println("Table Header * " + intHeaderNumber + " *--->" + weColumnHeader.getText());
				intHeaderNumber++;
			}

			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			int intRowNum = 1 ;
			System.out.println("************************* Table content details *************");
			for(WebElement weRow : weRows)
			{
				System.out.println("**********Row Number  " + intRowNum + " *************");
				int intClmNum = 1 ;  
				List<WebElement> weClmns = weRow.findElements(By.xpath(".//td"));
				for(WebElement weClmn : weClmns)
				{
					System.out.println("Column Number---->" + intClmNum);
					System.out.println("Column Text-------->" + weClmn.getText());
					intClmNum++;
				}
				intRowNum++;
			}
			return true;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	public boolean navigateURL(String url) {
		System.out.println("*************  In navigate function********");
		objStepBase.getDriver().get(url);
		return false;
	}
	
	public void scrollDown() throws InterruptedException  {
		Thread.sleep(2000);
		  JavascriptExecutor jse = (JavascriptExecutor)objStepBase.getDriver();
		  jse.executeScript("window.scrollBy(0,400)", "");
	}
	
	/**
	 * @Method		: sendKeyBoardKeys
	 * @Description	: This is wrapper method is used to send keyboard keys
	 * @param		: locator - By identification of element
	 * @param		: key - key name
	 * @return		: - true if text entered successfully
	 * @author		: Digvijay Dusane (Aress) 
	 * @param waitInSeconds 
	 */
	public boolean sendKeyBoardKeys(By locator, String key, int waitInSeconds) 
	{
		try
		{
			waitForElementPresence(locator, waitInSeconds);
			WebElement webElement = objStepBase.getDriver().findElement(locator);
			if(key.equalsIgnoreCase("enter"))
				webElement.sendKeys(Keys.ENTER);
			if(key.equalsIgnoreCase("shift"))
				webElement.sendKeys(Keys.SHIFT);
			if(key.equalsIgnoreCase("arrow_up"))
				webElement.sendKeys(Keys.ARROW_UP);
			if(key.equalsIgnoreCase("tab"))
				webElement.sendKeys(Keys.TAB);
			return true;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	public void selectTime() throws InterruptedException {
		  objStepBase.getDriver().findElement(By.xpath("//input[contains(@fieldname, 'Time')]")).click();
		  Thread.sleep(2000);
		  WebElement hours = objStepBase.getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/dl/dd[2]/div/span"));
		     for (int i = 1; i <=5 ; i++) {
		      hours.sendKeys(Keys.ARROW_UP);
		  }
		  WebElement mins = objStepBase.getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/dl/dd[3]/div/span"));
		   for (int i = 1; i <=20 ; i++) {
		       mins.sendKeys(Keys.ARROW_UP);
		  }
	}
	
	public void uploadPhoto(By locator, String filePath) {
		filePath = System.getProperty("user.dir") + "/src/main/resources/testData/testImage.jpg";
		WebElement uploadElement = objStepBase.getDriver().findElement(locator);
		System.out.println("****Started uploading");
        uploadElement.sendKeys(filePath);
        System.out.println("****Done uploading");
	}
	
	public void acceptDefult() {
		//WebElement uploadElement = objStepBase.getDriver().findElement(locator);
		objStepBase.getDriver().switchTo().alert().accept();
        
        
	}
	   
	public void sleep() throws InterruptedException
	{
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeExcel() throws InterruptedException
	{
		try {
			FileOutputStream file = new FileOutputStream ("‪C:\\Users\\user\\Documents\\consoleoutput.xls");
			//File.write(file);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
		try {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				Actions action = new Actions(driver);
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
		}
	}
	
	public void dragndrop(By locator)
	{
		Actions act=new Actions(driver);
		 
		// find element which we need to drag
		WebElement drag=driver.findElement(locator);
		 
		// find element which we need to drop
		WebElement drop=driver.findElement(locator);
		 
		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();
	}
	
	
	/**
	 * @Method: switchToWindowUsingURL
	 * @Description : This is wrapper method used switch to window using the given
	 *              URL
	 * @param :
	 *            locator - Window title
	 * @CreatedDate: 17-4-2018
	 * @author: Digvijay Dusane
	 */

	public boolean switchToWindowUsingURL(String windowURL) {
		try {
			String mainWindowHandle = StepBase.driver.getWindowHandle();
			Set<String> openWindows = StepBase.driver.getWindowHandles();
			if (!openWindows.isEmpty()) {
				for (String windows : openWindows) {
					String currentWindowURL = StepBase.driver.switchTo().window(windows).getCurrentUrl();
					if (windowURL.equals(currentWindowURL))
						return true;
					else
						StepBase.driver.switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToWindowUsingHandle
	 * @Description : This is wrapper method used switch to window using the given
	 *              Handle
	 * @param :
	 *            locator - Window title
	 * @author: Digvijay Dusane
	 */

	public boolean switchToWindowUsingHandle(String windowHandle) {
		try {
			String mainWindowHandle = StepBase.driver.getWindowHandle();
			Set<String> openWindows = StepBase.driver.getWindowHandles();
			if (!openWindows.isEmpty()) {
				for (String windows : openWindows) {
					StepBase.driver.switchTo().window(windows);
					if (windows.equals(windowHandle))
						return true;
					else
						StepBase.driver.switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method: closeWindowUsingHandle
	 * @Description : This is wrapper method to close window using the given Handle
	 * @param :
	 *            locator - Window title
	 * @author: Digvijay Dusane
	 */

	public boolean closeWindowUsingHandleAndSwitchToAnotherWindow(String windowHandleToClose,
			String mainWindowHandleSwitch) {
		try {
			String mainWindowHandle = StepBase.driver.getWindowHandle();
			Set<String> openWindows = StepBase.driver.getWindowHandles();
			if (!openWindows.isEmpty()) {
				for (String windows : openWindows) {
					StepBase.driver.switchTo().window(windows);
					if (windows.equals(windowHandleToClose)) {
						StepBase.driver.close();
						System.out.println("*************** Closed window");
						StepBase.driver.switchTo().window(mainWindowHandleSwitch);
						System.out.println("*************** Switched window");
						return true;
					} else
						StepBase.driver.switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchTabToRight
	 * @Description : switch to tab to right (work only if new tab get opened to
	 *              right from main current window)
	 * @param :
	 * @CreatedDate: 17-4-2018
	 * @author: Digvijay Dusane
	 */

	public boolean switchTabToRight() {
		try {
			String mainWindowHandle = StepBase.driver.getWindowHandle();
			Set<String> openWindows = StepBase.driver.getWindowHandles();
			if (!openWindows.isEmpty()) {
				for (String windows : openWindows) {
					if (!windows.equals(mainWindowHandle)) {
						StepBase.driver.switchTo().window(windows);
						return true;
					}
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @Method : switchToFrameUsingIframe_Element
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param :
	 *            locator - The most common one. You locate your iframe like other
	 *            elements, then pass it into the method
	 *            eg.driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@title='Fill
	 *            Quote']")))
	 * @author : Digvijay Dusane
	 * @CreatedDate: 17-4-2018
	 */

	public boolean switchToFrameUsingIframeElement(By locator) {
		try {
			StepBase.driver.switchTo().defaultContent();
			StepBase.driver.switchTo().frame(StepBase.driver.findElement(locator));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @Method : switchToFrameUsingNameOrId
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param :
	 *            frameName - Name/Id of frame you want to switch
	 * @CreatedDate: 17-4-2018
	 * @author : Digvijay Dusane
	 */

	public boolean switchToFrameUsingNameOrId(String frameName) {
		try {
			StepBase.driver.switchTo().defaultContent();
			StepBase.driver.switchTo().frame(frameName);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @Method : switchToFrameUsingIndex
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param :index
	 *            - Index on page
	 * @author : Digvijay Dusane
	 * @CreatedDate: 17-4-2018
	 */

	public boolean switchToFrameUsingIndex(int index) {

		try {
			StepBase.driver.switchTo().defaultContent();
			StepBase.driver.switchTo().frame(index);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

	/**
	 * @Method : switchToDefaultContent
	 * @Description : This method will switch you to the default Window
	 * @author: Digvijay Dusane
	 */

	public void switchToDefaultContent() {
		StepBase.driver.switchTo().defaultContent();

	}

	/**
	 * @Method : getAttribute
	 * @Description : This function return locator attribute
	 * @param: locator
	 *             - By identification of element
	 * @author : Digvijay Dusane
	 * @CreatedDate: 17-4-2018
	 */

	public String getAttribute(By locator, String sElementAttribute) {
		try {
			waitForElementPresence(locator, 10);
			WebElement webElement = StepBase.driver.findElement(locator);
			return webElement.getAttribute(sElementAttribute);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @method: getTagName
	 * @param: locator
	 * @return: TageName for given locator
	 * @author: Digvijay Dusane
	 * @CreatedDate: 17-4-2018
	 * 
	 */

	public String getTagName(By locator) {
		try {
			WebElement webElement = StepBase.driver.findElement(locator);
			return webElement.getTagName();
		} catch (Exception exception) {
			return null;
		}
	}

	public void clickUsingJavaScript(By locator) {
		WebElement element = StepBase.driver.findElement(locator);
		StepBase.driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) StepBase.driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	/**
	 * @method: isElementPresent
	 * @param: locator
	 * @author: Dishant
	 * @CreatedDate: 05-6-2018
	 * 
	 */

	private static boolean isElementPresent(By locator) {
		  return true; }  
	 
	public static void GetClickEvent(By locator)
	  {
	   if(isElementPresent(locator))
	   {
	  	 driver.findElement(locator).click();
	  	 System.out.println("Service alert prompt dismissed successfully");
	   	}else {
	   		System.out.println("Service alert prompt is NOT displayed");
	   }
	  }

	/**
	 * @method: clearText
	 * @param: locator
	 * @author: Dishant
	 * @CreatedDate: 06-06-2018
	 */
	public boolean clearText(By locator){
		  waitForElementPresence(locator, 10);
		  WebElement webElement = objStepBase.getDriver().findElement(locator);

	try{
		webElement.clear();
		return true;
	}
	catch (Exception exception){
		exception.printStackTrace();
		   return false;
		}
	}
	
	/**
	 * @method: waitForElement
	 * @param: locator
	 * @author: Dishant
	 * @CreatedDate: 21-08-2018
	 */
	public static void waitForElement(int timeout) {
	     try {
	    	 TimeUnit.SECONDS.sleep(timeout);
	     } catch (Exception e) {
	         e.printStackTrace();
	         //System.out.println("print ur message here");
	     }
	 }
			
}

