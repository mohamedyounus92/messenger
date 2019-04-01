package org.younus.javaworkshop.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.younus.javaworkshop.messenger.model.Message;
import org.younus.javaworkshop.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<Long, Message>() {
		{
			put(1L, new Message(1, "Hello World!", "younus.hakkim"));
			put(2L, new Message(2, "Welcome Folks..!", "younus.hakkim"));
		}
	};
	private static Map<String, Profile> profiles = new HashMap<String, Profile>() {
		{
			put("younus.hakkim", new Profile(1L, "younus.hakkim", "Mohamed Younus", "Hakkim"));
			put("wasim.hakkim", new Profile(2L, "wasim.hakkim", "Mohamed Wasim", "Hakkim"));
		}
	};
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
