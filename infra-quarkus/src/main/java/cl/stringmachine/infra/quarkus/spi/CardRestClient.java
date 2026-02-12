package cl.stringmachine.infra.quarkus.spi;

import cl.stringmachine.infra.quarkus.spi.dto.ExternalCardDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://api.scryfall.com")
public interface CardRestClient {

    @GET
    @Path("/cards/named")
    ExternalCardDto getCardByName(@QueryParam("fuzzy") String cardName);
}
