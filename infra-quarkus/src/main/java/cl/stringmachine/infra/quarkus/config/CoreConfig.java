package cl.stringmachine.infra.quarkus.config;

import core.application.service.CardService;
import core.ports.outbound.CardRepositoryPort;
import core.ports.outbound.ExternalClientPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class CoreConfig {

	@Produces
	@ApplicationScoped
	public CardService cardService(CardRepositoryPort cardRepository, ExternalClientPort externalClient) {
		return new CardService(cardRepository, externalClient);
	}
}
