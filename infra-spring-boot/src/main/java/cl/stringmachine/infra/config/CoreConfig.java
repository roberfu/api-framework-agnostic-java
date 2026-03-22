package cl.stringmachine.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import core.application.service.CardService;
import core.ports.outbound.CardRepositoryPort;
import core.ports.outbound.ExternalClientPort;

@Configuration
public class CoreConfig {

	@Bean
	CardService cardService(CardRepositoryPort cardRepository, ExternalClientPort externalClient) {
		return new CardService(cardRepository, externalClient);
	}
}
