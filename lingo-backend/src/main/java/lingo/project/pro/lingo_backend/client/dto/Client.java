package lingo.project.pro.lingo_backend.client.dto;


import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.project.entity.Project;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.time.Instant;
import java.util.List;

@Getter
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "contact_email")
    private String contactEmail;

    @OneToMany(mappedBy = "client")
    private List<Project> projects;

    @Column(name = "tax_id")
    private String taxId;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Instant createdAt;

}
