package com.bytes.errs.dto;

import java.time.LocalDateTime;

public class UserReward {
	
	private Long userId;
	private Long rewardId;
	private LocalDateTime timestamp = LocalDateTime.now();
	
	
	 public UserReward() {
	        this.timestamp = LocalDateTime.now(); // Initialize timestamp with current time
	 }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRewardId() {
		return rewardId;
	}

	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}

	

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
