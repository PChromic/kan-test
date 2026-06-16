package com.sii.domain.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "workspace")
@Getter
@NoArgsConstructor
public class WorkspaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"publicId\"")
    private String publicId;

    private String name;

    private String description;

    private String slug;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "plan")
    private String plan;

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

    @Column(name = "\"showEmailsToMembers\"")
    private Boolean showEmailsToMembers;

    @Column(name = "\"weekStartDay\"")
    private Integer weekStartDay;

    @Column(name = "\"cardPrefix\"")
    private String cardPrefix;

    @Column(name = "\"cardCounter\"")
    private Integer cardCounter;
}
