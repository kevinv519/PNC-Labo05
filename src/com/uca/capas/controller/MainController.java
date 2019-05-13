package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;

@Controller
public class MainController {

	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		Student student = null;
		try {
			student = studentDAO.findOne(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("student", student);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ModelAndView searchStudent(@RequestParam(name = "studentId") Integer code) {
		ModelAndView mav = new ModelAndView();
		Student student = null;
		try {
			student = studentDAO.findOne(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (student != null) {
			System.out.println(student.toString());
			mav.addObject("student", student);
		} else {
			mav.addObject("noResult", "No student was found with that ID");
		}
		mav.setViewName("main");
		return mav;
	}
}
