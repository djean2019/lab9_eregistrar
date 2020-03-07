package edu.miu.cs.cs425.lab9.eregistrar.controller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.lab9.eregistrar.controller.model.Student;
import edu.miu.cs.cs425.lab9.eregistrar.controller.repository.StudentRepository;
import edu.miu.cs.cs425.lab9.eregistrar.controller.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl() {}
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

}
