package Module9_TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class GetDataFromDataProvider {
	
//	public static void main (String[] args) {
//		GetDataFromDataProvider obGetDataFromDataProvider = new GetDataFromDataProvider ();
//		Object[][] arrayObject = obGetDataFromDataProvider.returnDataFromDataProvider
//			("C:\\ashish\\Training\\Selenium\\Web Driver\\SeleniumTraining_AshishThakur\\src\\Module9_TestNG\\DataDriver\\DataDriver_IFrame_TinyMCE_WYSIWYG_Editor.xlsx", "IFrames_WYSIWYGEditor");
//		 
//		for (int i = 0; i < arrayObject.length; i ++) {
//			for (int j = 0; j < arrayObject [i].length; j ++) {
//				System.out.println(arrayObject[i][j] + "	");
//			}
//		}
//	}

//	@DataProvider(name = "returnDataFromDataProvider")
	public Object[][] returnDataFromDataProvider (String sExcelPath, String sSheetName) {
		
		//Initializing runCellNumber and iCounter to 0
		int runCellNumber = 0;
		int iCounter = 0;
		int colSize = 0;
		
		//Initializing array
		Object[][] ArrayDataFromDataProvider = new Object[1][1];
		HashMap <Integer, String> hashMapDataProvider = new HashMap <Integer, String> ();
		
		try {
			
			//Initializing File object
			FileInputStream file = new FileInputStream (sExcelPath);
			try {
				
				//Initializing workbook and sheet objects
				@SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(sSheetName);
				
				//Retrieving the column number of Run
				Row row1 = sheet.getRow(0);
				int firstRowColSize = row1.getLastCellNum();
				for (int j = 0; j <= firstRowColSize - 1; j ++) {
					String firstRowCellValue = row1.getCell(j).getStringCellValue();
					if (firstRowCellValue.equals("Run")) {
						runCellNumber = j;
						break;
					}
				}
				
				//Iterating each row having run value as Y and adding them in the array
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					
					//Retrieving the run value and retrieving values in Array if run value is Y
					String runValue = row.getCell(runCellNumber).getStringCellValue();
					if (runValue.equalsIgnoreCase("y")) {
						
						//Incrementing iCounter if the run case is Y
						iCounter = iCounter + 1;
						
						//Retrieving all the values of row separated by ",:" if the Run value is Y
						colSize = row.getLastCellNum();
						String value = "";
						for (int i = 0; i <= colSize - 1; i ++) {
							String value1 = row.getCell(i).getStringCellValue();
							value = value + ",:" + value1;
							if (i == 0) {
								value = value.replace(",:", "");
							}
						}
						
						//Putting value in hashmap
						hashMapDataProvider.put(iCounter, value);
						
					}
				}
				
				//Retrieving rowsize of array
				int iRowCounter = hashMapDataProvider.size();
						
				//Putting values into 2 dimensional array
				ArrayDataFromDataProvider = new String[iRowCounter][colSize];
				
				//Incrementing for loop to put values from hashmap into array
				for (int i = 0; i < iRowCounter; i++) {
					
					//Putting value of 1st dimension as index number
					ArrayDataFromDataProvider [i][0] = String.valueOf(i);
					
					//Retrieving value of hashmap and and splitting value of hashmap by ",:"
					String hashMapValue = hashMapDataProvider.get(i+1);
					String[] arrHashMapValue = hashMapValue.split(",:");
										
					//Iterating by columns to put splitted values of hashmap into column number of array
					for (int j = 0; j < colSize; j++) {
						ArrayDataFromDataProvider [i][j] = arrHashMapValue [j];
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Sheet is not found at - "+sSheetName);
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found at - "+sExcelPath);
			e.printStackTrace();
		}
		
		//
		return ArrayDataFromDataProvider;
		
	}

}
