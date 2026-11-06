package lingo.project.pro.lingo_backend.project.service;

import lingo.project.pro.lingo_backend.project.entity.Project;
import lingo.project.pro.lingo_backend.project.exception.ProjectNotFoundException;
import lingo.project.pro.lingo_backend.project.repository.FakeProjectRepository;
import lingo.project.pro.lingo_backend.project.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ProjectServiceTest {
    ProjectService projectService;

    @BeforeEach
    void setUp() {
        ProjectRepository projectFakeRepository = new FakeProjectRepository();
        projectService = new ProjectService(projectFakeRepository);
    }

    @Test
    void shouldFindByIdSavedProject() {
        //given
        Project project = new Project();

        //when
        Project projectFromService = projectService.addProject(project);
        Project findByIdProject = projectService.getProjectById(projectFromService.getId());
        //then

        assertEquals(projectFromService.getId(), findByIdProject.getId());
    }

    @Test
    void shouldNotCreateDuplicateProject() {
        //given
        Project project = new Project();

        //when
        Project projectFromService = projectService.addProject(project);
        projectService.addProject(projectFromService);
        List<Project> projects = projectService.getProjects();

        //then
        assertEquals(1, projects.size());
        assertEquals(projectFromService.getId(), projects.get(0).getId());
    }

    @Test
    void shouldThrowProjectNotFoundExceptionWhenProjectNotFound() {
        //given
        long projectId = 1L;

        //then
        assertThrows(ProjectNotFoundException.class, () -> projectService.getProjectById(projectId));
    }

    @Test
    void shouldDeleteProject() {
        //given
        Project project1 = new Project();
        Project project2 = new Project();

        //when
        Project projectToDelete = projectService.addProject(project1);
        projectService.addProject(project2);
        projectService.deleteProjectById(projectToDelete.getId());
        List<Project> projectsAfterDelete = projectService.getProjects();

        //then
        assertEquals(1, projectsAfterDelete.size());
        assertNotEquals(projectToDelete.getId(), projectsAfterDelete.get(0).getId());
    }

    @Test
    void shouldListBeTheSameAfterDeleteUnknownId() {
        //given
        long unknownProjectId = 100L;
        Project project = new Project();

        //when
        projectService.addProject(project);
        List<Project> projectsBeforeDelete = projectService.getProjects();
        projectService.deleteProjectById(unknownProjectId);
        List<Project> projectsAfterDelete = projectService.getProjects();

        //then
        assertEquals(projectsBeforeDelete.size(), projectsAfterDelete.size());
        assertEquals(projectsBeforeDelete.get(0).getId(), projectsAfterDelete.get(0).getId());

    }
}
