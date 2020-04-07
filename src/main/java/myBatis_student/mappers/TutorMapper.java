package myBatis_student.mappers;

import java.util.Map;

import myBatis_student.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorByTutorId(Tutor tutor);
	
	int insertTutors(Map<String, Object> map);
	
	int deleteTutors(Map<String, Object> map);
	
	int insertTutor(Tutor tutor);
	int deleteTutor(int Id);
}
