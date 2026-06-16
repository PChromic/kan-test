package com.sii.repository;

import com.sii.domain.db.BoardEntity;
import com.sii.utils.HibernateUtil;

import java.util.List;

public class BoardRepository {

    public static List<BoardEntity> findByName(String name) {
        try (var em = HibernateUtil.openEntityManager()) {
            return em.createQuery(
                            "FROM BoardEntity WHERE name = :name AND deletedAt IS NULL",
                            BoardEntity.class)
                    .setParameter("name", name)
                    .getResultStream()
                    .toList();
        }
    }

    public static boolean existsByName(String name) {
        try (var em = HibernateUtil.openEntityManager()) {
            Long count = em.createQuery(
                            "SELECT COUNT(b) FROM BoardEntity b WHERE b.name = :name AND b.deletedAt IS NULL",
                            Long.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return count > 0;
        }
    }
}
