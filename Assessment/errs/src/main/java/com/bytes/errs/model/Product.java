package com.bytes.errs.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String productDescription;
	private String productCategory; 
	private String manufacturer;
	private Date expiryDate;
	private Integer quantityAvailable;
	private String termsandConditions;
	private Boolean featuredStatus;
	private Boolean availabilityStatus;
	private String additionalMetadata;
	private Integer pointsInBytes;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    })
	@JoinTable(name="PRODUCT_IMAGE", 
			joinColumns = {
					@JoinColumn (name="PRODUCT_ID")},
			inverseJoinColumns = {
					@JoinColumn(name="IMAGE_ID")}
	)
	private Set<Image> productImages;
	
	@ManyToMany
    @JoinTable(
        name = "user_product",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Integer getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(Integer quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public String getTermsandConditions() {
		return termsandConditions;
	}
	public void setTermsandConditions(String termsandConditions) {
		this.termsandConditions = termsandConditions;
	}
	public Boolean getFeaturedStatus() {
		return featuredStatus;
	}
	public void setFeaturedStatus(Boolean featuredStatus) {
		this.featuredStatus = featuredStatus;
	}
	public Boolean getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(Boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	public String getAdditionalMetadata() {
		return additionalMetadata;
	}
	public void setAdditionalMetadata(String additionalMetadata) {
		this.additionalMetadata = additionalMetadata;
	}
	public Integer getPointsInBytes() {
		return pointsInBytes;
	}
	public void setPointsInBytes(Integer pointsInBytes) {
		this.pointsInBytes = pointsInBytes;
	}
	public Set<Image> getProductImages() {
		return productImages;
	}
	public void setProductImages(Set<Image> productImages) {
		this.productImages = productImages;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
