package ca.sheridancollege.shabd.khurana.controller;

import ca.sheridancollege.shabd.khurana.beans.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/register")
    public String register (
    	
                @RequestParam String firstName,
                @RequestParam String lastName,
                @RequestParam String gender,
                @RequestParam String email,
                @RequestParam String schoolName,
                @RequestParam String course,
                Model model)
    	{
    		model.addAttribute("firstName", firstName);
            model.addAttribute("lastName", lastName);
            model.addAttribute("gender", gender);
            model.addAttribute("email", email);
            model.addAttribute("schoolName", schoolName);
            model.addAttribute("course", course);
    	
        return "success";
    }
}

