package org.younus.javaworkshop.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.younus.javaworkshop.messenger.model.Message;
import org.younus.javaworkshop.messenger.database.DatabaseClass;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesByYear(int year) {
		List<Message> messagesOnYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()) {
			cal.setTime(message.getCreatedOn());
			if(cal.get(Calendar.YEAR) == year)
				messagesOnYear.add(message);
		}
		return messagesOnYear;
	}
	
	public List<Message> getAllMessagesWithPagination(int start, int size) {
		List<Message> message = new ArrayList<Message>(messages.values());
		if((start + size) >= message.size())
			return message;
		return message.subList(start, start+size);
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		message.setCreatedOn(new Date());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(Long id) {
		return messages.remove(id);
	}
	
	public Message updateMessage(Message message) {
		if(!messages.containsKey(message.getId())) {
			return null;
		}
		Message existingMessage = messages.get(message.getId());
		existingMessage.setMessage(message.getMessage());
//		messages.put(message.getId(), message);
		return existingMessage;
	}
}
