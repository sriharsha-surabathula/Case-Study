package user_management_mcs.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import user_management_mcs.controller.UserConstant;
import user_management_mcs.entity.User;
import user_management_mcs.exception.CatalogRequestException;
import user_management_mcs.repositories.UserRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	UserRepository repository;

	@Override
	public String joinGroup(User user) {
		 user.setRoles(UserConstant.DEFAULT_ROLE);
	        String encryptedPwd = new String();
	        user.setPassword(encryptedPwd);
	        repository.save(user);
	        return "Hi " + user.getUserName() + " welcome to group !";
	}

	@Override
	public String giveAccessToUser(String userId, String userRole, Principal principal) {
		User user = repository.findById(userId).get();
        List<String> activeRoles = getRolesByLoggedInUser(principal);
        String newRole = "";
        if (activeRoles.contains(userRole)) {
            newRole = user.getRoles() + "," + userRole;
            user.setRoles(newRole);
        }
        repository.save(user);
        return "Hi " + user.getUserName() + " New Role assign to you by " + principal.getName();// TODO Auto-generated method stub
		
	}

	private List<String> getRolesByLoggedInUser(Principal principal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> loadUsers() {
		// TODO Auto-generated method stub
		List<User> user = repository.findAll();;
		return user;
	}

	

	public ResponseEntity<Object> deleteById(String id)
	{
		boolean isUserExist=repository.existsById(id);
		 if(isUserExist) {
			 repository.deleteById(id);
			 return new ResponseEntity<Object>("user deleted with id "+id,HttpStatus.OK);
		 }
		 else
		 {
		 	throw new CatalogRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		 }
	}


	@Override
	public User getLoggedInUser(Principal principal) {
		// TODO Auto-generated method stub
		 return repository.findByUserName(principal.getName()).get();
	}

}