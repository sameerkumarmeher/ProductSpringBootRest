package com.globallogic;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.globallogic.dto.ProductDto;
import com.globallogic.modal.Product;
import com.globallogic.repository.ProductRepository;
import com.globallogic.service.IProductService;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductSpringrestApplicationTests {

	@Autowired
	private IProductService productService;

	@MockBean
	private ProductRepository productRepository;

	/**
	 * Tests get product by ID
	 */
	@Test
	public void testGetProductById() {

		int id = 11;
		Optional<Product> product = Optional.of(new Product(11, "Mouse", "Electronice", 999));
		ProductDto productDto = new ProductDto(11, "Mouse", "Electronice", 999);
		
		when(productRepository.findById(id)).thenReturn(product);
		ProductDto productDto1 = productService.getProductById(id);
		assertEquals(productDto1.getName(), productDto.getName());
		assertEquals(productDto1.getDepartment(),productDto.getDepartment());
		assertEquals(productDto1.getPrice(),productDto.getPrice(),0.00);
	}

	/**
	 * Tests deletes product
	 */
	@Test
	public void testDeleteProductById() {
		
		Optional<Product> product1 = Optional.of(new Product(13, "Mobile", "Electronics", 14999));
		when(productRepository.findById(13)).thenReturn(product1);
		productService.deleteProductById(product1.get().getId());
	}


}
