package cl.stringmachine.infra.springboot.spi;

import cl.stringmachine.infra.springboot.spi.entity.CardEntity;
import core.domain.card.Card;
import core.spi.CardRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CardRepositoryImpl implements CardRepository {

    private final CardJpaRepository cardJpaRepository;

    public CardRepositoryImpl(CardJpaRepository cardJpaRepository) {
        this.cardJpaRepository = cardJpaRepository;
    }

    @Override
    @Transactional
    public Card saveCard(String cardName) {
        CardEntity entity = cardJpaRepository.save(new CardEntity(null, cardName));
        return new Card(entity.getCardName());
    }

    @Override
    public List<Card> getAllCards() {
        return cardJpaRepository.findAll().stream().map(entity -> new Card(entity.getCardName()))
                .toList();
    }
}
