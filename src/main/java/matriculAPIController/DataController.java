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
			String rowString = "";
			while(iteratorOfCell.hasNext()) {
				Cell cell = iteratorOfCell.next();
				rowString += cell.toString()+"|";
			}
			spreadsheet.add(rowString);
		}
		wk.close();
		fis.close();
		return spreadsheet;
	}	
	
	public ArrayList<String> getBySubjectName(String subjectName, String path) throws IOException {
		DataController dc = new DataController();
		ArrayList<String> subjectList = dc.listSubjectsInfo(path);
		ArrayList<String> specificList = new ArrayList<String>();
		for (String row : subjectList) {
			if (row.contains(subjectName)) specificList.add(row);
		}
		return specificList;
	}
}
