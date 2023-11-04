package ca.sheridancollege.khurasha.beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

	private String firstname;
	private String email;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	@Override
	public String toString() {
		return "Appointment [firstname=" + firstname + ", email=" + email + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + "]";
	}
}
