package core.api;

import core.domain.card.Card;

import java.util.List;

public interface CardUseCases {

    List<Card> getAllCards();

    Card saveCard(String cardName);

}
