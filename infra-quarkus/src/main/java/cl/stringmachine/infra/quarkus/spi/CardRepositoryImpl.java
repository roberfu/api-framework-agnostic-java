package cl.stringmachine.infra.quarkus.spi;

import cl.stringmachine.infra.quarkus.spi.entity.CardEntity;
import core.domain.card.Card;
import core.spi.CardRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

import org.jspecify.annotations.NonNull;

@ApplicationScoped
public class CardRepositoryImpl implements CardRepository {

    @Override
    @Transactional
    public Card saveCard(String cardName) {
        CardEntity entity = new CardEntity(cardName);
        entity.persistAndFlush();
        return new Card(entity.getCardName());
    }

    @Override
    public List<@NonNull Card> getAllCards() {
        return CardEntity.<CardEntity>listAll()
                .stream()
                .map(entity -> new Card(entity.getCardName()))
                .toList();
    }
}
