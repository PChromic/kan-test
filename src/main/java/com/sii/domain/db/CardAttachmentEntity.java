package com.sii.domain.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "card_attachment")
@Getter
@NoArgsConstructor
public class CardAttachmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"publicId\"")
    private String publicId;

    @Column(name = "\"cardId\"")
    private Long cardId;

    private String filename;

    @Column(name = "\"originalFilename\"")
    private String originalFilename;

    @Column(name = "\"contentType\"")
    private String contentType;

    private Long size;

    @Column(name = "\"s3Key\"")
    private String s3Key;

    @Column(name = "\"createdBy\"")
    private UUID createdBy;

    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;

    @Column(name = "\"deletedAt\"")
    private LocalDateTime deletedAt;
}
