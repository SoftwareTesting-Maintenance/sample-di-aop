package edu.umd.enpm614.sample;

import edu.umd.enpm614.sample.service.*;
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

    @Bean(name = INJECT_SECURE_DB)
    public Database getSecureDatabase() {
        return new OracleDatabase();
    }

    private void test() {
        this.connectToDatabase(new DatabaseTest());
        this.connectToDatabase(new SecuredDatabse());
    }

    @Bean()
    public void doSomeBeanWork() {
        placeholderService.doSomeWork();
    }

    public void connectToDatabase(DatabaseTest db) {
        db.get();
    }

    @Bean
    public AuthenticationService authenticationService() {
        return new DbAuthenticationService();
    }

    @Bean
    public Login login(AuthenticationService authenticationService) {
        return new Login(authenticationService);
    }
}
