package core.application.service;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import core.application.domain.card.Card;
import core.ports.inbound.GetAllCardsUseCasePort;
import core.ports.inbound.SaveCardUseCasePort;
import core.ports.outbound.CardRepositoryPort;
import core.ports.outbound.ExternalClientPort;

public class CardService implements GetAllCardsUseCasePort, SaveCardUseCasePort {

	private final CardRepositoryPort cardRepositoryPort;
	private final ExternalClientPort externalClientPort;

	public CardService(CardRepositoryPort cardRepositoryPort, ExternalClientPort externalClientPort) {
		this.cardRepositoryPort = cardRepositoryPort;
		this.externalClientPort = externalClientPort;
	}

	@Override
	public void saveCard(String name) {
		String validatedCardName = getValidatedCardName(name);
		cardRepositoryPort.saveCard(validatedCardName);
	}

	@Override
	public List<@NonNull Card> getAllCards() {
		return cardRepositoryPort.getAllCards();
	}

	private String getValidatedCardName(String name) {
		return externalClientPort.searchCardName(name);
	}

}
