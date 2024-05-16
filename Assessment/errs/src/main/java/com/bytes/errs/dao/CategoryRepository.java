package com.bytes.errs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytes.errs.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
