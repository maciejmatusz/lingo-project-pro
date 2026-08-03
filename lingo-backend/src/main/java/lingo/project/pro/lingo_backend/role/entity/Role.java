package lingo.project.pro.lingo_backend.role.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigInteger;

@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "role_name")
    private String roleName;
}
