package cl.stringmachine.infra.springboot.config;

import core.application.CardService;
import core.spi.CardRepository;
import core.spi.ExternalClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {

    @Bean
    CardService cardService(CardRepository cardRepository, ExternalClient externalClient) {
        return new CardService(cardRepository, externalClient);
    }
}
