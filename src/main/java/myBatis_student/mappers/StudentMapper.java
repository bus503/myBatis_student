package myBatis_student.mappers;

import java.util.List;
import java.util.Map;

import myBatis_student.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student); //타입핸들러 사용
	Student seleStudentByNoWithResultMap(Student student); //사용하지않음
	List<Student> selectStudentByAll();
	int insertStudent(Student student);
	int insertStudentAutoInc(Student student);
	int deleteStudent (int id);
	int updateStudent(Student student);
	
	//ResultMap
	List<Student> selectStudentByAllForResultMap();
	
	//hasMap
	List<Map<String,Object>> selectStudentByAllForHashMap();
	
	Student selectStudentByNoAssociation(Student student);
	
}
