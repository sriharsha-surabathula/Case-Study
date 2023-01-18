package catalog_microservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import catalog_microservice.entity.Coupons;


public interface CatalogueRepository extends MongoRepository<Coupons, String> {
	
	List<Optional<Coupons>> findByCategory(String category);

	List<Optional<Coupons>> findByCompanyName(String companyName);
	
	Coupons findByCouponId(String couponId);
}

