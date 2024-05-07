package peaksoft.dao;

import peaksoft.models.Course;
import peaksoft.models.Project;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ProjectDao {
    void createProjectTable();
    Project getProjectById(Long ProjectId);
    void updateProject(Long id,Project newProject);
    void deleteProjectByID(Long id);
    List<Project>getAllProjects();

}
