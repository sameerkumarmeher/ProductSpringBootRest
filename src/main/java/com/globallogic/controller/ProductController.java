package com.globallogic.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.dto.ProductDto;
import com.globallogic.service.IProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	IProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<ProductDto> addNewProduct(@RequestBody ProductDto productDto) {
		return new ResponseEntity<ProductDto>( productService.addProduct(productDto),HttpStatus.OK);
	}
	
	@GetMapping(value = "/product")
	public ResponseEntity<List<ProductDto>> getAllProduct() {
		return new ResponseEntity<List<ProductDto>>(productService.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/product/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
		return new ResponseEntity<ProductDto>(productService.getProductById(id),HttpStatus.OK);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProductDetails(@RequestBody ProductDto productDto, @PathVariable int id) {
	// if the course already exists, update it
	productService.addProduct(productDto);
	return new ResponseEntity<String>("Product Details updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id) {
	 productService.deleteProductById(id);
	 return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
}
