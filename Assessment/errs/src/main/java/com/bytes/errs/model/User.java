package com.bytes.errs.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String firstName;
	private String userPassword;
	private Integer currentBytes;
	private Integer totalBytes;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade =CascadeType.MERGE)
	@JoinTable(name="USER_ROLE", 
			joinColumns = {
					@JoinColumn (name="USER_ID")},
			inverseJoinColumns = {
					@JoinColumn(name="ROLE_ID")}
	)
	private Set<Role> role;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", userPassword="
				+ userPassword + ", currentBytes=" + currentBytes + ", totalBytes=" + totalBytes + ", role=" + role
				+ ", rewards=" + rewards + "]";
	}


	@ManyToMany(mappedBy = "users")
	@JsonBackReference("rewardsBackReference")
	private Set<Reward> rewards = new HashSet<>();
	
	@ManyToMany(mappedBy = "users")
	@JsonBackReference("productsBackReference")
	private Set<Product> products = new HashSet<>();
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public User(Long userId, String userName, String firstName, String userPassword, Integer currentBytes,
			Integer totalBytes, Set<Role> role, Set<Reward> rewards, Set<Product> products) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.userPassword = userPassword;
		this.currentBytes = currentBytes;
		this.totalBytes = totalBytes;
		this.role = role;
		this.rewards = rewards;
		this.products = products;
	}




	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public Integer getCurrentBytes() {
		return currentBytes;
	}


	public void setCurrentBytes(Integer currentBytes) {
		this.currentBytes = currentBytes;
	}


	public Integer getTotalBytes() {
		return totalBytes;
	}


	public void setTotalBytes(Integer totalBytes) {
		this.totalBytes = totalBytes;
	}


	public Set<Role> getRole() {
		return role;
	}


	public void setRole(Set<Role> role) {
		this.role = role;
	}


	public Set<Reward> getRewards() {
		return rewards;
	}


	public void setRewards(Set<Reward> rewards) {
		this.rewards = rewards;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	

}
