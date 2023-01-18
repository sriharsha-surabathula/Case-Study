package catalog_microservice.service;

import java.util.List;
import java.util.Optional;

import catalog_microservice.entity.Coupons;



public interface CatalogueService {
	
	String save(Coupons deal);

	List<Optional<Coupons>> findByCategory(String category);

	List<Optional<Coupons>> findByCompanyName(String companyName);

	String deleteByCategory(String category);

	 public List<Coupons> fetchAllOrders();

	String deleteByCompanyName(String companyName);

	String deleteById(String couponId);

	Optional<Coupons> findByCouponId(String couponId);
	
	 public Coupons update(Coupons deal);

}