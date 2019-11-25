package matriculAPIController;

import java.io.File;
import java.util.stream.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import matriculAPI.model.Subject;

public class DataController {
	public ArrayList<Subject> listSubjectsInfo(String path) throws IOException {
		//preparing the archive
		//TODO make a webservice to the college site
		File excelFile = new File(path);
		FileInputStream fis = new FileInputStream(excelFile);
		
		//getting the first sheet of the archive
		XSSFWorkbook wk = new XSSFWorkbook(fis);
		XSSFSheet sheet = wk.getSheetAt(0);
		Iterator<Row> iteratorOfRow = sheet.iterator();
		
		ArrayList<Subject> spreadsheet = new ArrayList<Subject>();
		
		//building the rows and then building the cells inside of them
		while (iteratorOfRow.hasNext()) {
			Row row = iteratorOfRow.next();
			Iterator<Cell> iteratorOfCell = row.cellIterator();
			String rowString = "";
			while(iteratorOfCell.hasNext()) {
				Cell cell = iteratorOfCell.next();
				rowString += cell.toString()+"@";
			}
			spreadsheet.add(DataController.getSubjectModel(rowString));
		}
		wk.close();
		fis.close();
		return spreadsheet;
	}	
	
	public ArrayList<Subject> getBySubjectName(String subjectName, String path) throws IOException {
		DataController dc = new DataController();
		ArrayList<Subject> subjectList = dc.listSubjectsInfo(path);
		ArrayList<Subject> specificList = new ArrayList<Subject>();
		for (Subject row : subjectList) {
			if (row.getSubjectNameAndTurn().contains(subjectName)) specificList.add(row);
		}
		return specificList;
	}
	
	public static Subject getSubjectModel(String row) {
		Subject subject = new Subject();
		char[] stChar = row.toCharArray();
		String attribute = "";
		ArrayList<String> subString = new ArrayList<String>();
		for (int i = 0; i<stChar.length; i++) {
			if (stChar[i] != '@') attribute += stChar[i];
			else {
				if (attribute!="") subString.add(attribute);
				else subString.add("none");
				attribute = "";
			}
		}	
		subject.setCourseName(subString.get(0));
		subject.setCode(subString.get(1));
		subject.setSubjectNameAndTurn(subString.get(2));
		subject.setTheorySchedule(subString.get(3));
		subject.setPracticalSchedule(subString.get(4));
		subject.setTpi(subString.get(5));
		subject.setVacancies(subString.get(6));
		subject.setNewStudentReservedVacancies(subString.get(7));
		subject.setTheoryProfessor(subString.get(8));
		subject.setPracticalProfessor(subString.get(9));
		return subject;
	}
}
