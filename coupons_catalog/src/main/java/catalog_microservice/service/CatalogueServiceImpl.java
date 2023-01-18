package catalog_microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalog_microservice.entity.Coupons;
import catalog_microservice.exception.ApiRequestException;
import catalog_microservice.repositories.CatalogueRepository;



@Service
public class CatalogueServiceImpl implements CatalogueService {

	@Autowired
	CatalogueRepository catalogueRepository;

	public String save(Coupons deal) {
		 catalogueRepository.insert(deal);
				return ("The Deal Added Successfully");
	}

	public List<Coupons> fetchAllOrders() {
		return  catalogueRepository.findAll();
    }

	
	public Optional<Coupons> findByCouponId(String couponId) {
		
		 return Optional.of(catalogueRepository.findById(couponId).orElseThrow( () -> new ApiRequestException("id not found ::")));
	}

	public List<Optional<Coupons>> findByCategory(String category) {
		List<Optional<Coupons>> coupons = catalogueRepository.findByCategory(category);
		return coupons;
	}
	
	public List<Optional<Coupons>> findByCompanyName(String companyName) {
		List<Optional<Coupons>> coupons = catalogueRepository.findByCompanyName(companyName);
		return coupons;
	}
	
	public String deleteById(String id) {
		if (!findByCouponId(id).isEmpty()) {
			catalogueRepository.deleteById(id);
			return "Id " + id + " deleted!";
		} else {
			return "Id " + id + " is not found";
		}
	}

	public String deleteByCategory(String category) {
		List<Optional<Coupons>> coupons = findByCategory(category);
		if (coupons.size()>0) {
			for(Optional<Coupons> coupon: coupons) {
				catalogueRepository.deleteById(coupon.get().getCouponId());
			}
			return "Category " + category + " deleted!";
		} else {
			return "Category " + category + " is not found";
		}
	}

	public String deleteByCompanyName(String companyName) {	
		List<Optional<Coupons>> coupons = findByCompanyName(companyName);
		if (coupons.size()>0) {
			for(Optional<Coupons> coupon: coupons) {
				catalogueRepository.deleteById(coupon.get().getCouponId());
			}
			return "Company name " + companyName + " deleted!";
		} else {
			return "Company name " + companyName + " is not found";
		}
	}
	
	public Coupons update(Coupons deals) {
		Optional<Coupons> optionalCoupons = Optional.ofNullable(catalogueRepository.findByCouponId(deals.getCouponId()));
		if(optionalCoupons.isPresent()){
			return  catalogueRepository.save(deals);
		}else{
			return null;
		}
	}

}