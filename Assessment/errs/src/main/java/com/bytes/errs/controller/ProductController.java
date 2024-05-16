package com.bytes.errs.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bytes.errs.model.Image;
import com.bytes.errs.model.Product;
import com.bytes.errs.service.ProductService;
import com.bytes.errs.serviceImpl.ProductServeImpl;

@RestController
@RequestMapping(value = "product")
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addNewProduct" )
	public Product addProduct( @RequestParam("file") MultipartFile[] file,

			@RequestPart("product") Product product) {	
		productService = new ProductServeImpl();
		try {
			Set<Image> images =uploadImage(file);
			product.setProductImages(images);
			return productService.addNewProduct(product);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Set<Image> uploadImage(MultipartFile[] multipartFiles) {
		Set<Image> images =new HashSet<>();
		
		for(MultipartFile file:multipartFiles) {
			try {
				Image image = new Image();
				image.setImageName(file.getOriginalFilename());
				image.setImageType(file.getContentType());
				image.setImageByte(file.getBytes());
				images.add(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
		return images;		
				
	}
	
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
		
	}
	
	
	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteProduct(@PathVariable Long productId) {
		 productService.deleteProduct(productId);
	}
	
	@PutMapping("updateproduct/{productId}")
	public Product updateProduct(@PathVariable Long productId,@RequestParam("file") MultipartFile[] files,@RequestPart("product") Product updatedProduct) {
		try {
            Set<Image> updatedImages = uploadImage(files);
            return productService.updateProduct(productId, updatedProduct, updatedImages);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	@GetMapping("/getProductById/{productId}")
	public Product getProductById(@PathVariable Long productId) {
		 return productService.getProductById(productId);
	}
}
