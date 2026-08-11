package lingo.project.pro.lingo_backend.project.entity;

import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.client.dto.Client;
import lingo.project.pro.lingo_backend.task.entity.Task;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.time.Instant;
import java.util.List;

@Getter
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "parent_project_id")
    private Project projectParent;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    private String description;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @OneToMany(mappedBy = "project")
    private List<Task> projectTasks;
}
