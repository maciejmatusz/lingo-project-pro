package lingo.project.pro.lingo_backend.user.entity;

import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.task.entity.Task;
import lingo.project.pro.lingo_backend.task_comment.entity.TaskComment;
import lingo.project.pro.lingo_backend.user_project_role.entity.UserProjectRole;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "is_active")
    private Boolean isActive;

    @CreationTimestamp
    @Column(updatable = false,name = "created_at")
    private Instant createdAt;

    @OneToMany(mappedBy = "createdBy")
    private List<Task> createdTasks;

    @OneToMany(mappedBy = "assignedTo")
    private List<Task> assignedTasks;

    @OneToMany(mappedBy = "commentingUser")
    private List<TaskComment> taskComments;

    @OneToMany(mappedBy = "user")
    private List<UserProjectRole>  userProjectRoles;
}
