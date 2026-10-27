package lingo.project.pro.lingo_backend.project.entity;

import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.client.entity.Client;
import lingo.project.pro.lingo_backend.task.entity.Task;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "parent_project_id")
    private Project projectParent;

    @OneToMany(mappedBy = "project", fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> projectTasks;

    private String description;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

}
