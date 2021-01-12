package Module9_PageFactoryImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Module9.Selenium_WorkingWithDriver;

public class HeroKUAppChallengingDOM extends Selenium_WorkingWithDriver {
	
	//Initializing objects
	By oDOMTable = By.xpath("//div/h3[contains(text(),'Challenging DOM')]/following::table");
	By oDOMTableHeader = By.xpath("//div/h3[contains(text(),'Challenging DOM')]/following::table/thead/tr[1]/th");
	By oChallengingDOMLink = By.linkText("Challenging DOM");
	By oDOMLinkButton = By.xpath("//div[@class='large-2 columns']//ancestor::a");
	By oCanvasObject = By.xpath("//div[@class='large-2 columns']//following-sibling::div//following-sibling::div/div");
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		//Creating an object of class
		Selenium_WorkingWithDriver obDriver = new Selenium_WorkingWithDriver ();
		
		//Invoking URL in chrome browser
		obDriver.InvokeChrome(obDriver.sURL);
		
		//Creating an object of class
		HeroKUAppChallengingDOM obHeroKUAppChallengingDOM = new HeroKUAppChallengingDOM ();
		
		//Clicking on Challenging DOM Link
		obDriver.clickElementOnPage(obHeroKUAppChallengingDOM.oChallengingDOMLink);
		
		//Retrieving column size of the table and printing the same in console
		ArrayList <String> sTableHeadersArrayList = obHeroKUAppChallengingDOM.returnDataFromTable (obHeroKUAppChallengingDOM.oDOMTable, "th");
		System.out.println("Table headers array list is - "+sTableHeadersArrayList);
		
		//Retrieving column size of the table and printing the same in console
		ArrayList <String> sTableRowsArrayList = obHeroKUAppChallengingDOM.returnDataFromTable (obHeroKUAppChallengingDOM.oDOMTable, "tr");
		System.out.println("Table rows array list is - "+sTableRowsArrayList);
		
		//Retrieving column size of the table and printing the same in console
		ArrayList <String> sTableColsArrayList = obHeroKUAppChallengingDOM.returnDataFromTable (obHeroKUAppChallengingDOM.oDOMTable, "td");
		System.out.println("Table cols array list is - "+sTableColsArrayList);
		
		//Retrieving row data of a particular row and printing the same in console
		ArrayList <String> sTableRowArrayList = obHeroKUAppChallengingDOM.returnDataOfTableRow (obHeroKUAppChallengingDOM.oDOMTable, 4);
		System.out.println("Table cols array list is - "+sTableRowArrayList);
				
		String sCellData = obHeroKUAppChallengingDOM.returnDataFromTableCell(obHeroKUAppChallengingDOM.oDOMTable, 4, 5);
		System.out.println("Cell data of 4th row and 5th column is - "+sCellData);
		
		int[] arrayRowAndColumnNumber = obHeroKUAppChallengingDOM.returnRowAndColumnNumberFromTable(obHeroKUAppChallengingDOM.oDOMTable, "Adipisci3");
		System.out.println(arrayRowAndColumnNumber);
		
		//Clicking on delete link present in the same row and as the text "Consequuntur4"
		obHeroKUAppChallengingDOM.clickLinkInATable(obHeroKUAppChallengingDOM.oDOMTable, 4, 5, "Consequuntur4", "delete");
		
		//Retrieving the id and text of the elements present in the left navigation pane and printing the same in console
		HashMap<Integer, String> oDOMLinkButtonAttributeValues = new HashMap <Integer, String> ();
		oDOMLinkButtonAttributeValues = obHeroKUAppChallengingDOM.returnAttributesOfTheElementsBasedOnAncestor(obHeroKUAppChallengingDOM.oDOMLinkButton);
		System.out.println(oDOMLinkButtonAttributeValues);
		
		//Retrieving text from canvas but no success
//		driver = obDriver.getChromeDriver();
//		WebElement oCanvasObject = driver.findElement(obHeroKUAppChallengingDOM.oCanvasObject);
//		String sText = oCanvasObject.getText();
//		System.out.println("Canvas text is - "+sText);
	}
	
	public ArrayList <String> returnDataFromTable (By oTableName, String sTagName) {
		
		//Retrieving driver
		driver = getChromeDriver ();
		
		//Initializing Table
		WebElement oTable = driver.findElement(oTableName);
		
		//Returning all elements having tag name 'th' (column or table heading) in an array list
		List <WebElement> oCols = oTable.findElements(By.tagName(sTagName));
		
		//Retrieving the number of columns
		int oColumnSize = oCols.size();
		System.out.println("Size - "+oColumnSize);
		
		//Initializing array list
		ArrayList <String> sArrayList = new ArrayList <String> (oColumnSize);
		
		//Initializing counter integer as i
		int i = 1;
		
		//Iterating for each loop to retrieve the column header text and adding the same in array list
		for (WebElement oCol:oCols) {
			
			//Retrieving column heading text and printing the same in console
			String sTableText = oCol.getText();
			System.out.println("text in column " + i + " - "+sTableText);
			
			//Adding column heading in array list
			sArrayList.add(sTableText);
			
			//Iterating i to i+1
			i = i + 1;
			
		}
		
		//Returning array list through the method
		return sArrayList;
	}
	
	public ArrayList <String> returnDataOfTableRow (By oTableName, int iRowNumber) {
		
		//Retrieving driver
		driver = getChromeDriver ();
		
		//Initializing Table
		WebElement oTable = driver.findElement(oTableName);
		
		//Returning all elements having tag name 'th' (column or table heading) in an array list
		List <WebElement> oRows = oTable.findElements(By.xpath("//tbody/tr["+iRowNumber+"]"));
		
		//Retrieving the number of columns
		int oRowSize = oRows.size();
		System.out.println("Size - "+oRowSize);
		
		//Initializing array list
		ArrayList <String> sArrayList = new ArrayList <String> (oRowSize);
		
		//Iterating for each loop to retrieve the column header text and adding the same in array list
		for (WebElement oRow:oRows) {
			
			//Retrieving column heading text and printing the same in console
			String sRowText = oRow.getText();
			System.out.println("text is - "+sRowText);
			
			//Adding column heading in array list
			sArrayList.add(sRowText);
		}
		
		//Returning array list through the method
		return sArrayList;
	}
	
	public String returnDataFromTableCell (By oTableName, int iRowNumber, int iColumnNumber) {
		
		//Retrieving driver
		driver = getChromeDriver ();
		
		//Initializing Table
		WebElement oTable = driver.findElement(oTableName);
		
		//Returning element having 'tr' tag as iRowNumber and 'td' tag as iColumnNumber
		WebElement oCell = oTable.findElement(By.xpath("//tbody/tr["+iRowNumber+"]/td["+iColumnNumber+"]"));
		
		//Retrieving text of the cell
		String sCellData = oCell.getText();
		
		//Returning value through the method
		return sCellData;
	}
	
	public int[] returnRowAndColumnNumberFromTable (By oTableName, String sCellData) {
		
		//Retrieving driver
		driver = getChromeDriver ();
				
		//Initializing Table
		WebElement oTable = driver.findElement(oTableName);
		
		//Retrieving the row count of the table
		List <WebElement> oRows = oTable.findElements(By.tagName("tr"));
		int iRowCount = oRows.size();
		
		//Initializing iCounter to 1 and bFound to False
		int iRowCounter = 1;
		int iColumnCounter = 1;
		Boolean bFound = false;
		
		//Retrieving the text of the particular row
		for (WebElement oRow:oRows) {
			String sRowText = oRow.getText();
			System.out.println("The data contained in row - "+iRowCounter+ " is - "+sRowText);
			if (sRowText.contains(sCellData)) {
				System.out.println("entering bfound with iRowCounter -"+iRowCounter);
				bFound = true;
				break;
			}
			if (iRowCounter==iRowCount) {
				System.out.println("The text - "+sCellData+" is not present in the table");
			}
			iRowCounter = iRowCounter + 1;
		}
		
		//Returning column number from table cell containing data sCellData given as an argument
		if (bFound==true) {
			System.out.println("entering bfound column counter with iRowCounter -"+iRowCounter);
			List <WebElement> oColumnElements = oTable.findElements(By.xpath("//tbody/tr["+(iRowCounter-1)+"]/td"));
			
			//Iterating for each loop to retrieve the data of each and every column of a particular row
			for (WebElement oColumnElement:oColumnElements) {
				String sColumnElementText = oColumnElement.getText();
				System.out.println("The data contained in column - "+iColumnCounter+ " is - "+sColumnElementText);
				if (sCellData.equals(sColumnElementText)) {
					break;
				}
				iColumnCounter = iColumnCounter + 1;
			}
		}
		
		int[] iRowColumnCounters = new int [2];
		iRowColumnCounters[0] = iRowCounter;
		iRowColumnCounters[1] = iColumnCounter;
		
		System.out.println("cell data - " + sCellData + " is contained in row - "+iRowCounter+ " and column - "+iColumnCounter);
		return iRowColumnCounters;
		
	}
	
	public void clickLinkInATable (By oTableName, int iRowNumber, int iColumnNumber, String sCellText, String sLinkText) {
		
		//Retrieving driver
		driver = getChromeDriver ();
				
		//Initializing Table
		WebElement oTable = driver.findElement(oTableName);
		
		//Creating an object of class
		HeroKUAppChallengingDOM obHeroKUAppChallengingDOM = new HeroKUAppChallengingDOM ();
				
		int[] arrayRowAndColumnNumber = obHeroKUAppChallengingDOM.returnRowAndColumnNumberFromTable(oTableName, sCellText);
		iRowNumber = arrayRowAndColumnNumber[0];
		
		int[] arrayLinkTextRowAndColumnNumber = obHeroKUAppChallengingDOM.returnRowAndColumnNumberFromTable(oTableName, sLinkText);
		iColumnNumber = arrayLinkTextRowAndColumnNumber[1];
		
		WebElement oLink = oTable.findElement(By.xpath("//tbody/tr["+(iRowNumber-1)+"]/td[7]/a[contains(text(),'"+sLinkText+ "')]"));
		oLink.click();
		
	}
	
	public HashMap <Integer, String> returnAttributesOfTheElementsBasedOnAncestor (By oXPathObject) {
		
		List<WebElement> oDOMElements = driver.findElements(oXPathObject);
		int oDOMElementsSize = oDOMElements.size();
		System.out.println("Size of DOM link buttons is - " +oDOMElementsSize);
		
		HashMap <Integer, String> DOMAttributesMap = new HashMap <Integer, String> ();
		int iCounter = 1;
		for (int i = 0; i < oDOMElementsSize; i ++) {
			WebElement element = oDOMElements.get(i);
			String sID = element.getAttribute("id");
			String sText = element.getText();
			System.out.println("ID of element " + i + " is -" + sID + " and text is - " + sText);
			DOMAttributesMap.put(iCounter, sID);
			iCounter = iCounter + 1;
			DOMAttributesMap.put(iCounter, sText);
			iCounter = iCounter + 1;
		}
		return DOMAttributesMap;
	}

}
