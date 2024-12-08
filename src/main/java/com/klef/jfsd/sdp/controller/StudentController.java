package com.klef.jfsd.sdp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.sdp.model.Events;
import com.klef.jfsd.sdp.model.Student;

import com.klef.jfsd.sdp.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class StudentController {
	
	
	@Autowired
    private StudentService studentService;
	
	
	@GetMapping("studentlogin")
	public ModelAndView studentlogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studentlogin");
		return mv;
	}
	
	@GetMapping("studentlogout")
	public ModelAndView studentlogout() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studentlogin");
		return mv;
	}
	
	@GetMapping("studenthome")
	public ModelAndView studenthome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studenthome");
		return mv;
	}
	
	@PostMapping("checkstudentlogin")
	public ModelAndView checkstudentlogin(HttpServletRequest request) 
	{
	    ModelAndView mv = new ModelAndView();
	    String email = request.getParameter("email");  // Use correct parameter names from the form
	    String password = request.getParameter("password");
	    
	    // Assuming StudentService has a method to check login similar to FacultyService
	    Student student = studentService.checkstudentlogin(email, password);
	    
	    if(student != null) 
	    {
	        mv.setViewName("studenthome");  // Redirects to student home if login is successful
	    }
	    else 
	    {
	        mv.setViewName("studentloginfail");
	        mv.addObject("message", "Login Failed");
	    }
	    
	    return mv;
	}
	
	
	
	@GetMapping("stuviewallevents")
	public ModelAndView viewAllEvents() {
	    ModelAndView mv = new ModelAndView();
	    
	    // Get the total event count from the service
	    
	    
	    // Get the list of all events from the service
	    List<Events> eventList = studentService.viewAllEvents();
	    
	    // Set the view name and add the event list to the ModelAndView object
	    mv.setViewName("stuviewallevents");
	    mv.addObject("eventList", eventList);
	    
	    return mv;
	}
	
	
	
	
	
	
	


}
