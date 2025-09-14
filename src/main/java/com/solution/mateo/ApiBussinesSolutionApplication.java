package com.solution.mateo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
@OpenAPIDefinition
public class ApiBussinesSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBussinesSolutionApplication.class, args);
	}

	/*@Bean
	CommandLineRunner demoFlux() {
		return args -> {
			Flux.range(1, 100)
					.onBackpressureBuffer(10) // Buffer limitado
					.publishOn(Schedulers.parallel())
					.subscribe(data -> {
						try {
							Thread.sleep(50); // Consumidor lento
							System.out.println("Consumed: " + data);
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
						}
					});
		};
	}*/
}