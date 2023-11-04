package ca.sheridancollege.khurasha.repositories;

import ca.sheridancollege.khurasha.beans.Course;

import java.util.List;

public interface CourseList {
    public List<Course> getCourseList();
    public void setCourseList(List<Course> courseList);
    public void emptyList();
}
