package catalog_micrpservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import catalog_microservice.entity.Coupons;
import catalog_microservice.repositories.CatalogueRepository;
import catalog_microservice.service.CatalogueService;

@SpringBootTest
class CatalogueMcsApplicationTests {

	@Autowired
	private CatalogueService service;

	@MockBean
	private CatalogueRepository repository;

	@Test
	@DisplayName("This is Get all coupons Catalogue Test")
	public void fetchAllOrdersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Coupons("1", "sports","abc","20%",30,"abc",40),
						new Coupons("2", "sports","abc","20%",30,"abc",40)).collect(Collectors.toList()));
		assertEquals(2, service.fetchAllOrders().size());
	}
	
	@Test
	@DisplayName("This Save operation test")
	public void saveTest() {
		Coupons coupon = new Coupons("23","sports","abc","20%",30,"abc",40);
		when(repository.save(coupon)).thenReturn(coupon);
		assertEquals(coupon, service.save(coupon));
	}
}