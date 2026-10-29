package lingo.project.pro.lingo_backend.project.service;

import lingo.project.pro.lingo_backend.project.entity.Project;
import lingo.project.pro.lingo_backend.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private ProjectRepository projectRepository;

    public Project addProject(Project project) {
        return projectRepository.addProject(project);
    }

    public void deleteProjectById(long projectId) {
        projectRepository.deleteProjectById(projectId);
    }

    public Project getProjectById(long projectId) {
        return projectRepository.getProjectById(projectId);
    }

    public List<Project> getProjects() {
        return projectRepository.getProjects();
    }
}
