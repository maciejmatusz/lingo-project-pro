package lingo.project.pro.lingo_backend.user.entitiy;

import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.task.entity.Task;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger id;

    private String email;

    private String password_hash;

    private Boolean is_active;


    @CreationTimestamp
    @Column(updatable = false)
    private Instant created_at;

    @OneToMany(mappedBy ="createdBy")
    private List<Task> createdTasks;

    @OneToMany(mappedBy ="assignedTo")
    private List<Task> assignedTasks;
}
