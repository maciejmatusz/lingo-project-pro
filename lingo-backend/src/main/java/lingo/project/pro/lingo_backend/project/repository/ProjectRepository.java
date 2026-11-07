package lingo.project.pro.lingo_backend.project.repository;

import lingo.project.pro.lingo_backend.project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    Project addProject(Project project);

    void deleteProjectById(long projectId);

    Optional<Project> getProjectById(long projectId);

    List<Project> getProjects();
}
