package org.younus.javaworkshop.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.younus.javaworkshop.messenger.model.Message;
import org.younus.javaworkshop.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	private MessageService msgService = new MessageService();

	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		if(year != 0)
			return msgService.getAllMessagesByYear(year);
		else if(start > 0 && size > 0)
			return msgService.getAllMessagesWithPagination(start-1, size-1);
		return msgService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id) {
		return msgService.getMessage(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return msgService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId")long id, Message message) {
		message.setId(id);
		return msgService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId")long id) {
		msgService.deleteMessage(id);
	}
}
