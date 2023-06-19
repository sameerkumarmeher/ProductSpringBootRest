package com.globallogic.service;

import java.util.List;

import com.globallogic.dto.ProductDto;

public interface IProductService {

	public List<ProductDto> getAllProduct();

	public ProductDto getProductById(int id);

	public void deleteProductById(int id);

	public ProductDto addProduct(ProductDto productDto);

}
