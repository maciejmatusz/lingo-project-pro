package lingo.project.pro.lingo_backend.project.exception;

public class ProjectNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Project not found for id ";

    public ProjectNotFoundException(Long projectId) {
        super(MESSAGE + projectId);
    }
}
