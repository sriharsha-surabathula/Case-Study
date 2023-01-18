package user_management_mcs.service;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import user_management_mcs.entity.User;

public interface ProfileService {
	
	public String joinGroup( User user);
	 public String giveAccessToUser( String userId, String userRole, Principal principal);
	 public List<User> loadUsers();
	

	 User getLoggedInUser(Principal principal);
	 public ResponseEntity<Object> deleteById(String id);

}
