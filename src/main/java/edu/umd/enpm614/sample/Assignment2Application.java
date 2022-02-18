package edu.umd.enpm614.sample;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.inject.Inject;

@SpringBootApplication
public class Assignment2Application implements ApplicationRunner {
	private final Login login;

	@Inject
	public Assignment2Application(Login login) {
		this.login = login;
	}

	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user = login.login("user", "superSecretPassword");
		user.name = "Anumeet";
		user.address = "UMD";
		System.out.println(user);
	}
}
