package lingo.project.pro.lingo_backend.task_comment.entity;

import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.task.entity.Task;
import lingo.project.pro.lingo_backend.user.entity.User;
import lombok.Getter;

import java.time.Instant;

@Entity
@Getter
@Table(name = "task_comments")
public class TaskComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User commentingUser;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task commentedTask;

    @Column(name = "created_at")
    private Instant createdAt;
}
