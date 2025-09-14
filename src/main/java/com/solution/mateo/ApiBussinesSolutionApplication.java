package com.solution.mateo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
@OpenAPIDefinition
public class ApiBussinesSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBussinesSolutionApplication.class, args);

		/** Implementación de contrapresión **/

		Flux.range(1, 100)
				.onBackpressureBuffer(10) // Buffer size to handle overflow
				.publishOn(Schedulers.parallel())
				.subscribe(data -> {
					try {
						Thread.sleep(50); // Simulate slow consumer
						System.out.println("Consumed: " + data);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				});


	}

}
