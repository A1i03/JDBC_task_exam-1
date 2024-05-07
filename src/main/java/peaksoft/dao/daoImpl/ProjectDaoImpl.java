package peaksoft.dao.daoImpl;

import peaksoft.config.DataBaseJdbc;
import peaksoft.dao.ProjectDao;
import peaksoft.models.Project;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProjectDaoImpl implements ProjectDao {
    private final Connection connection = DataBaseJdbc.getConnection();

    @Override
    public void createProjectTable() {
        String sql = """
                create table if not exists projects(
                id serial primary key,
                date start_date,
                date end_dare
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Project getProjectById(Long ProjectId) {
        Project project = new Project();
        String sql = "select * from projects where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, ProjectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                project.setId(resultSet.getLong("id"));
                project.setStartDate(resultSet.getDate("star_date").toLocalDate());
                project.setEndDare(resultSet.getDate("end_dare").toLocalDate());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateProject(Long id, Project newProject) {
        String sql = "update projects set start_date = ?,end_dare = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setDate(2, Date.valueOf(newProject.getStartDate()));
            preparedStatement.setDate(3, Date.valueOf(newProject.getEndDare()));
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Successfully updated");
            } else System.out.println("Not found with id ");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteProjectByID(Long id) {
        String sql = "delete from projects where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            int deleteUsers = preparedStatement.executeUpdate();
            if (deleteUsers > 0) {
                System.out.println("Successfully deleted");
            } else System.out.println("Author id not found!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String sql = "select * from projects";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setStartDate(resultSet.getDate("start_date").toLocalDate());
                project.setEndDare(resultSet.getDate("end_date").toLocalDate());
                projects.add(project);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return projects;
    }
}


