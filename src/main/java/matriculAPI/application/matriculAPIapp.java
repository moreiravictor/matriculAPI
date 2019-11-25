package matriculAPI.application;

import java.io.IOException;
import java.util.ArrayList;

import matriculAPI.model.Subject;
import matriculAPIController.*; 
public class matriculAPIapp {
	public static void main (String args[]) throws IOException {
		
		DataController controll = new DataController();
		ArrayList<Subject> subjectList = controll.listSubjectsInfo("matricula.xlsx");
		for (Subject s : subjectList) {
			System.out.println(s);
		}
		System.out.println("=================================================================");
		ArrayList<Subject> specificList = controll.getBySubjectName("Projeto Dirigido", "matricula.xlsx");
		for (Subject s : specificList) {
			System.out.println(s);
		}
	}
}
