package myBatis_student.mappers;

import java.util.List;

import myBatis_student.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student); //타입핸들러 사용
	Student seleStudentByNoWithResultMap(Student student); //사용하지않음
	List<Student> selectStudentByAll();
}
