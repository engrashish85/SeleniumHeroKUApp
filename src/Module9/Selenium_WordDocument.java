package Module9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Selenium_WordDocument {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		
//		XWPFDocument obXWPFDocument = new XWPFDocument ();
//		XWPFParagraph obXWPFParagraph = obXWPFDocument.createParagraph();
//		XWPFRun obXWPFRun = obXWPFParagraph.createRun();
//		obXWPFRun.setText("This is my first test word document file");
//		obXWPFRun.setFontSize(14);
//		InputStream obInputStreamPic = new FileInputStream ("C:\\ashish\\Images\\05072012001.jpg");
//		try {
//			for (int i = 1; i <= 2; i++) {
//				obInputStreamPic = new FileInputStream ("C:\\ashish\\Images\\" +i+".png");
//				obXWPFRun.addPicture(obInputStreamPic, Document.PICTURE_TYPE_PNG, "3", 5, 5);
//			}
//			FileOutputStream obFileOutputStream = new FileOutputStream ("C:\\ashish\\Images\\SeleniumTest.doc");
//			obXWPFDocument.write(obFileOutputStream);
//			
//			obFileOutputStream.close();
//			obInputStreamPic.close();
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		
//	}
		
		
	}
	
	public void createWordDocument (String testCaseName, String imgFileNames) {
		
		
		
	}
}
