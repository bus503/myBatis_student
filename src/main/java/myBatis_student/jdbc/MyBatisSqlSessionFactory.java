package myBatis_student.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
//세션을 만들어내는 공장 클래스다
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try(InputStream is = Resources.getResourceAsStream("mybatis-config.xml")){
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
	}
	
	public static SqlSession openSession(boolean is) {
		return sqlSessionFactory.openSession(is); //setAutoCommit(false)
	}
}
