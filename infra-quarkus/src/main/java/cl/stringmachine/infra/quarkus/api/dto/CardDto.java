package cl.stringmachine.infra.quarkus.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CardDto(@JsonProperty(value = "card_name") String cardName) {
}
