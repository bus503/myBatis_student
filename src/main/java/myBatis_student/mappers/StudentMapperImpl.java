package myBatis_student.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import myBatis_student.dto.Student;
import myBatis_student.jdbc.MyBatisSqlSessionFactory;

public class StudentMapperImpl implements StudentMapper {
	private String namespace = "myBatis_student.mappers.StudentMapper";
	private static final StudentMapperImpl Instance = new StudentMapperImpl();
	private SqlSession sqlSession;

	public StudentMapperImpl() {
	}

	public static StudentMapperImpl getInstance() {
		return Instance;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Student selectStudentByNo(Student student) {
		return sqlSession.selectOne(namespace + ".selectStudentByNo", student);
	}

	@Override
	public Student seleStudentByNoWithResultMap(Student student) {
		return sqlSession.selectOne(namespace + ".seleStudentByNoWithResultMap", student);
	}

	@Override
	public List<Student> selectStudentByAll() {
		return sqlSession.selectList(namespace + ".selectStudentByAll");
	}

	@Override
	public int insertStudent(Student student) {
		int res = sqlSession.insert(namespace + ".insertStudent", student);
		return res;
	}

	@Override
	public int insertStudentAutoInc(Student student) {
		int res = sqlSession.insert(namespace + ".insertStudent", student);
		return res;

	}

	@Override
	public int deleteStudent(int id) {
		int res = sqlSession.delete(namespace + ".deleteStudent", id);
		return res;

	}

	@Override
	public int updateStudent(Student student) {
		int res = sqlSession.update(namespace + ".updateStudent", student);
		return res;
	}

	@Override
	public List<Student> selectStudentByAllForResultMap() {

		return sqlSession.selectList(namespace + ".selectStudentByAllForResultMap");

	}

	@Override
	public List<Map<String, Object>> selectStudentByAllForHashMap() {

		return sqlSession.selectList(namespace + ".selectStudentByAllForHashMap");

	}

	@Override
	public Student selectStudentByNoAssociation(Student student) {

		return sqlSession.selectOne(namespace + ".selectStudentByNoAssociation", student);

	}

	@Override
	public int insertEnumStudent(Student student) {
	int res = sqlSession.insert(namespace + ".insertEnumStudent", student);
		return res;
	}

	@Override
	public Student selectAllStudentByMap(Map<String, String> map) {
		return sqlSession.selectOne(namespace + ".selectAllStudentByMap", map);

	}
	
	@Override
	public Map<Integer, Student> selectStudentForMap(int studId) {
		Map<Integer,Student> map = new HashMap<>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student);
			}
		};
		sqlSession.select(namespace +".selectStudentForMap",studId,resultHandler);
		return map;
	}
}
