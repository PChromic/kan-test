package com.sii.domain.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "workspace_members")
@Getter
@NoArgsConstructor
public class WorkspaceMembersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"publicId\"")
    private String publicId;

    @Column(name = "\"userId\"")
    private UUID userId;

    @Column(name = "\"workspaceId\"")
    private Long workspaceId;

    @Column(name = "\"createdBy\"")
    private UUID createdBy;

    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;

    @Column(name = "\"updatedAt\"")
    private LocalDateTime updatedAt;

    @Column(name = "\"deletedAt\"")
    private LocalDateTime deletedAt;

    @Column(name = "\"deletedBy\"")
    private UUID deletedBy;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "role")
    private String role;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "status")
    private String status;

    private String email;

    @Column(name = "\"roleId\"")
    private Long roleId;
}
