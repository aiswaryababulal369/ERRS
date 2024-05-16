package com.bytes.errs.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytes.errs.dao.RewardRepository;
import com.bytes.errs.model.Reward;
import com.bytes.errs.service.RewardService;


@Service
public class RewardServiceImpl implements RewardService {
	
	@Autowired
	public RewardRepository rewardRepository;
	

	@Override
	public Reward addNewReward(Reward reward) {

		return rewardRepository.save(reward);
	}

	@Override
	public List<Reward> getAllRewards() {
		return rewardRepository.findAll();
	}

	@Override
	public void deleteReward(Long rewardId) {
		rewardRepository.deleteById(rewardId);
		
	}

	@Override
	public Reward getRewardById(Long rewardId) {
		Optional<Reward> rewardOptional = rewardRepository.findById(rewardId);
		return rewardOptional.orElse(null);
	}

}
