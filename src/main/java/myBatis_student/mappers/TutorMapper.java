package myBatis_student.mappers;

import myBatis_student.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorByTutorId(Tutor tutor);
}
