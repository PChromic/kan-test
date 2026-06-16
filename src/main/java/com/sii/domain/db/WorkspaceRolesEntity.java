package com.sii.domain.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "workspace_roles")
@Getter
@NoArgsConstructor
public class WorkspaceRolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"publicId\"")
    private String publicId;

    @Column(name = "\"workspaceId\"")
    private Long workspaceId;

    private String name;

    private String description;

    @Column(name = "\"hierarchyLevel\"")
    private Integer hierarchyLevel;

    @Column(name = "\"isSystem\"")
    private Boolean isSystem;

    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;

    @Column(name = "\"updatedAt\"")
    private LocalDateTime updatedAt;
}
