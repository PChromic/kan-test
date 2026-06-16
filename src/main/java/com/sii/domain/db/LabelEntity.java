package com.sii.domain.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "label")
@Getter
@NoArgsConstructor
public class LabelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"publicId\"")
    private String publicId;

    private String name;

    @Column(name = "\"colourCode\"")
    private String colourCode;

    @Column(name = "\"createdBy\"")
    private UUID createdBy;

    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;

    @Column(name = "\"updatedAt\"")
    private LocalDateTime updatedAt;

    @Column(name = "\"boardId\"")
    private Long boardId;

    @Column(name = "\"importId\"")
    private Long importId;

    @Column(name = "\"deletedAt\"")
    private LocalDateTime deletedAt;

    @Column(name = "\"deletedBy\"")
    private UUID deletedBy;
}
