package lingo.project.pro.lingo_backend.role.entity;


import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.user_project_role.entity.UserProjectRole;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<UserProjectRole> userProjectRoles;
}
