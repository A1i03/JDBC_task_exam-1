package peaksoft.services.serviceImpl;

import peaksoft.dao.ProjectDao;
import peaksoft.dao.daoImpl.ProjectDaoImpl;
import peaksoft.models.Product;
import peaksoft.models.Project;
import peaksoft.services.ProductService;
import peaksoft.services.ProjectService;

import java.util.List;
import java.util.Map;

public class ProjectServiceImpl implements ProjectService {
    ProjectDao projectDao = new ProjectDaoImpl();


    @Override
    public void createProjectTable() {
        projectDao.createProjectTable();
    }

    @Override
    public Project getProjectById(Long ProjectId) {
        return projectDao.getProjectById(ProjectId);
    }

    @Override
    public void updateProject(Long id, Project newProject) {
    projectDao.updateProject(id,newProject);
    }

    @Override
    public void deleteProjectByID(Long id) {
    projectDao.deleteProjectByID(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }
}

