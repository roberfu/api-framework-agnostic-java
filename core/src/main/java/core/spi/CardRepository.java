package core.spi;

import core.domain.card.Card;

import java.util.List;

import org.jspecify.annotations.NonNull;

public interface CardRepository {
    Card saveCard(String cardName);

    List<@NonNull Card> getAllCards();
}
