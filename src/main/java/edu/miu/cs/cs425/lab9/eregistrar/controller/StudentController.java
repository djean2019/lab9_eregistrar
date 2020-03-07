package edu.miu.cs.cs425.lab9.eregistrar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs.cs425.lab9.eregistrar.controller.model.Student;
import edu.miu.cs.cs425.lab9.eregistrar.controller.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping(value="/student/list")
	public ModelAndView listStudents() {
		ModelAndView modelAndView = new ModelAndView();
		List<Student> students = studentService.getStudents();
		modelAndView.addObject("students",students);
		modelAndView.addObject("studentCount",students.size());
		modelAndView.setViewName("student/list");
		return modelAndView;
	}
}
