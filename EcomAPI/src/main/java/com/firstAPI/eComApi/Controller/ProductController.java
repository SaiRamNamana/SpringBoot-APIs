package com.firstAPI.eComApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstAPI.eComApi.Pojo.SearchProductApiData;
import com.firstAPI.eComApi.entity.Product;
import com.firstAPI.eComApi.repository.ProductsRepository;

import jakarta.transaction.Transactional;

@RestController
public class ProductController {
    
	@Autowired
	ProductsRepository pr;
	
	@Transactional
	@PostMapping("/api/search")
	public ResponseEntity<List<Product>> SearchProducts(@RequestBody SearchProductApiData apiData) {
		
		
		List<Product> productList = pr.dbSearchProducts(apiData.getSearchText());
				
		return new ResponseEntity<>(productList,HttpStatus.OK);
		
	}
	
}
