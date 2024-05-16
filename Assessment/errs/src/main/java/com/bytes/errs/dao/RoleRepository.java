package com.bytes.errs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytes.errs.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
