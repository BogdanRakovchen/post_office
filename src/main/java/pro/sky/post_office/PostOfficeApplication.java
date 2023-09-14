package pro.sky.post_office;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@EnableWebMvc
public class PostOfficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostOfficeApplication.class, args);
	}

}
