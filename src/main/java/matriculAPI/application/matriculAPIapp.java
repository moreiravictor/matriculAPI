package matriculAPI.application;

import java.io.IOException;
import java.util.ArrayList;

import matriculAPIController.*; 
public class matriculAPIapp {
	public static void main (String args[]) throws IOException {
		
		DataController controll = new DataController();
		ArrayList<String> subjectList = controll.listSubjectsInfo("matricula.xlsx");
		for (String s : subjectList) {
			System.out.println(s);
		}
		System.out.println("=================================================================");
		ArrayList<String> specificList = controll.getBySubjectName("Projeto Dirigido", "matricula.xlsx");
		for (String s : specificList) {
			System.out.println(s);
		}
	}
}
