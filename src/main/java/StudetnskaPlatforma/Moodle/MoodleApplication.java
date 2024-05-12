package StudetnskaPlatforma.Moodle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoodleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodleApplication.class, args);
	}
	@Bean
	public CommandLineRunner testDatabaseConnection(BazaTest databaseConnectionTest) {
		return args -> {
			databaseConnectionTest.testConnection();
		};
	}}
