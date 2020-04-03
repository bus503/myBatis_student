package myBatis_student.mappers;

import org.apache.ibatis.session.SqlSession;

import myBatis_student.dto.UserPic;

public class UserPicMapperImpl implements UserPicMapper {
	public static final UserPicMapperImpl instance = new UserPicMapperImpl();
	
	private final String namespace = "myBatis_student.mappers.UserPicMapper";
	private SqlSession sqlSession;
	
	public UserPicMapperImpl() {}
	
	public static UserPicMapperImpl getInstance() {
		return instance;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertUserPic(UserPic userPic) {
		return sqlSession.insert(namespace + ".insertUserPic",userPic);
	}

	@Override
	public UserPic getUserPic(int id) {
		return sqlSession.selectOne(namespace +".getUserPic", id);
	}
}
