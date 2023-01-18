package catalog_microservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "dealcatalog")

public class Coupons {

	@Id
	private String couponId;
	@Field
	private String coupons_name;
	@Field
	private String coupons_desc;
	@Field
	private String category;
	@Field
	private int coupons_qty;
	@Field
	private String companyName;
	@Field
	private int coupons_price;
	
	public int getCoupons_price() {
		return coupons_price;
	}
	public void setCoupons_price(int coupons_price) {
		this.coupons_price = coupons_price;
	}
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getCoupons_name() {
		return coupons_name;
	}
	public void setCoupons_name(String coupons_name) {
		this.coupons_name = coupons_name;
	}
	public String getCoupons_desc() {
		return coupons_desc;
	}
	public void setCoupons_desc(String coupons_desc) {
		this.coupons_desc = coupons_desc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCoupons_qty() {
		return coupons_qty;
	}
	public void setCoupons_qty(int coupons_qty) {
		this.coupons_qty = coupons_qty;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Coupons(String couponId, String coupons_name, String coupons_desc, String category, int coupons_qty,
			String companyName, int coupons_price) {
		super();
		this.couponId = couponId;
		this.coupons_name = coupons_name;
		this.coupons_desc = coupons_desc;
		this.category = category;
		this.coupons_qty = coupons_qty;
		this.companyName = companyName;
		this.coupons_price = coupons_price;
	}
	@Override
	public String toString() {
		return "Coupons [couponId=" + couponId + ", coupons_name=" + coupons_name + ", coupons_desc=" + coupons_desc
				+ ", category=" + category + ", coupons_qty=" + coupons_qty + ", companyName=" + companyName
				+ ", coupons_price=" + coupons_price + "]";
	}
	public Coupons() {
	}

	
	
	
}
