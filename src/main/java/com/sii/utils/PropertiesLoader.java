package com.sii.utils;


import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Properties;

public final class PropertiesLoader {
    private static final TestLogger log = TestLogger.getLogger(PropertiesLoader.class);

    @SneakyThrows(IOException.class)
    public static Properties readPropertiesFromFile(String propertiesFile) {
        log.info(String.format("Using property file: %s", propertiesFile));
        var classLoader = Thread
                .currentThread()
                .getContextClassLoader();
        try (var inputStream = classLoader.getResourceAsStream(propertiesFile)) {
            var p = new Properties();
            p.load(inputStream);
            return p;
        }
    }
}
