package com.rollingstone.spring.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLLINGSTONE_PRICING")
public class Pricing {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;

    @Column(name = "PCODE", nullable = false) private String productCode;

    @Column(name = "PRICE_ID", nullable = false) private String pricingId;

    @Column(name = "MEMBER_TYPE", nullable = false) private String memberType;

    @Column(name = "PRICE_TYPE", nullable = false) private String priceType;

    @Column(name = "LABEL", nullable = false) private Double discountAmount;

    @Column(name = "DISPLAY", nullable = false) private String display;

    @Column(name = "ORIG_PRICE", nullable = false) private Double originalPrice;

    @Column(name = "DISC_PRICE", nullable = false) private Double discountedPrice;

    public Pricing() {
    }

    public Pricing(String productCode, String pricingId, String memberType, String priceType, Double discountAmount, String display,
		   Double originalPrice, Double discountedPrice) {
	this.productCode = productCode;
	this.pricingId = pricingId;
	this.memberType = memberType;
	this.priceType = priceType;
	this.discountAmount = discountAmount;
	this.display = display;
	this.originalPrice = originalPrice;
	this.discountedPrice = discountedPrice;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getProductCode() {
	return productCode;
    }

    public void setProductCode(String productCode) {
	this.productCode = productCode;
    }

    public String getPricingId() {
	return pricingId;
    }

    public void setPricingId(String pricingId) {
	this.pricingId = pricingId;
    }

    public String getMemberType() {
	return memberType;
    }

    public void setMemberType(String memberType) {
	this.memberType = memberType;
    }

    public String getPriceType() {
	return priceType;
    }

    public void setPriceType(String priceType) {
	this.priceType = priceType;
    }

    public Double getDiscountAmount() {
	return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
	this.discountAmount = discountAmount;
    }

    public String getDisplay() {
	return display;
    }

    public void setDisplay(String display) {
	this.display = display;
    }

    public Double getOriginalPrice() {
	return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
	this.originalPrice = originalPrice;
    }

    public Double getDiscountedPrice() {
	return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
	this.discountedPrice = discountedPrice;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	Pricing pricing = (Pricing)o;
	return id == pricing.id
			&& Objects.equals(productCode, pricing.productCode)
			&& Objects.equals(pricingId, pricing.pricingId)
			&& Objects.equals(memberType, pricing.memberType)
			&& Objects.equals(priceType, pricing.priceType)
			&& Objects.equals(discountAmount, pricing.discountAmount)
			&& Objects.equals(display, pricing.display)
			&& Objects.equals(originalPrice, pricing.originalPrice)
			&& Objects.equals(discountedPrice, pricing.discountedPrice);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id, productCode, pricingId, memberType, priceType, discountAmount, display, originalPrice, discountedPrice);
    }

    @Override
    public String toString() {
	return "Pricing{"
			+ "id="
			+ id
			+ ", productCode='"
			+ productCode
			+ '\''
			+ ", pricingId='"
			+ pricingId
			+ '\''
			+ ", memberType='"
			+ memberType
			+ '\''
			+ ", priceType='"
			+ priceType
			+ '\''
			+ ", discountAmount="
			+ discountAmount
			+ ", display='"
			+ display
			+ '\''
			+ ", originalPrice="
			+ originalPrice
			+ ", discountedPrice="
			+ discountedPrice
			+ '}';
    }
}
