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
import javax.ws.rs.core.MediaType;

import org.younus.javaworkshop.messenger.model.Profile;
import org.younus.javaworkshop.messenger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName")String name) {
		return profileService.getProfile(name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("profileName")String name, Profile profile) {
		profile.setProfileName(name);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profileName")String name) {
		profileService.deleteProfile(name);
	}
}
