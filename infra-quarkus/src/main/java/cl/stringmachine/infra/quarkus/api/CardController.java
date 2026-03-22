package cl.stringmachine.infra.quarkus.api;

import cl.stringmachine.infra.quarkus.api.dto.CardDto;
import core.api.CardUseCases;
import core.domain.card.Card;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import org.jspecify.annotations.NonNull;

@Path("api/cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CardController {

    private final CardUseCases cardUseCases;

    @Inject
    public CardController(CardUseCases cardUseCases) {
        this.cardUseCases = cardUseCases;
    }

    @POST
    public CardDto saveCard(CardDto request) {
        Card card = cardUseCases.saveCard(request.cardName());
        return new CardDto(card.cardName());
    }

    @GET
    public List<@NonNull CardDto> getAllCards() {
        List<@NonNull Card> cards = cardUseCases.getAllCards();
        return cards.stream().map(card -> new CardDto(card.cardName())).toList();
    }

}
