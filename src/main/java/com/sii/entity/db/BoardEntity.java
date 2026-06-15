package com.sii.entity.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"publicId\"")
    private String publicId;

    private String name;

    private String slug;

    @Column(name = "\"workspaceId\"")
    private Long workspaceId;

    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;

    @Column(name = "\"deletedAt\"")
    private LocalDateTime deletedAt;

    @Column(name = "\"isArchived\"")
    private Boolean isArchived;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "type")
    private String type;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "visibility")
    private String visibility;
}
