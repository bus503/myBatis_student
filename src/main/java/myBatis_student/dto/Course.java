package myBatis_student.dto;

import java.util.Date;

public class Course {
	private int courseId;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private int tutorId;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	
	
	public Course(int courseId, String name, String description, Date startDate, Date endDate, int tutorId) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tutorId = tutorId;
	}
	

	public Course(int courseId) {
		super();
		this.courseId = courseId;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + ", tutorId=" + tutorId + "]";
	}
	
	
}
