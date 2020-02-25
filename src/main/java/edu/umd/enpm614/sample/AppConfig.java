package edu.umd.enpm614.sample;

import edu.umd.enpm614.sample.service.Database;
import edu.umd.enpm614.sample.service.MySqlDatabase;
import edu.umd.enpm614.sample.service.OracleDatabase;
import edu.umd.enpm614.sample.service.PlaceholderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;

import javax.inject.Inject;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    public static final String INJECT_OPEN_DB = "edu.umd.enpm614.open.database";
    public static final String INJECT_SECURE_DB = "edu.umd.enpm614.secure.database";

    @Inject
    PlaceholderService placeholderService;

    @Bean(name = INJECT_OPEN_DB)
    public Database getDatabase() {
        return new MySqlDatabase();
    }

    @Primary
    @Bean(name = INJECT_SECURE_DB)
    public Database getSecureDatabase() {
        return new OracleDatabase();
    }

    @Bean()
    public void doSomeBeanWork() {
        placeholderService.doSomeWork();
    }
}
