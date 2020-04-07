package myBatis_student.dto;

public class CourseStat {
	private String tutor;
	private int total;
	
	
	public String getTutor() {
		return tutor;
	}


	public void setTutor(String tutor) {
		this.tutor = tutor;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public CourseStat(String tutor, int total) {
		super();
		this.tutor = tutor;
		this.total = total;
	}


	@Override
	public String toString() {
		return "CourseStat [tutor=" + tutor + ", total=" + total + "]";
	}
	
	
}
