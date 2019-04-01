package org.younus.javaworkshop.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.younus.javaworkshop.messenger.database.DatabaseClass;
import org.younus.javaworkshop.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profile.setCreated(new Date());
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty() && !profiles.containsKey(profile.getProfileName()))
			return null;
		Profile existingProfile = profiles.get(profile.getProfileName());
		if(profile.getFirstName() != null)
			existingProfile.setFirstName(profile.getFirstName());
		if(profile.getLastName() != null)
			existingProfile.setLastName(profile.getLastName());
		if(profile.getProfileName() != null)
			existingProfile.setProfileName(profile.getProfileName());
//		profiles.put(profile.getProfileName(), profile);
		return existingProfile;
	}
}
