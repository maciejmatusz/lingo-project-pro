package lingo.project.pro.lingo_backend.project.repository;

import lingo.project.pro.lingo_backend.project.entity.Project;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FakeProjectRepository implements ProjectRepository {
    Map<Long, Project> projects = new HashMap<>();

    Long idIncrementer;

    public FakeProjectRepository() {
        idIncrementer = 0L;
    }

    @Override
    public Project addProject(Project project) {
        if(project.getId() != null){
            this.projects.put(project.getId(), project);
        }else{
            ReflectionTestUtils.setField(project, "id", ++idIncrementer);
            projects.put(project.getId(), project);
        }

        return project;
    }

    @Override
    public void deleteProjectById(long projectId) {
        this.projects.remove(projectId);
    }

    @Override
    public Optional<Project> getProjectById(long projectId) {
        Project project = projects.get(projectId);
        return Optional.ofNullable(project);
    }

    @Override
    public List<Project> getProjects() {
        return projects.values().stream().toList();
    }
}
