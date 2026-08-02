package lingo.project.pro.lingo_backend.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.time.Instant;

@Data
@Entity
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

}
