package peaksoft.services.serviceImpl;

import peaksoft.dao.CourseDao;
import peaksoft.dao.daoImpl.CourseDaoImpl;
import peaksoft.models.Course;
import peaksoft.services.CourseService;

import java.util.Map;

public class CourseServiceImpl implements CourseService{
    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void createCourseTable() {
        courseDao.createCourseTable();
    }

    @Override
    public Course getCourseById(Long CourseId) {
        return courseDao.getCourseById(CourseId);
    }

    @Override
    public void updateCourse(Long id, Course newcourse) {
    courseDao.updateCourse(id,newcourse);
    }

    @Override
    public void deleteCurseByID(Long id) {
    courseDao.deleteCurseByID(id);
    }

    @Override
    public Map<String, String> groupCourseByName(String name) {
        return courseDao.groupCourseByName(name);
    }


    @Override
    public void getLongestCourse(Long id) {
    courseDao.getLongestCourse(id);
    }
}
