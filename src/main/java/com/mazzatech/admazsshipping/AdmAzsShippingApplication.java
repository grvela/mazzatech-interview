package com.mazzatech.admazsshipping;

import com.mazzatech.admazsshipping.persistence.interfaces.ShippingMongoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = ShippingMongoRepository.class)
public class AdmAzsShippingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmAzsShippingApplication.class, args);
	}

}
