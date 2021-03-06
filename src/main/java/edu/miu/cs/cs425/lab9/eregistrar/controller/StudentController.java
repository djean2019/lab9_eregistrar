package edu.miu.cs.cs425.lab9.eregistrar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs.cs425.lab9.eregistrar.model.Search;
import edu.miu.cs.cs425.lab9.eregistrar.model.Student;
import edu.miu.cs.cs425.lab9.eregistrar.service.StudentService;

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
		List<Student> students = studentService.getAllStudents();
		modelAndView.addObject("student",students);
		modelAndView.addObject("search", new Search());
		modelAndView.setViewName("student/list");
		return modelAndView;
	}
	
	@GetMapping(value= {"/student/new"})
	public String addStudentsForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/new";
	}

    @PostMapping(value = {"/student/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().toString());
    		model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping(value = {"/student/edit"})
    public String editStudent(@RequestParam("studentId") long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = {"/student/edit"})
    public String editStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping(value = {"/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable long studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/student/list";
    }
    
    @PostMapping("/search")
    public String search(@ModelAttribute Search search, Model model) {
    	if(search.getSearch().isEmpty() || search.getSearch().isBlank())
    		model.addAttribute("student", studentService.getAllStudents());
    	else
    		model.addAttribute("student", studentService.findStudentByStudentNumber(search.getSearch()));
    	return "/student/list";
    }
	
}
