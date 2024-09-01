package com.firstAPI.eComApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.firstAPI.eComApi.entity.Product;

public interface ProductsRepository extends JpaRepository<Product,Integer> {
    
	@Procedure(procedureName = "product_search" )
	List<Product> dbSearchProducts(@Param("search_text") String searchText );
}
