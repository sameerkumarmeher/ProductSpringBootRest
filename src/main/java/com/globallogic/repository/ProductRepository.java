package com.globallogic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.modal.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
