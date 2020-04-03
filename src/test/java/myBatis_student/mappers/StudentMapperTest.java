package myBatis_student.mappers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import myBatis_student.dto.Gender;
import myBatis_student.dto.PhoneNumber;
import myBatis_student.dto.Student;
import myBatis_student.jdbc.AbstractTest;
import myBatis_student.jdbc.MyBatisSqlSessionFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest{
	private static StudentMapperImpl dao;
	private static SqlSession sqlSession;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = StudentMapperImpl.getInstance();
		sqlSession = MyBatisSqlSessionFactory.openSession();
		dao.setSqlSession(sqlSession);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao =null;
		sqlSession.close();
	}

	//@Test
	public void test01SelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student seleStudent = dao.selectStudentByNo(student);
		log.debug(seleStudent.toString());
		Assert.assertEquals(student.getStudId(), seleStudent.getStudId());
	}
	
	//@Test
	public void test02seleStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student seleStudent = dao.seleStudentByNoWithResultMap(student);
		log.debug(seleStudent.toString());
		Assert.assertEquals(student.getStudId(), seleStudent.getStudId());
	}
	
	//@Test
	public void test03seleStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Student> lists = dao.selectStudentByAll();
		Assert.assertNotNull(lists);
		for(Student std :lists) {
			log.debug(std.toString());
		}
	}
	
	//@Test
	public void test04InsertStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1991,12,18);

		Student student = new Student();
		student.setStudId(3);
		student.setName("황태원");
		student.setEmail("test@test.com");
		student.setPhone(new PhoneNumber("010-4245-3825"));
		student.setDob(newDate.getTime());
		int res = dao.insertStudent(student);
		Assert.assertEquals(1, res);
	}
	
	//@Test
	public void test05InsertStudentAutoInc() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990,11,18);

		Student student = new Student();
		student.setName("황태원1");
		student.setEmail("test@test.com");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-4245-3825"));
		
		int res = dao.insertStudentAutoInc(student);
		Assert.assertEquals(1, res);
	}
	
	//@Test
	public void test06DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int deleteStudent = dao.deleteStudent(3);
		Assert.assertSame(1, deleteStudent);
	}
	
	//@Test
	public void test07UpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		student.setName("황태원");
		student.setEmail("bus503@daum.net");
		student.setPhone(new PhoneNumber("010-4245-3825"));
		student.setDob(new Date());
		
		int result = dao.updateStudent(student);
		Assert.assertSame(1, result);
		
		student.setEmail("Timothy");
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setDob(new GregorianCalendar(1988, 9, 16).getTime());
		
		result = dao.updateStudent(student);
		Assert.assertSame(1, result);	
	}
	
	
	//@Test
	public void test08SelectStudentByAllForResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Student> lists = dao.selectStudentByAllForResultMap();
		Assert.assertNotNull(lists);
		for(Student std :lists) {
			log.debug(std.toString());
		}
	}
	
	//@Test
	public void test09selectStudentByAllForHashMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Map<String, Object>> lists = dao.selectStudentByAllForHashMap();
		Assert.assertNotNull(lists);
		for(Map<String, Object> map :lists) {
			for(Entry<String,Object> e : map.entrySet()) {
				log.debug(String.format("%s -> %s", e.getKey() ,e.getValue()));

			}
		}
	}
	
	//@Test
	public void test10selectStudentByNoAssociation() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectedStd = dao.selectStudentByNoAssociation(student);
		Assert.assertNotNull(selectedStd);
		log.debug(selectedStd.toString());
	}
	
	//@Test
	public void test11InsertEnumStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student student = new Student();
		student.setStudId(4);
		student.setName("test");
		student.setEmail("bus503@daum.net");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-4245-3825"));
		student.setGender(Gender.FEMALE);
		int res = dao.insertEnumStudent(student);
		Assert.assertEquals(1, res);
		
		
		student.setStudId(5);
		student.setName("황태원");
		student.setEmail("bus503@daum.net");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-4245-3825"));
		student.setGender(Gender.MALE);
		int res1 = dao.insertEnumStudent(student);
		Assert.assertEquals(1, res1);	
	}
	
	//@Test
	public void test12selectAllStudentByMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String,String> maps = new HashMap<>();
		maps.put("name","황태원");
		maps.put("email","Timothy");
		Student student = dao.selectAllStudentByMap(maps);
		Assert.assertNotNull(student);
		log.debug(student.toString());
		
		maps.remove("email");
		student = dao.selectAllStudentByMap(maps);
		log.debug(student.toString());
		
		maps.clear();
		maps.put("email","Timothy");
		student = dao.selectAllStudentByMap(maps);
		log.debug(student.toString());
		
	}
	
	@Test
	public void test13selectStudentForMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<Integer,Student> map =dao.selectStudentForMap(1);
		Assert.assertNotNull(map);
		
		for(Entry<Integer,Student>entry : map.entrySet()) {
			System.out.printf("key(%s) - valuse(%s)%n", entry.getKey(),entry.getValue());
		}
	}
}
