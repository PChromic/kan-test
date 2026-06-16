package com.sii.domain.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "workspace_webhooks")
@Getter
@NoArgsConstructor
public class WorkspaceWebhooksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"publicId\"")
    private String publicId;

    @Column(name = "\"workspaceId\"")
    private Long workspaceId;

    private String name;

    private String url;

    private String secret;

    private String events;

    private Boolean active;

    @Column(name = "\"createdBy\"")
    private UUID createdBy;

    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;

    @Column(name = "\"updatedAt\"")
    private LocalDateTime updatedAt;
}
