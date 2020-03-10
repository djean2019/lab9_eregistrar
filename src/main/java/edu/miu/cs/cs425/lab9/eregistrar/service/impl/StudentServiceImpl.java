package edu.miu.cs.cs425.lab9.eregistrar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.lab9.eregistrar.model.Student;
import edu.miu.cs.cs425.lab9.eregistrar.repository.StudentRepository;
import edu.miu.cs.cs425.lab9.eregistrar.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl() {}
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public  List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student std) {
		return studentRepository.save(std);
	}

	@Override
	public void deleteStudentById(long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student getStudentById(long studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public List<Student> findStudentByStudentNumber(String search) {
		return studentRepository.findStudentByStudentNumber(search);
	}
	
}
