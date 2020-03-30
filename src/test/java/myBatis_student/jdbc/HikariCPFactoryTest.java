package myBatis_student.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;


public class HikariCPFactoryTest {
	private static final Log log = LogFactory.getLog(HikariCPFactoryTest.class);

	@Test
	public void testGetDataSource() {
		HikariCPFactory factory = new HikariCPFactory();
		DataSource dataSource = factory.getDataSource();
		Assert.assertNotNull(dataSource);
		log.trace(dataSource.toString());
		
		try {
			Connection con = dataSource.getConnection();
			log.trace(con.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
