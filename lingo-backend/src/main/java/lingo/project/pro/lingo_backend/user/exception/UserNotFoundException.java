package lingo.project.pro.lingo_backend.user.exception;

public class UserNotFoundException extends RuntimeException{
    private final static String MESSAGE = "User not found for id ";

    public UserNotFoundException(Long userId) {
        super(MESSAGE+ userId);
    }
}
