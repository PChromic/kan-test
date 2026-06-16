package com.sii.domain.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "workspace_invite_links")
@Getter
@NoArgsConstructor
public class WorkspaceInviteLinksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"publicId\"")
    private String publicId;

    @Column(name = "\"workspaceId\"")
    private Long workspaceId;

    private String code;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "status")
    private String status;

    @Column(name = "\"expiresAt\"")
    private LocalDateTime expiresAt;

    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;

    @Column(name = "\"createdBy\"")
    private UUID createdBy;

    @Column(name = "\"updatedAt\"")
    private LocalDateTime updatedAt;

    @Column(name = "\"updatedBy\"")
    private UUID updatedBy;
}
