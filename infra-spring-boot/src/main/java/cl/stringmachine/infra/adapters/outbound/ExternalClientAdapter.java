package cl.stringmachine.infra.adapters.outbound;

import core.ports.outbound.ExternalClientPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.eclipse.jdt.annotation.NonNull;

import cl.stringmachine.infra.adapters.outbound.dto.ExternalCardDto;

import java.util.Optional;

@Component
public class ExternalClientAdapter implements ExternalClientPort {

    private final RestTemplate restTemplate;

    private static final String BASE_URL = "https://api.scryfall.com/cards/named?fuzzy=";

    public ExternalClientAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String searchCardName(String cardName) {
        try {
            String url = BASE_URL + cardName;
            ResponseEntity<@NonNull ExternalCardDto> response = restTemplate.getForEntity(url, ExternalCardDto.class);
            return Optional.ofNullable(response.getBody()).map(ExternalCardDto::name).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
}
