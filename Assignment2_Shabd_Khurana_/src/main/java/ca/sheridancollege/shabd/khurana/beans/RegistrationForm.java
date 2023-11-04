package ca.sheridancollege.shabd.khurana.beans;

import lombok.Data;

@Data
public class RegistrationForm {
    private String firstName;
    private String lastName;
    private String[] gender = {"Male", "Female"};
    private String email;
    private String[] schoolName = {"sheridan davis campus" , "Sheridan trafalgar campus"};
    private String[] course = {"Java" , "Python" , "Ruby" , "Scala"};
}
