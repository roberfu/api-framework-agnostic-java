package cl.stringmachine.infra.quarkus.spi;

import cl.stringmachine.infra.quarkus.spi.dto.ExternalCardDto;
import core.spi.ExternalClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Optional;

@ApplicationScoped
public class ExternalClientImpl implements ExternalClient {

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
