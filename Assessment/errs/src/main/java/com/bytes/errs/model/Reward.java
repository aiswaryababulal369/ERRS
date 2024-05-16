package com.bytes.errs.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Reward {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rewardId;
	private String rewardName;
	private String rewardDescription;
	private Integer byteValue;
	
	
	
	@ManyToMany
    @JoinTable(
        name = "user_reward",
        joinColumns = @JoinColumn(name = "reward_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();
	
	public Reward() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	public Reward(Long rewardId, String rewardName, String rewardDescription, Integer byteValue, Set<User> users) {
		super();
		this.rewardId = rewardId;
		this.rewardName = rewardName;
		this.rewardDescription = rewardDescription;
		this.byteValue = byteValue;
		this.users = users;
	}





	public Long getRewardId() {
		return rewardId;
	}
	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}
	public String getRewardName() {
		return rewardName;
	}
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}
	public String getRewardDescription() {
		return rewardDescription;
	}
	public void setRewardDescription(String rewardDescription) {
		this.rewardDescription = rewardDescription;
	}
	public Integer getByteValue() {
		return byteValue;
	}
	public void setByteValue(Integer byteValue) {
		this.byteValue = byteValue;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
