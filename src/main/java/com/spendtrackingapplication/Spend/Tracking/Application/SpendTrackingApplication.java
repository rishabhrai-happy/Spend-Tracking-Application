package com.spendtrackingapplication.Spend.Tracking.Application;

import com.spendtrackingapplication.Spend.Tracking.Application.mongoRepository.PurchaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@ComponentScan("com.example.SpendTrackingApplication")
@EnableMongoRepositories(basePackageClasses = PurchaseRepository.class)
@EnableJpaRepositories(basePackages="com.spendtrackingapplication.Spend.Tracking.Application.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.spendtrackingapplication.Spend.Tracking.Application.entity.")
public class SpendTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendTrackingApplication.class, args);
	}

}
