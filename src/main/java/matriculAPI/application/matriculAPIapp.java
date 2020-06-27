package matriculAPI.application;

import java.io.IOException;
import java.util.ArrayList;

import matriculAPI.model.Command;
import matriculAPI.model.Subject;
import matriculAPI.matriculAPIController.*;

public class matriculAPIapp {
	public static void main (String args[]) throws IOException {
		
		DataController controll = new DataController();

		Command command = Command.getOption(args[0]);

		switch (command) {
			case all:
				ArrayList<Subject> subjectList = controll.listSubjectsInfo("matricula.xlsx");
				subjectList.forEach(sub -> System.out.println(sub));
				break;
			case subject:
				ArrayList<Subject> specificList = controll.getBySubjectName(args[1], "matricula.xlsx");
				specificList.forEach(s -> System.out.println(s));
				break;
		}

	}
}
