package cl.stringmachine.infra.quarkus.adapters.outbound;

import core.application.domain.card.Card;
import core.ports.outbound.CardRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

@ApplicationScoped
public class CardRepositoryAdapter implements CardRepositoryPort {

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
