package com.mobileprogramming.ats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.mobileprogramming.ats.fileproperty.FileStorageProperties;

@SpringBootApplication
@EnableJpaAuditing

@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class ApplicantTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicantTrackingSystemApplication.class, args);
	}

}
