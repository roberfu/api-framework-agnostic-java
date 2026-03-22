package core.ports.inbound;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import core.application.domain.card.Card;

public interface GetAllCardsUseCasePort {
	List<@NonNull Card> getAllCards();
}
