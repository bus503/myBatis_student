package myBatis_student.mappers;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.Assert;
import myBatis_student.dto.Student;
import myBatis_student.jdbc.AbstractTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest{
	private static StudentMapper dao;
	//private static final Log log = LogFactory.getLog(MyBatisSqlSessionFactoryTest.class);


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = StudentMapperImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao =null;
	}

	@Test
	public void test01SelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student seleStudent = dao.selectStudentByNo(student);
		log.debug(seleStudent.toString());
		Assert.assertEquals(student.getStudId(), seleStudent.getStudId());
	}
	
	@Test
	public void test02seleStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student seleStudent = dao.seleStudentByNoWithResultMap(student);
		log.debug(seleStudent.toString());
		Assert.assertEquals(student.getStudId(), seleStudent.getStudId());
	}
	
	@Test
	public void test03seleStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Student> lists = dao.selectStudentByAll();
		Assert.assertNotNull(lists);
//		for(Student std :lists) {
//			log.debug(std.toString());
//		}
	}
}
