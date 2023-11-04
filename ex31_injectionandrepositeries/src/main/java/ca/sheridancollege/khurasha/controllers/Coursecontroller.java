package ca.sheridancollege.khurasha.controllers;

import ca.sheridancollege.khurasha.beans.Course;
import ca.sheridancollege.khurasha.repositories.CourseList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Coursecontroller {
	@GetMapping("/")
    public String index(Model model) {
        // Your code here
        return "index";
    }

    private final CourseList courseList;

    public Coursecontroller(CourseList courseList) {
        this.courseList = courseList;
    }

    @PostMapping("/processForm")
    public String processForm(
            @RequestParam Long id,
            @RequestParam String prefix,
            @RequestParam int code,
            @RequestParam String name) {

        Course course = new Course(id, prefix, code, name);
        courseList.getCourseList().add(course);
        
        System.out.println("***");
        for (Course c : courseList.getCourseList()) {
            System.out.println(c);
        }

        return "/Working";
    }
}
