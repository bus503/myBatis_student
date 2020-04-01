package myBatis_student.mappers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myBatis_student.dto.Student;
import myBatis_student.jdbc.MyBatisSqlSessionFactory;

public class StudentMapperImpl implements StudentMapper {
	private String namespace = "myBatis_student.mappers.StudentMapper";
	private static final StudentMapperImpl Instance = new StudentMapperImpl();
	private SqlSession sqlSession;
	
	public StudentMapperImpl() {
		this.sqlSession = MyBatisSqlSessionFactory.openSession();
	}

	public static StudentMapperImpl getInstance() {
		return Instance;
	}

	@Override
	public Student selectStudentByNo(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectStudentByNo", student);
		}
	}

	@Override
	public Student seleStudentByNoWithResultMap(Student student) {
		return sqlSession.selectOne(namespace + ".seleStudentByNoWithResultMap", student);
	}

	@Override
	public List<Student> selectStudentByAll() {
		return sqlSession.selectList(namespace + ".selectStudentByAll");
	}
}
