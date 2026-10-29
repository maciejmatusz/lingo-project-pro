package lingo.project.pro.lingo_backend.project.repository;

import lingo.project.pro.lingo_backend.project.entity.Project;

import java.util.List;

public interface ProjectRepository {

    Project addProject(Project project);

    void deleteProjectById(long projectId);

    Project getProjectById(long projectId);

    List<Project> getProjects();
}
