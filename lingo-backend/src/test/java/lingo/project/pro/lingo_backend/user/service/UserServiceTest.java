package lingo.project.pro.lingo_backend.user.service;

import lingo.project.pro.lingo_backend.user.entity.User;
import lingo.project.pro.lingo_backend.user.exception.UserNotFoundException;
import lingo.project.pro.lingo_backend.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldFindAllUsers() {
        //given
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));

        //when
        List<User> usersFromService = userService.getAllUsers();

        //then
        assertEquals(2, usersFromService.size());
    }


    @Test
    void shouldFindUserById() {
        //given
        long userIdToFind = 2L;
        User user = new User();
        ReflectionTestUtils.setField(user, "id", userIdToFind);
        ReflectionTestUtils.setField(user, "name", "Mark");
        when(userRepository.findById(userIdToFind)).thenReturn(Optional.of(user));

        //when
        User userFromService = userService.getUserById(userIdToFind);

        //then
        assertEquals(user.getId(), userFromService.getId());
        assertEquals(user.getName(), userFromService.getName());
    }

    @Test
    void shouldDeleteUser() {
        //given
        long userIdToDelete = 2L;

        //when
        userService.deleteUserById(userIdToDelete);

        //then
        verify(userRepository).deleteById(userIdToDelete);
    }

    @Test
    void shouldAddUser() {
        //given
        long userIdToFind = 2L;
        User user = new User();
        ReflectionTestUtils.setField(user, "id", userIdToFind);
        ReflectionTestUtils.setField(user, "name", "Mark");
        when(userRepository.save(user)).thenReturn(user);

        //when
        User userFromCreate = userService.create(user);

        //then
        assertEquals(user.getId(), userFromCreate.getId());
        assertEquals(user.getName(), userFromCreate.getName());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        //given
        long userIdToFind = 2L;
        when(userRepository.findById(userIdToFind)).thenReturn(Optional.empty());


        //then
        assertThrows(UserNotFoundException.class, () -> userService.getUserById(userIdToFind));
    }

}
