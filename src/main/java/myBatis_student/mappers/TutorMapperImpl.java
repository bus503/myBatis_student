package myBatis_student.mappers;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import myBatis_student.dto.Tutor;

public class TutorMapperImpl implements TutorMapper {
	private static final TutorMapperImpl Instance = new TutorMapperImpl();

	private final String namespace = "myBatis_student.mappers.TutorMapper";
	private SqlSession sqlSession;
	
	public TutorMapperImpl() {}
	
	public static TutorMapperImpl getInstance() {
		return Instance;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Tutor selectTutorByTutorId(Tutor tutor) {
		return sqlSession.selectOne(namespace + ".selectTutorByTutorId", tutor);
	}

	@Override
	public int insertTutors(Map<String, Object> map) {
		int res = sqlSession.insert(namespace + ".insertTutors",map);
		sqlSession.commit();
		return res;
	}

	@Override
	public int deleteTutors(Map<String, Object> map) {
		int res = sqlSession.delete(namespace + ".deleteTutors" , map);
		return res;
	}

	@Override
	public int insertTutor(Tutor tutor) {
		int res = sqlSession.insert(namespace + ".insertTutor", tutor);
		return res;
	}

	@Override
	public int deleteTutor(int id) {
		int res = sqlSession.delete(namespace + ".deleteTutor", id);
		return res;
	}

}
