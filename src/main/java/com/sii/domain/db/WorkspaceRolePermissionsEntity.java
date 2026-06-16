package com.sii.domain.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "workspace_role_permissions")
@Getter
@NoArgsConstructor
public class WorkspaceRolePermissionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"workspaceRoleId\"")
    private Long workspaceRoleId;

    private String permission;

    private Boolean granted;

    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;
}
