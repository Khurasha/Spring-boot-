package ca.sheridancollege.khurasha.controller;
import ca.sheridancollege.khurasha.beans.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import ca.sheridancollege.khurasha.database.*;

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
	model.addAttribute("student" , new Student());
	da.insertStudentHardCoded();
	return "index";
    }	

	@PostMapping("/insertstudent")
	public String insertstudent(Model model, @ModelAttribute Student student)
	{
	  studentlist.add(student);
	  model.addAttribute("student",new Student());
      return "index";
	}
}
