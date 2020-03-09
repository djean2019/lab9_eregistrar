package edu.miu.cs.cs425.lab9.eregistrar.controller.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long studentId;
	@NotEmpty(message="*Student Id is requiered")
	private String studentNumber;
	@NotEmpty(message="*Student first name is requiered")
	private String firstName;
	private String middleName;
	@NotEmpty(message="*Student last name is requiered")
	private String lastName;
	private double cgpa;
	@NotEmpty(message="Valid date required")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate enrollmentDate;
	private boolean isInternational;
	
	public Student() {
		super();
	}

	public Student(long studentId,String studentNumber, String firstName, String middleName,String lastName, double cgpa,
			LocalDate enrollmentDate, boolean isInternational) {
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.enrollmentDate = enrollmentDate;
		this.isInternational=isInternational;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

    public boolean getIsInternational() {
		return isInternational;
	}
	public void setIsInternational(boolean isInternational) {
		this.isInternational = isInternational;
    }

	
}
