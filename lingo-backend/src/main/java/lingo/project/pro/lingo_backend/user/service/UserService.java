package lingo.project.pro.lingo_backend.user.service;

import lingo.project.pro.lingo_backend.user.entity.User;
import lingo.project.pro.lingo_backend.user.exception.UserNotFoundException;
import lingo.project.pro.lingo_backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(long userId) {
        userRepository.deleteById(userId);
    }

    public User getUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
