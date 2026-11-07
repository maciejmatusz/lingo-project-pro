package lingo.project.pro.lingo_backend.user.repository;

import lingo.project.pro.lingo_backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
