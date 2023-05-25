package bail0;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import bail0.Constants;

public class Student extends Person {
	
	private String code;
	private String school;
	private int startDate;
	private double gpa;
	private Constants.STUDENT_GPA level;
	

	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Student(int id, String name, LocalDate dob, String address, double height, double weight,String code, String school, int startDate, double gpa) {
		super(id, name, dob, address, height, weight);
		
		this.code = code;
		this.school = school;
		this.startDate = startDate;
		this.gpa = gpa;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public double getGpa() {
		return this.gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public Constants.STUDENT_GPA getLevel() {
		return level;
	}
	public void setLevel(Constants.STUDENT_GPA level) {
		this.level = level;
	}

	public String toString(Integer index) {
		return "Student " + (index+1) + ": ["
				+ "id=" + getId() + ", name=" + getName() + ", dob=" + DateTimeFormatter.ofPattern("dd-MM-yyyy").format(getDob())
				+ ", address=" + getAddress() + ", height=" + getHeight() + ", weight=" + getWeight()
				+ ", code=" + code + ", school=" + school + ", startDate=" + startDate + ", gpa=" + gpa + ", level="+level
				+ "]";
	}


}
