package core.application;

import core.api.CardUseCases;
import core.domain.card.Card;
import core.spi.CardRepository;
import core.spi.ExternalClient;

import java.util.List;

public class CardService implements CardUseCases {

    private final CardRepository cardRepository;
    private final ExternalClient externalClient;

    public CardService(CardRepository cardRepository, ExternalClient externalClient) {
        this.cardRepository = cardRepository;
        this.externalClient = externalClient;
    }

    @Override
    public Card saveCard(String cardName) {
        String validatedCardName = getValidatedCardName(cardName);
        return cardRepository.saveCard(validatedCardName);
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.getAllCards();
    }

    private String getValidatedCardName(String cardName) {
        return externalClient.searchCardName(cardName);
    }


}
