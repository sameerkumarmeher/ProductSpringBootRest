package com.globallogic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.dto.ProductDto;
import com.globallogic.exceptions.IdNotFoundException;
import com.globallogic.exceptions.ProductNotFoundException;
import com.globallogic.modal.Product;
import com.globallogic.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{

	Log log = LogFactory.getLog(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;
	
	/*
	 * 
	 * @Description : this method is used to add new Product details
	 * @Param: It takes product type as paramter
	 * @returns : It returns Product object
	 * @throws :
	 * @Created by : Manisha Kumari
	 * @createdDate : 31st October 2022
	 *  
	 */
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		if(productDto.getPrice() < 0) {
			log.error("Price cannot be lessthan or equal to zero");
			throw new ArithmeticException("Price should be more than or equal to zero");}
		else if(productDto.getName() == null) {
			log.error("Name should not be null");
			throw new NullPointerException("Name should not be null");
		}
		else if(productDto.getDepartment() == null) {
			log.error("Department should not be null");
			throw new NullPointerException("Department should not be null");}
		else if (!(productDto.getId() >0 )) {
			log.error("Id should be a positive integer");
			throw new NumberFormatException("Id should be a positive integer");}
		
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setDepartment(productDto.getDepartment());
		product.setPrice(productDto.getPrice());
		
		log.info("Adding product to database");
		productRepository.save(product);
		return productDto;
	}
	

	/*
	 * 
	 * @Description : this method is used to get all the details of  Product 
	 * @returns : It returns All the product details which is available in the db
	 * @throws :
	 * @Created by : Manisha Kumari
	 * @createdDate : 31st October 2022
	 *  
	 */
	@Override
	public List<ProductDto> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> productOptional =  productRepository.findAll();
		if(productOptional.isEmpty())
			throw new ProductNotFoundException("Product List is Empty");
		log.info("Retrived All Products from Database");
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for(Product product : productOptional) {
			ProductDto prod = new ProductDto();
			prod.setId(product.getId());
			prod.setName(product.getName());
			prod.setDepartment(product.getDepartment());
			prod.setPrice(product.getPrice());
			productDtos.add(prod);
		}
		return productDtos;
	}


	/*
	 * 
	 * @Description : this method is used to get  Product details
	 * @Param: It takes product id as paramter
	 * @returns : It returns Product details which matches with the id
	 * @throws :
	 * @Created by : Manisha Kumari
	 * @createdDate : 31st October 2022
	 *  
	 */
	@Override
	public ProductDto getProductById(int id) {
		// TODO Auto-generated method stub
		ProductDto productDto = new ProductDto();
		log.info("Get Product by product id");
		Optional<Product> productOptional = productRepository.findById(id);
		if(productOptional.isEmpty())
			throw new IdNotFoundException("No Id Present for get");
		else if (!(id >0 ))
			throw new NumberFormatException("Id should be a positive integer");
		Product product = productOptional.get();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setDepartment(product.getDepartment());
		productDto.setPrice(product.getPrice());
		return productDto;
	}
	

	/*
	 * 
	 * @Description : this method is used to delete existing Product details
	 * @Param: It takes product id as paramter
	 * @returns : It returns nothing and deleted the existing product details which users want to delete
	 * @throws :
	 * @Created by : Manisha Kumari
	 * @createdDate : 31st October 2022
	 *  
	 */
	@Override
	public void deleteProductById(int id) {
		log.info("Getting product with ID " + id + " to delete");
		ProductDto productDto = new ProductDto();
		Optional<Product> productOptional = productRepository.findById(id);
		if (!(id >0 ))
			throw new NumberFormatException("Id should be a positive integer");
		else if(productOptional.isEmpty())
			throw new IdNotFoundException("No Id Present for delete");
		log.info("Deleted product with ID " +productOptional.get());
		productRepository.deleteById(id);
	}

}
