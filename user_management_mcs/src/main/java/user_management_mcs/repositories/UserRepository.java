package user_management_mcs.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import user_management_mcs.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	 Optional<User> findByUserName(String username);

		Optional<User> findById(String userId);
		
		public void deleteById(String id);

}
