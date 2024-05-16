package com.bytes.errs.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytes.errs.dao.ProductRepository;
import com.bytes.errs.model.Image;
import com.bytes.errs.model.Product;
import com.bytes.errs.service.ProductService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServeImpl implements ProductService {
	
	@Autowired
	public ProductRepository productRepository;
	
	

	@Override
	public Product addNewProduct(Product product) {
		return productRepository.save(product);
	}



	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}



	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
		
	}


	
	@Override
	public Product getProductById(Long productId) {
		Optional<Product> productOptional = productRepository.findById(productId);
	    return productOptional.orElse(null);
			
	}



	@Override
	public Product updateProduct(Long productId, Product updatedProduct, Set<Image> updatedImages) {
		Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));
		
		product.setProductName(updatedProduct.getProductName());
		product.setProductDescription(updatedProduct.getProductDescription());
		product.setProductCategory(updatedProduct.getProductCategory());
		product.setManufacturer(updatedProduct.getManufacturer());
		product.setExpiryDate(updatedProduct.getExpiryDate());
		product.setQuantityAvailable(updatedProduct.getQuantityAvailable());
		product.setTermsandConditions(updatedProduct.getTermsandConditions());
		product.setFeaturedStatus(updatedProduct.getFeaturedStatus());
		product.setAvailabilityStatus(updatedProduct.getAvailabilityStatus());
		product.setAdditionalMetadata(updatedProduct.getAdditionalMetadata());
		product.setPointsInBytes(updatedProduct.getPointsInBytes());
		product.setProductImages(updatedImages);

        return productRepository.save(product);
	}
	


}
