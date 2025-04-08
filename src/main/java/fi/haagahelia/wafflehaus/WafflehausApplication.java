package fi.haagahelia.wafflehaus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@SpringBootApplication
public class WafflehausApplication {

	private final DataSource dataSource;

	public WafflehausApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// This prints Hibernate-registered entities
	@Bean
	public CommandLineRunner debugEntities(EntityManagerFactory emf) {
		return args -> {
			emf.getMetamodel().getEntities().forEach(entity -> {
				System.out.println("🔎 Hibernate sees: " + entity.getName());
			});
		};
	}

	// This prints the exact DB Hibernate is connected to
	@PostConstruct
	public void printHibernateConnection() throws SQLException {
		try (Connection conn = dataSource.getConnection()) {
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("🔗 JDBC URL: " + meta.getURL());
			System.out.println("🧑‍💻 Connected user: " + meta.getUserName());
			System.out.println("🧠 DB version: " + meta.getDatabaseProductVersion());
			System.out.println("📦 Driver: " + meta.getDriverName());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(WafflehausApplication.class, args);
	}
}
