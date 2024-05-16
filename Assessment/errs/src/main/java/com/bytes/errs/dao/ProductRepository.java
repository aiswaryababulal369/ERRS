package com.bytes.errs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytes.errs.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
