package catalog_microservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import catalog_microservice.entity.Coupons;
import catalog_microservice.service.CatalogueService;



@RestController
@RequestMapping("/catalogue")
public class CatalogueController {
	@Autowired
	CatalogueService catalogueService;

	
	//to add a coupon
	@PostMapping("/add")
	public String addCoupon(@RequestBody Coupons deal) {
		 
		return catalogueService.save(deal);
	}

	//find coupon by id
	@GetMapping("/find/id/{couponId}")
	public Optional<Coupons> searchCouponByCouponId(@PathVariable("couponId") String couponId) {
		Optional<Coupons> coupons = catalogueService.findByCouponId(couponId);
		return coupons;
	}
	
	//find by category
	@GetMapping("/find/category/{category}")
	public List<Optional<Coupons>> searchCouponByCategory(@PathVariable("category") String category) {
		List<Optional<Coupons>> coupons = catalogueService.findByCategory(category);
		return coupons;
	}
	
	//find by company name
	@GetMapping("/find/companyName/{companyName}")
	public List<Optional<Coupons>> searchCouponByCompanyName(@PathVariable("companyName") String companyName) {
		List<Optional<Coupons>> coupons = catalogueService.findByCompanyName(companyName);
		return coupons;
	}

	//delete by coupon id
	@DeleteMapping("/delete/id/{couponId}")
	public String deleteCouponBycouponId(@PathVariable("couponId") String couponId) {
		String result = catalogueService.deleteById(couponId);
		return result;
	}
	
	//delete by category
	@DeleteMapping("/delete/category/{category}")
	public String deleteCouponByCategory(@PathVariable("category") String category) {
		String result = catalogueService.deleteByCategory(category);
		return result;
	}
	
	//delete by company name
	@DeleteMapping("/delete/companyName/{companyName}")
	public String deleteCouponByCompanyName(@PathVariable("companyName") String companyName) {
		String result = catalogueService.deleteByCompanyName(companyName);
		return result;
	}

	//to get all the coupon
	@GetMapping("/findall")
	public List<Coupons> fetchAllProducts(){
		return  catalogueService.fetchAllOrders();
	}

	
	//to update by id
	@PutMapping("/update/id/{id}")
	public Coupons updateCoupon(@RequestBody Coupons deal) {
		return catalogueService.update(deal);
	}
	
	

}