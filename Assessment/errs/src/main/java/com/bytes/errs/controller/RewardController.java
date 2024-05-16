package com.bytes.errs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytes.errs.model.Reward;
import com.bytes.errs.service.RewardService;

@RestController
@RequestMapping(value = "reward")
@CrossOrigin(origins = "*")
public class RewardController {
	
	@Autowired
	public RewardService rewardService;
	
	@PostMapping("/addNewReward")
	public Reward addNewReward(@RequestBody Reward reward) {
		return rewardService.addNewReward(reward);
		
	}
	
	@GetMapping("/getAllRewards")
	public List<Reward> getAllProducts(){
		return rewardService.getAllRewards();
		
	}
	
	@DeleteMapping("/deleteReward/{rewardId}")
	public void deleteReward(@PathVariable Long rewardId) {
		 rewardService.deleteReward(rewardId);
	}
	
	@GetMapping("/getRewardById/{rewardId}")
	public Reward getRewardById(@PathVariable Long rewardId) {
		 return rewardService.getRewardById(rewardId);
	}
	
	
	
	
	
}
