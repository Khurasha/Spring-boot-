package ca.sheridancollege.khurasha.controller;
import ca.sheridancollege.khurasha.beans.*;
import ca.sheridancollege.khurasha.database.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Studentcontroller {
	 List<Student> studentlist = new CopyOnWriteArrayList<Student>();
	 @Autowired
	 private Dataaccess da;
	 
	
	@GetMapping("/")
	public String index (Model model)
	{
    model.addAttribute("studentList" , da.getStudentList());
	model.addAttribute("student" , new Student());
	return "index";
    }	
	@PostMapping("/insertStudent")
	public String insertStudent(Model model, @ModelAttribute Student student) {
	da.insertStudent(student);
	model.addAttribute("studentList" , da.getStudentList());
	model.addAttribute("student", new Student());
	return "index";
	}

}
