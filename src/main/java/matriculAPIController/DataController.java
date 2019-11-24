package matriculAPIController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataController {
	public ArrayList<String> listSubjectsInfo(String path) throws IOException {
		//preparing the archive
		//TODO make a webservice to the college site
		File excelFile = new File(path);
		FileInputStream fis = new FileInputStream(excelFile);
		
		//getting the first sheet of the archive
		XSSFWorkbook wk = new XSSFWorkbook(fis);
		XSSFSheet sheet = wk.getSheetAt(0);
		Iterator<Row> iteratorOfRow = sheet.iterator();
		
		ArrayList<String> spreadsheet = new ArrayList<String>();
		
		//building the rows and then building the cells inside of them
		while (iteratorOfRow.hasNext()) {
			Row row = iteratorOfRow.next();
			Iterator<Cell> iteratorOfCell = row.cellIterator();
			String cellString = "";
			while(iteratorOfCell.hasNext()) {
				Cell cell = iteratorOfCell.next();
				cellString += cell.toString()+"|";
			}
			spreadsheet.add(cellString);
		}
		wk.close();
		fis.close();
		return spreadsheet;
	}	
}
