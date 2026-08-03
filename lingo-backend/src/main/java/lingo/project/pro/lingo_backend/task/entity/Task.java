package lingo.project.pro.lingo_backend.task.entity;


import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.project.entity.Project;
import lombok.Getter;

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
}
