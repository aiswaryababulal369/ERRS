package com.bytes.errs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytes.errs.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String username);

	boolean existsByUserName(String username);

//	User findByEmailId(String emailId);

}
