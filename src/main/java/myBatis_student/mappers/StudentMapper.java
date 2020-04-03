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
	
	//일대일 관계
	Student selectStudentByNoAssociation(Student student);
	
	
	
	//Enum
	int insertEnumStudent(Student student);
	
	//여러 개의 입력 파라미터 전달
	Student selectAllStudentByMap(Map<String,String> map);
	
	//Result 처리방식의 재정의
	Map<Integer, Student> selectStudentForMap(int studId);
	
}
