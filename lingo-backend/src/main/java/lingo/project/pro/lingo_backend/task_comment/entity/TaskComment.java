package lingo.project.pro.lingo_backend.task_comment.entity;

import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.task.entity.Task;
import lingo.project.pro.lingo_backend.user.entity.User;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User commentingUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task commentedTask;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Instant createdAt;
}
