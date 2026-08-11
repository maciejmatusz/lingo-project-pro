package lingo.project.pro.lingo_backend.task.entity;


import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.language.entity.Language;
import lingo.project.pro.lingo_backend.project.entity.Project;
import lingo.project.pro.lingo_backend.user.entitiy.User;
import lombok.Getter;

import java.time.Instant;

@Entity
@Getter
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    private Task taskParent;

    @ManyToOne
    @JoinColumn(name = "source_language_id")
    private Language sourceLanguage;

    @ManyToOne
    @JoinColumn(name = "target_language_id")
    private Language targetLanguage;

    private String description;

    private String priority;

    private String status;

    private Instant dueDate;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private User assignedTo;
}
