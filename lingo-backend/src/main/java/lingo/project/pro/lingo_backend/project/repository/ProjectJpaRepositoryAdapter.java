package lingo.project.pro.lingo_backend.project.repository;

import lingo.project.pro.lingo_backend.project.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProjectJpaRepositoryAdapter implements ProjectRepository {
    private final ProjectJpaRepository projectJpaRepository;


    @Override
    public Project addProject(Project project) {
        return projectJpaRepository.save(project);
    }

    @Override
    public void deleteProjectById(long projectId) {
        projectJpaRepository.deleteById(projectId);
    }

    @Override
    public Optional<Project> getProjectById(long id) {
        return projectJpaRepository.findById(id);
    }

    @Override
    public List<Project> getProjects() {
        return projectJpaRepository.findAll();
    }
}
