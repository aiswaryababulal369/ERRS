package com.bytes.errs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytes.errs.model.Reward;

@Service
public interface RewardService {

	Reward addNewReward(Reward reward);

	List<Reward> getAllRewards();

	void deleteReward(Long rewardId);

	Reward getRewardById(Long rewardId);

	

}
