package Module7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reading_Excel_Files {
	
	public FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String workBookPath = "C:\\ashish\\study material\\Selenium\\Module7\\TestData.xlsx";
	
	//POI API = http://poi.apache.org
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		createWorkSheet (workBookPath, "TestData");
		InsertRowValuesIntoSheet (1, "Bombay, Goa, Karnataka, Kochi, Ladakh, Kashmir");
		closeExcelSheet();
	}
	
	public static void createWorkSheet (String WorkBookPath, String SheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(workBookPath);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		XSSFSheet sheet = workbook.getSheet("TestData1");
		System.out.println("The sheet name - "+sheet.getSheetName() + " has been created");
	}
	
	public static void InsertRowValuesIntoSheet (int RowNumber, String RowValues)
	{
		String[] rowValues = RowValues.split(",");
		int arraySize = rowValues.length;
		Row row = sheet.createRow(RowNumber);
		for (int i = 1; i<arraySize; i++)
		{
			Cell cell = row.createCell(i);
			//cell.setCellType(cell.CELL_TYPE_STRING);
			cell.setCellValue(rowValues[i]);
		}
	}
	
	public static void closeExcelSheet () throws IOException
	{
		FileOutputStream FIS = new FileOutputStream (workBookPath);
		workbook.write(FIS);
		FIS.close();
		System.out.println("The operation is successful");
	}
} 
