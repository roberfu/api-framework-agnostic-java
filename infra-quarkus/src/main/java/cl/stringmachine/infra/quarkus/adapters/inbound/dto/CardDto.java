package cl.stringmachine.infra.quarkus.adapters.inbound.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CardDto(@JsonProperty("name") String name) {

}
