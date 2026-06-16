package com.sii.domain.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "\"user\"")
@Getter
@NoArgsConstructor
public class UserEntity {

    @Id
    private UUID id;

    private String name;

    private String email;

    @Column(name = "\"emailVerified\"")
    private Boolean emailVerified;

    private String image;

    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;

    @Column(name = "\"updatedAt\"")
    private LocalDateTime updatedAt;

    @Column(name = "\"stripeCustomerId\"")
    private String stripeCustomerId;
}
