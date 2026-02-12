package cl.stringmachine.infra.springboot.spi;

import cl.stringmachine.infra.springboot.spi.dto.ExternalCardDto;
import core.spi.ExternalClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class ExternalClientImpl implements ExternalClient {

    private final RestTemplate restTemplate;

    private static final String BASE_URL = "https://api.scryfall.com/cards/named?fuzzy=";

    public ExternalClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String searchCardName(String cardName) {
        try {
            String url = BASE_URL + cardName;
            ResponseEntity<ExternalCardDto> response = restTemplate.getForEntity(url, ExternalCardDto.class);
            return Optional.ofNullable(response.getBody()).map(ExternalCardDto::name).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
}
