package com.klef.jfsd.sdp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.sdp.model.Admin;
import com.klef.jfsd.sdp.model.Faculty;
import com.klef.jfsd.sdp.model.Student;
import com.klef.jfsd.sdp.service.FacultyService;

@Controller
public class FacultyController 
{
    @Autowired
    private FacultyService facultyService;
    
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }
    
    @GetMapping("/facreg")
    public ModelAndView facreg() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("facreg");  // The JSP file for the faculty registration form
        return mv;
    }
    
    @PostMapping("/insertfaculty")
    public ModelAndView insertFaculty(HttpServletRequest request) {
        // Retrieve form data
        String name = request.getParameter("fname");
        String password = request.getParameter("fpwd");
        String email = request.getParameter("femail");
        String department = request.getParameter("fdept");
        String contactno = request.getParameter("fcontact");
        String location = request.getParameter("flocation");
        String status = "Registered";
        
        // Create Faculty object
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setPassword(password);
        faculty.setEmail(email);
        faculty.setDepartment(department);
        faculty.setContactno(contactno);
        faculty.setLocation(location);
        faculty.setStatus(status);
        
        // Call the service to register the faculty
        String msg = facultyService.FacultyRegistration(faculty);
        
        // Create ModelAndView for success page
        ModelAndView mv = new ModelAndView("regsuccess"); // Change to your success page JSP
        mv.addObject("message", msg); // Pass the registration message to the view
        
        return mv;
    }
    
    
    @GetMapping("faclogin")
	public ModelAndView faclogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("faclogin");
		return mv;
	}
    
    @GetMapping("faclogout")
	public ModelAndView faclogout() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("faclogin");
		return mv;
	}
    
    @GetMapping("fachome")
	public ModelAndView fachome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fachome");
		return mv;
	}
    
    
    @PostMapping("checkfaclogin")
    public ModelAndView checkfaclogin(HttpServletRequest request) 
    {
        ModelAndView mv = new ModelAndView();
        String femail = request.getParameter("femail");
        String fpwd = request.getParameter("fpwd");
        
        Faculty faculty = facultyService.checkfaclogin(femail, fpwd);
        
        if(faculty != null) {
            HttpSession session = request.getSession(true); // Create session if none exists
            session.setAttribute("faculty", faculty); // Store faculty object in session
            mv.setViewName("fachome"); // Redirect to faculty home page
        } else {
            mv.setViewName("facloginfail"); // Redirect to login failure page
            mv.addObject("message", "Login Failed");
        }
        
        return mv;
    }

    
    @GetMapping("facsessionfail")
    public ModelAndView facsessionfail() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("facsessionfail"); // Redirect to a session fail page
        return mv;
    }

    
    @GetMapping("updatefac")
	  public ModelAndView updatefac()
	  {
		  ModelAndView mv=new ModelAndView();
		  mv.setViewName("updatefac");
		  return mv;
	  }
    
    
        
    @PostMapping("updatefaculty")
    public ModelAndView updateFaculty(HttpServletRequest request)
    {
        // Retrieve parameters from the request
        int id = Integer.parseInt(request.getParameter("fid"));
        String name = request.getParameter("fname");
        String password = request.getParameter("fpwd");
        String department = request.getParameter("fdept");
        String contact = request.getParameter("fcontact");
        String location = request.getParameter("flocation");

        // Create a new Faculty object and set its attributes
        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setPassword(password);
        faculty.setDepartment(department);
        faculty.setContactno(contact);
        faculty.setLocation(location);

        // Call the service to update the faculty
        String msg = facultyService.updateFaculty(faculty);

        // Prepare the response
        ModelAndView mv = new ModelAndView("updatesuccess"); // "updatesuccess" is the JSP page that displays success message
        mv.addObject("message", msg); // Add the update result message (success/failure)
        
        return mv;
    }


    
    
    @GetMapping("facprofile")
    public ModelAndView facprofile() 
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("facprofile");
        return mv;
    }
    
    
    
    @GetMapping("/facaddstu")
    public ModelAndView studentreg() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("facaddstu");  // The JSP file for the faculty registration form
        return mv;
    }
	
    @PostMapping("/facinsertstu")
    public ModelAndView insertStudent(HttpServletRequest request) {
        // Retrieve form data
        String name = request.getParameter("fname");
        String password = request.getParameter("fpwd");
        String email = request.getParameter("femail");
        String department = request.getParameter("fdept");
        String contactno = request.getParameter("fcontact");
        String gender = request.getParameter("fgender");
        String dob = request.getParameter("fdob");
        
        // Create Student object
        Student student = new Student();
        student.setName(name);
        student.setPassword(password);
        student.setEmail(email);
        student.setDepartment(department);
        student.setContactno(contactno);
        student.setGender(gender);
        student.setDob(dob);
        student.setEventsRegistered(""); // Default value for eventsRegistered
        
        // Call the service to register the student
        String msg = facultyService.addStudent(student);
        
        // Return to the same registration page with a success message
        ModelAndView mv = new ModelAndView("facaddstu");
        mv.addObject("successMessage", msg);
        
        return mv;
    }
    
    
    
    @GetMapping("facviewallstu")
	public ModelAndView viewAllStudents() {
	    ModelAndView mv = new ModelAndView();
	    
	    // Get the total student count from the service
	    long scount = facultyService.studentCount();
		mv.addObject("scount",scount);
	    
	    // Get the list of all students from the service
	    List<Student> studentList = facultyService.viewAllStudents();
	    
	    // Set the view name and add the student list to the ModelAndView object
	    mv.setViewName("facviewallstu");
	    mv.addObject("studentList", studentList);
	    
	    return mv;
	}
    
    
    @GetMapping("facdelstu")
	  public ModelAndView deletestudent() 
	  {
	    ModelAndView mv = new ModelAndView();
	    
	    List<Student> studentList = facultyService.viewAllStudents();
	    mv.setViewName("facdelstu");
	    mv.addObject("studentList", studentList);
	    return mv;
	  }
	
	@GetMapping("facdeletestu")
	   public String deletestudent(@RequestParam("id")  int student_id)
	   {
		   facultyService.deleteStudent(student_id);
		   return "redirect:/facdelstu";
	   }


	

}
