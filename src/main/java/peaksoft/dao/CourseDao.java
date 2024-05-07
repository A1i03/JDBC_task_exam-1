package peaksoft.dao;

import peaksoft.models.Course;

import java.util.List;
import java.util.Map;

public interface CourseDao {
    void createCourseTable();
    Course getCourseById(Long CourseId);
    void updateCourse(Long id,Course newcourse);
    void deleteCurseByID(Long id);
    Map<String, String> groupCourseByName(String name);
    void getLongestCourse(Long id);

}
