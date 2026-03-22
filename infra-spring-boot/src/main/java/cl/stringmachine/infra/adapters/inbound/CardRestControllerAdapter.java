package cl.stringmachine.infra.adapters.inbound;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.stringmachine.infra.adapters.inbound.dto.CardDto;
import core.ports.inbound.GetAllCardsUseCasePort;
import core.ports.inbound.SaveCardUseCasePort;

@RestController
@RequestMapping("/api/cards")
public class CardRestControllerAdapter {

	private final SaveCardUseCasePort saveCardUseCasePort;

	private final GetAllCardsUseCasePort getAllCardsUseCasePort;

	public CardRestControllerAdapter(SaveCardUseCasePort saveCardUseCasePort,
			GetAllCardsUseCasePort getAllCardsUseCasePort) {
		this.saveCardUseCasePort = saveCardUseCasePort;
		this.getAllCardsUseCasePort = getAllCardsUseCasePort;
	}

	@PostMapping()
	public ResponseEntity<Void> saveCard(@RequestBody CardDto body) {
		saveCardUseCasePort.saveCard(body.cardName());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping()
	public ResponseEntity<List<@NonNull CardDto>> getAllCards() {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(getAllCardsUseCasePort.getAllCards().stream().map(c -> new CardDto(c.name())).toList());
	}
}
