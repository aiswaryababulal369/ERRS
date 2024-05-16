package com.bytes.errs.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.bytes.errs.model.Image;
import com.bytes.errs.model.Product;

@Service
public interface ProductService {

	Product addNewProduct(Product product);

	List<Product> getAllProducts();

	void deleteProduct(Long productId);


	Product getProductById(Long productId);

	Product updateProduct(Long productId, Product updatedProduct, Set<Image> updatedImages);

}
