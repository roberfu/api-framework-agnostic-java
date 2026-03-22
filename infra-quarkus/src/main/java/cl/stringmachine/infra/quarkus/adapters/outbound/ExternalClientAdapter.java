package cl.stringmachine.infra.quarkus.adapters.outbound;

import cl.stringmachine.infra.quarkus.adapters.outbound.dto.ExternalCardDto;
import core.ports.outbound.ExternalClientPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Optional;

@ApplicationScoped
public class ExternalClientAdapter implements ExternalClientPort {

    @Inject
    @RestClient
    CardRestClient cardRestClient;

    @Override
    public String searchCardName(String cardName) {
        try {
            ExternalCardDto externalCardDto = cardRestClient.getCardByName(cardName);
            return Optional.ofNullable(externalCardDto)
                    .map(ExternalCardDto::name)
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
}
