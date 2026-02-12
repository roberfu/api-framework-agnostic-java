package cl.stringmachine.infra.springboot.api;

import cl.stringmachine.infra.springboot.api.dto.CardDto;
import core.api.CardUseCases;
import core.domain.card.Card;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardUseCases cardUseCases;

    public CardController(CardUseCases cardUseCases) {
        this.cardUseCases = cardUseCases;
    }

    @PostMapping()
    public CardDto saveCard(@RequestBody CardDto request) {
        Card card = cardUseCases.saveCard(request.cardName());
        return new CardDto(card.cardName());
    }

    @GetMapping()
    public List<CardDto> getAllCards() {
        return cardUseCases.getAllCards().stream().map(card -> new CardDto(card.cardName())).toList();
    }
}
