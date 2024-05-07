package peaksoft.services;

import peaksoft.models.Project;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ProjectService {
    void createProjectTable();
    Project getProjectById(Long ProjectId);
    void updateProject(Long id,Project newProject);
    void deleteProjectByID(Long id);
    List<Project> getAllProjects();
}
