package ca.sheridancollege.khurasha.database;
import ca.sheridancollege.khurasha.beans.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Dataaccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertStudent(Student student) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query="INSERT INTO student(name) VALUES (:name)";
		namedParameters.addValue("name", student.getName());
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
		System.out.println("Hard coded student inserted into database");
		}
	    public List<Student> getStudentList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM student";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));
	}



}
