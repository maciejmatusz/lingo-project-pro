package lingo.project.pro.lingo_backend.user_project_role.entity;

import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.project.entity.Project;
import lingo.project.pro.lingo_backend.role.entity.Role;
import lingo.project.pro.lingo_backend.user.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Getter
@EqualsAndHashCode
@Table(name = "user_project_roles")
public class UserProjectRole {
    @EmbeddedId
    private UserProjectRoleId id;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;
}
