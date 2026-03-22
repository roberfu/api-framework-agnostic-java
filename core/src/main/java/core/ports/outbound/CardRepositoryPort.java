package core.ports.outbound;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import core.application.domain.card.Card;

public interface CardRepositoryPort {
	Card saveCard(String name);

	List<@NonNull Card> getAllCards();
}
