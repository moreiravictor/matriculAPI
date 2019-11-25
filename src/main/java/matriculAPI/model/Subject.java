package matriculAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Subject {
	private String courseName;
	private String code;
	private String subjectNameAndTurn;
	private String theorySchedule;
	private String practicalSchedule;
	private String tpi;
	private String vacancies;
	private String newStudentReservedVacancies;
	private String theoryProfessor;
	private String practicalProfessor;
}
