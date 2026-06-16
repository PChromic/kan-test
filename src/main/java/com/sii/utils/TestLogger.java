package com.sii.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {
    private final Logger logger;

    private TestLogger(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    public static TestLogger getLogger(Class<?> clazz) {
        return new TestLogger(clazz);
    }

    public void info(String message) { logger.info(message); }
    public void step(String message) { logger.info("➡️  " + message); }
    public void success(String message) { logger.info("✅ " + message); }
    public void warn(String message) { logger.warn("⚠️  " + message); }
    public void fail(String message) { logger.error("❌ " + message); }
    public void error(String message) { logger.error("❌ " + message); }
}
