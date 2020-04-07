package myBatis_student.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import myBatis_student.dto.Course;
import myBatis_student.dto.CourseStat;
import myBatis_student.jdbc.AbstractTest;
import myBatis_student.jdbc.MyBatisSqlSessionFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest extends AbstractTest {
	private static CoursrMapperImpl dao;
	private static SqlSession sqlSession;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = CoursrMapperImpl.getInstance();
		sqlSession = MyBatisSqlSessionFactory.openSession(true);
		dao.setSqlSession(sqlSession);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
		sqlSession.close();
	}

	// @Test
	public void test01SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);

		List<Course> courses = dao.selectCoursesByCondition(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}
	}

	// @Test
	public void test02SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseName", "%Java%");

		List<Course> courses = dao.selectCoursesByCondition(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}
	}

	// @Test
	public void test03SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", cal.getTime());

		List<Course> courses = dao.selectCoursesByCondition(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}
	}

	// @Test
	public void test04SelectCaseCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);

		List<Course> courses = dao.selectCaseCourses(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}

		map.replace("searchBy", "CourseName");
		map.remove("tutorId");
		map.put("courseName", "%Java%");
		courses = dao.selectCaseCourses(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}
	}

	// @Test
	public void test05SelectWhereCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> courses = dao.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}

		map.put("tutorId", 1);
		courses = dao.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}

		map.put("courseName", "%Java%");
		courses = dao.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}

		map.clear();
		map.put("endDate", new Date());
		courses = dao.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}

	}

	//@Test
	public void test06SelectTrimCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> courses = dao.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}

		map.put("tutorId", 1);
		courses = dao.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}

		map.clear();
		map.put("courseName", "%java%");
		courses = dao.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}

		map.clear();
		map.put("tutorId", 1);
		courses = dao.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}

	}

	//@Test
	public void test07SelectCoursesForeachByTutors() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Integer> tutorIds = new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(2);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorIds", tutorIds);

		List<Course> courses = dao.selectCoursesForeachByTutors(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			log.trace(c.toString());
		}
	}
	

	@Test
	public void test08InsertCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Course> tutors = new ArrayList<Course>();
		tutors.add(new Course(4, "mysql", "database", new Date(), new Date(), 3));
		tutors.add(new Course(5, "mysql", "database", new Date(), new Date(), 3));
		tutors.add(new Course(6, "mariaDB", "database", new Date(), new Date(), 4));
		

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutors", tutors);

		
		int res = dao.insertCourses(map);
		Assert.assertEquals(3, res);
	}
	
	@Test
	public void test09DeleteCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Course> courseIds = new ArrayList<Course>();
		courseIds.add(new Course(4));
		courseIds.add(new Course(5));
		courseIds.add(new Course(6));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseIds",courseIds);

		int res = dao.deleteCourses(map);
		Assert.assertEquals(3, res);
	}
	
	@Test
	public void test10GetCourseCountByTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> param = new HashMap<>();
		param.put("tutor_id", 1);
		Map<String,Object> map = dao.getCourseCountByTutor(param);
		Assert.assertNotEquals(0, map.size());
		}
	
	@Test
	public void test11GetCourseCountByTutor2() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> param = new HashMap<>();
		param.put("tutor_id", 1);
		Map<String,Object> map = dao.getCourseCountByTutor2(param);
		Assert.assertNotEquals(0, map.size());
		}
	
	@Test
	public void test12GetCourseCountByTutor3() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CourseStat stat = dao.getCourseCountByTutor3(1);
		Assert.assertNotNull(stat);
		}
	
}
