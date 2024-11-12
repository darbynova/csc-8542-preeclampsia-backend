package edu.villanova.csc8542.preeclampsia;

import edu.villanova.csc8542.preeclampsia.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class PreeclampsiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreeclampsiaApplication.class, args);
	}

}
