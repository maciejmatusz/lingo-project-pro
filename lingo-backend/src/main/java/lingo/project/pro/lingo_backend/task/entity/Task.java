package lingo.project.pro.lingo_backend.task.entity;


import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.language.entity.Language;
import lingo.project.pro.lingo_backend.project.entity.Project;
import lingo.project.pro.lingo_backend.task_comment.entity.TaskComment;
import lingo.project.pro.lingo_backend.user.entity.User;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String priority;

    private String status;

    private Instant dueDate;

    private Instant completedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_task_id")
    private Task taskParent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_language_id")
    private Language sourceLanguage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_language_id")
    private Language targetLanguage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to_id")
    private User assignedTo;

    @OneToMany(mappedBy = "commentedTask", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TaskComment> comments;

    @OneToMany(mappedBy = "taskParent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> childrenTasks;


}
