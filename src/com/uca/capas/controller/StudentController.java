package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.uca.capas.domain.Student;
import com.uca.capas.service.StudentService;

@Controller
public class StudentController {
	private final static Logger log = Logger.getLogger(StudentController.class.getSimpleName());	

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public ModelAndView initMain(ModelMap model) {
		ModelAndView mav = new ModelAndView("main", model);
		mav.getModelMap().mergeAttributes(model);
		List<Student> students = null;
		try {
			students = studentService.getStudentList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("students", students);
		return mav;
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public ModelAndView searchStudent(@RequestParam(name = "studentId") Integer code) {
		ModelAndView mav = new ModelAndView();
		Student student = null;
		try {
			student = studentService.getStudentById(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (student != null) {
			mav.addObject("student", student);
		} else {
			mav.addObject("noResult", "No student was found with that ID");
		}
		mav.setViewName("show");
		return mav;
	}
	
	@GetMapping("/add-student")
	public ModelAndView editStudentInfo() {
		ModelAndView mav = new ModelAndView();
		Student student = new Student();
		mav.addObject("student", student);
		mav.addObject("action", "Add");
		mav.setViewName("student-info");
		return mav;
	}
	
	@GetMapping("/edit-student/{id}")
	public String editStudentInfo(@PathVariable("id") Integer code, Model m) {
		try {
			Student student = studentService.getStudentById(code);
			m.addAttribute("action", "Edit");
			m.addAttribute("student", student);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return "student-info";
	}
	
	@GetMapping("/delete-student/{id}")
	public RedirectView deleteStudent(@PathVariable("id") Integer code, HttpServletRequest req, RedirectAttributes ra) {
		RedirectView rv = new RedirectView(req.getContextPath());
		rv.setExposeModelAttributes(false);
		try {
			Student student = studentService.getStudentById(code);
			studentService.deleteStudent(student);
			ra.addFlashAttribute("success", true);
			ra.addFlashAttribute("message", "Student was removed successfully");			
		} catch (Exception e) {
			log.severe(e.toString());
			ra.addFlashAttribute("success", false);
			ra.addFlashAttribute("message", "Student could not be deleted");
		}
		return rv;
	}
	
	@RequestMapping(path = "/saveStudent", method = RequestMethod.POST)
	public RedirectView saveStudent(@ModelAttribute Student student, HttpServletRequest req, RedirectAttributes ra) {
		RedirectView rv = new RedirectView(req.getContextPath());
		rv.setExposeModelAttributes(false);
		try {
			studentService.saveStudent(student);
			ra.addFlashAttribute("success", true);
			ra.addFlashAttribute("message", "Student information saved successfully");
		} catch (DataAccessException e) {
			ra.addFlashAttribute("success", false);
			ra.addFlashAttribute("message", "There was a problem saving the student information");
		}
		return rv;
	}
}
