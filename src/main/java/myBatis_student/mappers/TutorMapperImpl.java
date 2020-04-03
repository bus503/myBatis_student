package myBatis_student.mappers;

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

}
