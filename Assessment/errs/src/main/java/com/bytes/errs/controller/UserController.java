package com.bytes.errs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bytes.errs.dto.UserBulkReward;
import com.bytes.errs.dto.UserProduct;
import com.bytes.errs.dto.UserReward;
import com.bytes.errs.exception.UserNotFoundException;
import com.bytes.errs.model.Transaction;
import com.bytes.errs.model.User;
import com.bytes.errs.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	public UserService userService;

	@PostConstruct
	public void initRoleAndUser() {
		if (userService != null) {
			userService.initRoleAndUser();
		} else {
			// Handle the case where userService is null (optional)
			throw new IllegalStateException("userService is not initialized.");
		}
	}

	@PostMapping("/registerNewUser")
	public ResponseEntity<String> registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllProducts() {
		return userService.getAllProducts();

	}

	@PostMapping("/reward/add")
	public ResponseEntity<?> addReward(@RequestBody UserReward userReward) {
		return userService.addReward(userReward);

	}

	@PutMapping("/updatePassword/{username}/password")
    public ResponseEntity<String> updatePassword(@PathVariable String username, @RequestParam String newPassword) {
//		return ResponseEntity.ok("Password updated successfully"); 
		try {
            userService.updatePassword(username, newPassword);
            return ResponseEntity.ok("Password updated successfully");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating password");
        }
}

	@DeleteMapping("/deleteuser/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}

	@PostMapping("/reward/bulkadd")
	public ResponseEntity<?> addBulkReward(@RequestBody UserBulkReward userBulkReward) {
		return userService.addBulkReward(userBulkReward.getUserIds(), userBulkReward.getRewardId());
	}

	@PostMapping("/product/add")
	public ResponseEntity<?> addProduct(@RequestBody UserProduct userProduct) {
		return userService.addProduct(userProduct);
	}

	@GetMapping("/getalltransactions")
	public List<Transaction> getAllTransactions() {
		return userService.getAllTransactions();
	}

}
