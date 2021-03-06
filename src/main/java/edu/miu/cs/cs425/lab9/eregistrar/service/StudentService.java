package edu.miu.cs.cs425.lab9.eregistrar.service;

import java.util.List;

import edu.miu.cs.cs425.lab9.eregistrar.model.Student;


public interface StudentService {
	List<Student> getAllStudents();
//	public abstract Iterable<Student> getAllStudents();
	public abstract Student saveStudent(Student std);
	public abstract void deleteStudentById(long id);
	public abstract Student getStudentById(long studentId);
//	public abstract Student getStudentByName(String name);
	public abstract List<Student> findStudentByStudentNumber(String search);
}
