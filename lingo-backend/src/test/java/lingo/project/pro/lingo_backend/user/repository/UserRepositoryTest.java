package lingo.project.pro.lingo_backend.user.repository;


import lingo.project.pro.lingo_backend.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void shouldAddUser() {
        //given
        User user = new User();
        ReflectionTestUtils.setField(user, "name", "Mark");
        ReflectionTestUtils.setField(user, "email", "mark@gmail.com");

        //when
        User savedUser = userRepository.save(user);
        testEntityManager.flush();
        testEntityManager.clear();
        Optional<User> optionalUser = userRepository.findById(savedUser.getId());

        //then
        assertTrue(optionalUser.isPresent());
        assertNotNull(optionalUser.get().getCreatedAt());
        assertEquals(savedUser.getId(), optionalUser.get().getId());
        assertEquals(savedUser.getName(), optionalUser.get().getName());
        assertEquals(savedUser.getEmail(), optionalUser.get().getEmail());
    }

    @Test
    void shouldDeleteUser() {
        //given
        User newUser = new User();

        //when
        User savedUser = userRepository.save(newUser);
        List<User> allUserBeforeDelete = userRepository.findAll();
        userRepository.deleteById(savedUser.getId());
        List<User> allUserAfterDelete = userRepository.findAll();

        //then
        assertNotEquals(allUserBeforeDelete.size(), allUserAfterDelete.size());
        assertEquals(0, allUserAfterDelete.size());
    }

    @Test
    void shouldReturnListOfUser() {
        //given
        User user = new User();

        //when
        List<User> allUserBeforeAdding = userRepository.findAll();
        userRepository.save(user);
        testEntityManager.flush();
        testEntityManager.clear();
        List<User> allUserAfterAdding = userRepository.findAll();

        //then
        assertNotEquals(allUserBeforeAdding.size(), allUserAfterAdding.size());
        assertEquals(1, allUserAfterAdding.size());
    }
}
