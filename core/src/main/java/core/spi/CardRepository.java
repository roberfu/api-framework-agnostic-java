package core.spi;

import core.domain.card.Card;

import java.util.List;

public interface CardRepository {
    Card saveCard(String cardName);

    List<Card> getAllCards();
}
