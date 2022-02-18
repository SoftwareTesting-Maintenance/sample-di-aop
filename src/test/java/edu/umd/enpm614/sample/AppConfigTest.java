package edu.umd.enpm614.sample;

import edu.umd.enpm614.sample.service.Database;
import edu.umd.enpm614.sample.service.MySqlDatabase;
import edu.umd.enpm614.sample.service.OracleDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import javax.inject.Named;

import static edu.umd.enpm614.sample.AppConfig.INJECT_SECURE_DB;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppConfigTest {
    @Inject
    @Named(INJECT_SECURE_DB)
    private Database db;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDatabase() {
        System.out.println(db.toString());
        assertNotNull(db);
    }

    @Test
    void placeholder() {
        fail();
    }

    @Configuration
    public static class TestConfig {
        @Bean(name = INJECT_SECURE_DB)
        public Database getDatabase() {
            return new OracleDatabase();
        }
    }
}