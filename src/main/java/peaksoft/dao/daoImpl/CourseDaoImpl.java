package peaksoft.dao.daoImpl;

import peaksoft.config.DataBaseJdbc;
import peaksoft.dao.CourseDao;
import peaksoft.models.Course;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CourseDaoImpl implements CourseDao {
    private final Connection connection = DataBaseJdbc.getConnection();
    @Override
    public void createCourseTable() {
        String sql = """
                create table if not exists courses(
                id serial primary key,
                name varchar,
                description varchar,
                duration int
                )
                """;
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Course getCourseById(Long CourseId) {
        Course course = new Course();
        String sql = """
                select * from courses where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,CourseId);
            ResultSet resultSet  = preparedStatement.executeQuery();
            while (resultSet.next()){
                course.setName(resultSet.getString("name"));
                course.setDescription(resultSet.getString("description"));
                course.setDuration(resultSet.getInt("duration"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return course;
    }

    @Override
    public void updateCourse(Long id, Course newcourse) {
        String sql = """
                update courses set name=?, description=?,duration=? where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,newcourse.getName());
            preparedStatement.setString(2,newcourse.getDescription());
            preparedStatement.setInt(3,newcourse.getDuration());
            preparedStatement.setLong(4,id);
           preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteCurseByID(Long id) {
        String sql = "delete from courses where id = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);

            int deleteUsers = preparedStatement.executeUpdate();
            if (deleteUsers > 0) {
                System.out.println("Successfully deleted");
            } else System.out.println("Author id not found!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Map<String, String> groupCourseByName(String name) {
        Map<String, String> courseMap = new HashMap<>();
        String sql = "select courses.name from courses where name = ?";
        try ( PreparedStatement statement  =  connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            statement.setString(1,name);
            while (resultSet.next()){
                String coursesName = resultSet.getString("name");
                courseMap.put(coursesName, coursesName);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return courseMap;
    }


    @Override
    public void getLongestCourse(Long id) {
        String sql = "SELECT course.name, duration FROM courses WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setLong(1,id);
            if (resultSet.next()){
                String courseName = resultSet.getString("name");
                int duration = resultSet.getInt("duration");
                System.out.println(courseName);
                System.out.println(duration);
            }else {
                System.out.println("No course found with ID: " + id);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
