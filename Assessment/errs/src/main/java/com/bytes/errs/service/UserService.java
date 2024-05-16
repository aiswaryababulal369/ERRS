package com.bytes.errs.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.bytes.errs.configuration.JwtUtil;
//import com.bytes.errs.configuration.Utility;
import com.bytes.errs.dao.ProductRepository;
import com.bytes.errs.dao.RewardRepository;
import com.bytes.errs.dao.RoleRepository;
import com.bytes.errs.dao.TransactionDao;
import com.bytes.errs.dao.UserRepository;
import com.bytes.errs.dto.UserProduct;
import com.bytes.errs.dto.UserReward;
import com.bytes.errs.exception.UserNotFoundException;
import com.bytes.errs.exception.UsernameAlreadyExistsException;
import com.bytes.errs.model.Product;
import com.bytes.errs.model.Reward;
import com.bytes.errs.model.Transaction;
import com.bytes.errs.model.User;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public RoleRepository roleRepository;

	@Autowired
	private RewardRepository rewardRepo;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private TransactionDao transactionDto;
	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private JwtUtil jwtUtil;

	public boolean isUsernameExists(String username) {
	    return userRepository.existsByUserName(username);
	}

	public ResponseEntity<String> registerNewUser(User user) {
	    try {
	        if (isUsernameExists(user.getUserName())) {
	            throw new UsernameAlreadyExistsException("Username already exists");
	        }
	        String hashedPassword = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt());
//	        String hashedPassword = Utility.getHashedString(user.getUserPassword());
	        user.setUserPassword(hashedPassword);
	        userRepository.save(user);
	        return ResponseEntity.ok("User registered successfully");
	    } 
	    
	    catch (UsernameAlreadyExistsException e) {
//            throw new UsernameAlreadyExistsException("Username already exists");

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
	    }
	    catch(Exception e) {
	    	return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Service not Available");
	    }
	    
	}

	public void initRoleAndUser() {

		// Role adminRole = new Role();
		// adminRole.setRoleName("Admin");
		// adminRole.setRoleDescription("Admin role");
		// roleRepository.save(adminRole);
		//
		// Role userRole = new Role();
		// userRole.setRoleName("User");
		// userRole.setRoleDescription("Default role");
		// roleRepository.save(userRole);

	}

	public List<User> getAllProducts() {
		return userRepository.findAll();
	}

	public ResponseEntity<Object> addReward(UserReward userReward) {

		Long userId = userReward.getUserId();
		Long rewardId = userReward.getRewardId();
		User user = userRepository.findById(userId).get();
		Reward reward = rewardRepo.findById(rewardId).get();
		Set<Reward> RewardSet = user.getRewards();
		RewardSet.add(reward);
		Integer rewardPoint = reward.getByteValue();
		System.out.println(rewardPoint);
		Integer currentByte = user.getCurrentBytes();
		System.out.println(currentByte);
		currentByte += rewardPoint;
		user.setCurrentBytes(currentByte);
		Integer totalBytes = user.getTotalBytes();
		totalBytes += rewardPoint;
		user.setTotalBytes(totalBytes);
		Set<User> userSet = reward.getUsers();
		userReward.setTimestamp(LocalDateTime.now());
		userSet.add(user);
		reward.setUsers(userSet);
		userRepository.save(user);
		rewardRepo.save(reward);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Rewards added successfully");
		Transaction transaction = new Transaction();
		transaction.setItemId(rewardId);
		transaction.setTransactionType("Credit");
		transaction.setUser(user);
		transaction.setByteValue(rewardPoint);
		transactionDto.save(transaction);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	public ResponseEntity<Object> addBulkReward(List<Long> userIds, Long rewardId) {
		Map<String, String> response = new HashMap<>();
		Reward reward = rewardRepo.findById(rewardId).orElse(null);
		if (reward == null) {
			response.put("error", "Reward not found");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		for (Long userId : userIds) {
			// Get the user based on the current userId
			User user = userRepository.findById(userId).orElse(null);

			// Check if the user exists
			if (user == null) {
				// If the user does not exist, add an error message to the response map
				response.put("error", "User with ID " + userId + " not found");
			} else {
				// Add the reward to the user's set of rewards
				user.getRewards().add(reward);

				// Update user's current bytes and total bytes
				Integer rewardPoint = reward.getByteValue();
				user.setCurrentBytes(user.getCurrentBytes() + rewardPoint);
				user.setTotalBytes(user.getTotalBytes() + rewardPoint);

				// Add the user to the reward's set of users
				reward.getUsers().add(user);

				// Save the updated user and reward entities
				userRepository.save(user);
				rewardRepo.save(reward);

				// Create a new transaction for the user
				Transaction transaction = new Transaction();
				transaction.setItemId(rewardId);
				transaction.setTransactionType("Credit");
				transaction.setUser(user);
				transaction.setByteValue(rewardPoint);
				transactionDto.save(transaction);
			}
		}

		// Add a success message to the response map
		response.put("message", "Rewards added successfully to all users");

		// Return the response map with an HTTP status of OK
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ResponseEntity<?> addProduct(UserProduct userProduct) {
		Long userId = userProduct.getUserId();
		Long productId = userProduct.getProductId();

		User user = userRepository.findById(userId).orElse(null);
		Product product = productRepository.findById(productId).orElse(null);

		Set<User> userSet = product.getUsers();
		userSet.add(user);

		Set<Product> productSet = user.getProducts();
		productSet.add(product);

		if (user == null || product == null) {
			return new ResponseEntity<>("User or Product not found", HttpStatus.NOT_FOUND);
		}

		Integer pointsInBytes = product.getPointsInBytes();
		if (user.getCurrentBytes() < pointsInBytes) {
			return new ResponseEntity<>("Insufficient bytes to buy the product", HttpStatus.BAD_REQUEST);
		}

		if (product.getQuantityAvailable() < 1) {
			return new ResponseEntity<>("Product is out of stock", HttpStatus.BAD_REQUEST);
		}
		user.setCurrentBytes((int) (user.getCurrentBytes() - pointsInBytes));

		Integer quantityAvailable = product.getQuantityAvailable();
		product.setQuantityAvailable(quantityAvailable - 1);
		user.getProducts().add(product);
		userRepository.save(user);

		Map<String, String> response = new HashMap<>();
		response.put("message", "Product Bought successfully");

		Transaction transaction = new Transaction();

		transaction.setItemId(productId);
		transaction.setTransactionType("Debit");
		transaction.setUser(user);
		transaction.setByteValue(pointsInBytes);
		transactionDto.save(transaction);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public List<Transaction> getAllTransactions() {
		return transactionDao.findAll();
	}

	public void setUserRepository(UserRepository userRepositoryMock) {
		// TODO Auto-generated method stub
		
	}

	public User findByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

	

	 public void updatePassword(String username, String newPassword) throws UserNotFoundException {
	        User user = userRepository.findByUserName(username);
	        if (user == null) {
	            throw new UserNotFoundException("User not found");
	        }

	        // Hash the new password
	        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

	        // Update the user's password
	        user.setUserPassword(hashedPassword);

	        // Save the updated user object back to the database
	        userRepository.save(user);
	    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
