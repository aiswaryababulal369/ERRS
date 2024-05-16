package com.bytes.errs.dto;

import java.util.List;

public class UserBulkReward {
	private List<Long> userIds;
    private Long rewardId;
    
    
	public UserBulkReward(List<Long> userIds, Long rewardId) {
		super();
		this.userIds = userIds;
		this.rewardId = rewardId;
	}
	
	
	public List<Long> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}
	public Long getRewardId() {
		return rewardId;
	}
	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}
    
    
}
