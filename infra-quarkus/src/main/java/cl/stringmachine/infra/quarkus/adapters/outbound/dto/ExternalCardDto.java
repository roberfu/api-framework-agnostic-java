package cl.stringmachine.infra.quarkus.adapters.outbound.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExternalCardDto(String name) {
}
