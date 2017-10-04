package br.inatel.pos.dm107.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.pmw.tinylog.Logger;

import br.inatel.pos.dm107.DAO.EntregaDAO;
import br.inatel.pos.dm107.modelos.Entrega;

@Path("/entrega")
public class EntregaRestServices {

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response recuperaTodasEntregas() {
		List<Entrega> entregas = EntregaDAO.recuperarTodasEntregas();
		
		if (entregas.isEmpty()) {
			Logger.error("Nao existe pedido no banco!");
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(entregas).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{numeroPedido}")
	public Response recuperaEntregaPorNumeroDoPedido(@PathParam("numeroPedido") Long numeroPedido) {
		Entrega entrega = EntregaDAO.recuperarEntregaPeloNumeroDoPedido(numeroPedido);

		if (entrega == null) {
			Logger.error("Numero do pedido nao encontrado!");
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.ok(entrega).build();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response insereNovaEntrega(Entrega payload) {
		try {
			EntregaDAO.criarNovaEntrega(payload);
		} catch (SQLException e) {
			Logger.error("Falha ao tentar salvar uma entrega no banco, possivelmente o numeroDoPedido ja existe!");
			return Response.status(Status.BAD_REQUEST).build();
		}

		return Response.ok(payload).build();
	}
}
