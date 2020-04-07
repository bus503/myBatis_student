package myBatis_student.jdbc;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;


public class MyBatisSqlSessionFactoryTest {
	private static final Log log = LogFactory.getLog(MyBatisSqlSessionFactoryTest.class);
	@Test
	public void testOpenSession() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		log.debug("session" + session);
		Assert.assertNotNull(session);
		session.close(); //반드시 close해줘야한다
	}
}
