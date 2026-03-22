package cl.stringmachine.infra.quarkus.adapters.inbound;

import cl.stringmachine.infra.quarkus.adapters.inbound.dto.CardDto;
import core.ports.inbound.GetAllCardsUseCasePort;
import core.ports.inbound.SaveCardUseCasePort;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CardRestControllerAdapter {

	private final GetAllCardsUseCasePort getAllCardsUseCasePort;

	private final SaveCardUseCasePort saveCardUseCasePort;

	@Inject
	public CardRestControllerAdapter(GetAllCardsUseCasePort getAllCardsUseCasePort,
			SaveCardUseCasePort saveCardUseCasePort) {
		this.getAllCardsUseCasePort = getAllCardsUseCasePort;
		this.saveCardUseCasePort = saveCardUseCasePort;
	}

	@POST
	public Response saveCard(CardDto body) {
		System.out.println("body: " + body);
		saveCardUseCasePort.saveCard(body.name());
		return Response.status(Response.Status.CREATED).build();

	}

	@GET
	public Response getAllCards() {
		return Response.status(Response.Status.OK)
				.entity(getAllCardsUseCasePort.getAllCards().stream().map(c -> new CardDto(c.name())).toList()).build();
	}

}
