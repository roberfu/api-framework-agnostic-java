package cl.stringmachine.infra.quarkus.spi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExternalCardDto(String name) {
}
