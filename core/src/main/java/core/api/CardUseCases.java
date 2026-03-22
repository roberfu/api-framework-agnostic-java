package core.api;

import core.domain.card.Card;

import java.util.List;

import org.jspecify.annotations.NonNull;

public interface CardUseCases {

    List<@NonNull Card> getAllCards();

    Card saveCard(String cardName);

}
