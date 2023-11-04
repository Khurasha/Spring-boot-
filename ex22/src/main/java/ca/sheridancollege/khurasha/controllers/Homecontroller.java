package ca.sheridancollege.khurasha.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.khurasha.beans.Appointment;

@Controller
public class Homecontroller {
		@GetMapping("/")
		public String index(Model model)
		{
			return "index";
		}
		
		@PostMapping ("/formPost")
		public String formpost (Model model,
		@RequestParam String firstname, 
		@RequestParam String email,
		@RequestParam @DateTimeFormat (iso=DateTimeFormat.ISO.DATE) LocalDate appointmentDate,
		@RequestParam @DateTimeFormat (iso=DateTimeFormat.ISO.TIME) LocalTime appointmentTime)
		{
			Appointment appointment = new Appointment ();
			appointment.setFirstname (firstname) ; 
			appointment.setEmail (email);
		    appointment.setAppointmentDate (appointmentDate);
		    appointment.setAppointmentTime (appointmentTime);
		System.out.println(appointment); 
		return "working";
	}}

