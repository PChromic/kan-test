package com.sii.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;

public final class ApiConfig {
    private static final Properties PROPERTIES = PropertiesLoader.readPropertiesFromFile("secrets.properties");
    private static final String BASE_URL = PROPERTIES.getProperty("api.baseUrl");
    private static final String BEARER_TOKEN = PROPERTIES.getProperty("api.token");

    public static RequestSpecification createRequestSpec(boolean includeAuth) {
        var builder = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter());
        if (includeAuth) {
            builder.addHeader("Authorization", "Bearer " + BEARER_TOKEN);
        }
        return builder.build();
    }
}
