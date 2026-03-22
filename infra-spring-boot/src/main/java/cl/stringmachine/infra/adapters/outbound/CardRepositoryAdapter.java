package cl.stringmachine.infra.adapters.outbound;

import core.application.domain.card.Card;
import core.ports.outbound.CardRepositoryPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

@Component
public class CardRepositoryAdapter implements CardRepositoryPort {

    private final JpaRepositoryAdapter jpaRepositoryAdapter;

    public CardRepositoryAdapter(JpaRepositoryAdapter jpaRepositoryAdapter) {
        this.jpaRepositoryAdapter = jpaRepositoryAdapter;
    }

    @Override
    @Transactional
    @SuppressWarnings("null")
    public Card saveCard(String cardName) {
        CardEntity entity = jpaRepositoryAdapter.save(new CardEntity(null, cardName));
        return new Card(entity.getCardName());
    }

    @Override
    public List<@NonNull Card> getAllCards() {
        return jpaRepositoryAdapter.findAll().stream().map(entity -> new Card(entity.getCardName()))
                .toList();
    }
}
