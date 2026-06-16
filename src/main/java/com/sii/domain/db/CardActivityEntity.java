package com.sii.domain.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "card_activity")
@Getter
@NoArgsConstructor
public class CardActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"publicId\"")
    private String publicId;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "type")
    private String type;

    @Column(name = "\"cardId\"")
    private Long cardId;

    @Column(name = "\"fromIndex\"")
    private Integer fromIndex;

    @Column(name = "\"toIndex\"")
    private Integer toIndex;

    @Column(name = "\"fromListId\"")
    private Long fromListId;

    @Column(name = "\"toListId\"")
    private Long toListId;

    @Column(name = "\"labelId\"")
    private Long labelId;

    @Column(name = "\"workspaceMemberId\"")
    private Long workspaceMemberId;

    @Column(name = "\"fromTitle\"")
    private String fromTitle;

    @Column(name = "\"toTitle\"")
    private String toTitle;

    @Column(name = "\"fromDescription\"")
    private String fromDescription;

    @Column(name = "\"toDescription\"")
    private String toDescription;

    @Column(name = "\"createdBy\"")
    private UUID createdBy;

    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;

    @Column(name = "\"commentId\"")
    private Long commentId;

    @Column(name = "\"fromComment\"")
    private String fromComment;

    @Column(name = "\"toComment\"")
    private String toComment;

    @Column(name = "\"sourceBoardId\"")
    private Long sourceBoardId;

    @Column(name = "\"fromDueDate\"")
    private LocalDateTime fromDueDate;

    @Column(name = "\"toDueDate\"")
    private LocalDateTime toDueDate;

    @Column(name = "\"attachmentId\"")
    private Long attachmentId;
}
