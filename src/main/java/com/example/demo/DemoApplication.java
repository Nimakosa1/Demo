package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.demo.model.User;
import com.example.demo.model.Product;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.ProductRepository;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository, ProductRepository productRepository) {
		return args -> {
			if (userRepository.count() == 0) {
				userRepository.saveAll(Arrays.asList(
					createUser("Alice Smith", "123 Main St", "USA", "alice", "alice@example.com"),
					createUser("Bob Johnson", "456 Oak Ave", "Canada", "bob", "bob@example.com"),
					createUser("Charlie Brown", "789 Pine Rd", "UK", "charlie", "charlie@example.com")
				));
			}
			if (productRepository.count() == 0) {
				productRepository.saveAll(Arrays.asList(
					createProduct("Adobe Photoshop", "Image editing software", "Graphics", 20.99, "mac,windows", LocalDate.of(2023, 1, 10)),
					createProduct("Adobe Illustrator", "Vector graphics editor", "Graphics", 19.99, "mac,windows", LocalDate.of(2023, 2, 15)),
					createProduct("Adobe Premiere Pro", "Video editing software", "Video", 24.99, "mac,windows", LocalDate.of(2023, 3, 20)),
					createProduct("Adobe After Effects", "Motion graphics and visual effects", "Video", 22.99, "mac,windows", LocalDate.of(2023, 4, 25)),
					createProduct("Adobe InDesign", "Page design and layout", "Publishing", 18.99, "mac,windows", LocalDate.of(2023, 5, 30)),
					createProduct("Adobe XD", "UI/UX design and prototyping", "Design", 16.99, "mac,windows", LocalDate.of(2023, 6, 5)),
					createProduct("Adobe Lightroom", "Photo editing and organization", "Photography", 15.99, "mac,windows", LocalDate.of(2023, 7, 10)),
					createProduct("Adobe Audition", "Audio editing software", "Audio", 17.99, "mac,windows", LocalDate.of(2023, 8, 15)),
					createProduct("Adobe Acrobat Pro", "PDF editor", "Documents", 14.99, "mac,windows", LocalDate.of(2023, 9, 20))
				));
			}
		};
	}

	private User createUser(String name, String address, String country, String username, String email) {
		User user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setCountry(country);
		user.setUsername(username);
		user.setEmail(email);
		user.setCreatedAt(LocalDateTime.now());
		return user;
	}

	private Product createProduct(String name, String description, String category, double price, String platform, LocalDate releaseDate) {
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setCategory(category);
		product.setPrice(price);
		product.setPlatform(platform);
		product.setReleaseDate(releaseDate);
		return product;
	}

	@Configuration
	class JacksonConfig {
	    @Bean
	    public Jackson2ObjectMapperBuilder jacksonBuilder() {
	        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	        builder.featuresToEnable(SerializationFeature.INDENT_OUTPUT); // Pretty print
	        builder.modules(new JavaTimeModule()); // Support for Java 8 date/time
	        builder.propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE); // Optional: snake_case
	        return builder;
	    }
	}
}
