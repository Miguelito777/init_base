package gt.com.initwebapps.initwebapps_base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaAuditing
public class InitwebappsBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitwebappsBaseApplication.class, args);
	}
}
