package cl.stringmachine.infra.adapters.inbound.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CardDto(@JsonProperty(value = "card_name") String cardName) {

}
