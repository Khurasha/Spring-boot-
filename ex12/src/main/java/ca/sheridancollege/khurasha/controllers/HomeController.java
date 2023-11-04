package ca.sheridancollege.khurasha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

	@GetMapping("/")
    public String index() {
        return "index";}
	@GetMapping("/career")
	public String careers()
	{
		return "career";}
	@GetMapping("/hobbies")
	public String Hobbies()
	{
		return "hobbies";}
	@GetMapping("/others")
	public String others()
	{
		return "others";
	}
}


