package com.sii.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HibernateUtil {

    public static EntityManagerFactory EMF;

    private static EntityManagerFactory buildFactory() {
        Properties db = PropertiesLoader.readPropertiesFromFile("database.properties");
        Map<String, Object> props = new HashMap<>();
        props.put("jakarta.persistence.jdbc.driver", "org.postgresql.Driver");
        props.put("jakarta.persistence.jdbc.url", db.getProperty("db.url"));
        props.put("jakarta.persistence.jdbc.user", db.getProperty("db.user"));
        props.put("jakarta.persistence.jdbc.password", db.getProperty("db.password"));
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.hbm2ddl.auto", "none");
        props.put("hibernate.show_sql", "true");
        return Persistence.createEntityManagerFactory("kan", props);
    }

    public static synchronized EntityManager openEntityManager() {
        if (EMF == null) EMF = buildFactory();
        return EMF.createEntityManager();
    }
}
