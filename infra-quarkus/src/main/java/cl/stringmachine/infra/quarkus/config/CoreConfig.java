package cl.stringmachine.infra.quarkus.config;

import core.application.CardService;
import core.spi.CardRepository;
import core.spi.ExternalClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class CoreConfig {

    @Produces
    @ApplicationScoped
    public CardService cardService(CardRepository cardRepository,
                                   ExternalClient externalClient) {
        return new CardService(cardRepository, externalClient);
    }
}
