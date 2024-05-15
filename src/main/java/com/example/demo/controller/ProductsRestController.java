package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Products;
import com.example.demo.service.ProductsService;


@CrossOrigin(origins ="null", allowedHeaders = "*")
@RestController
@RequestMapping("/prd")
public class ProductsRestController {
	
	@Autowired
	ProductsService productsService;

	@GetMapping("/products")
	private List<Products> getAllProducts() {
		return productsService.getAllProducts();
	}
	
	@PostMapping("/product_save")
	private Products saveProduct(@RequestBody Products products) {
		productsService.saveOrUpdate(products);
		return products;
	}
	

	@GetMapping("/product/{product_id}")
	private Products getProduct(@PathVariable("product_id") int product_id) {
		return productsService.getProductsById(product_id);
	}
	
	
	
	
	@DeleteMapping("/product/{product_id}")
	private void deleteProducts(@PathVariable("product_id") int product_id) {
		productsService.delete(product_id);
	}
	
	


	    @PutMapping("/addtocart/{productid}/{cartid}")
	    public ResponseEntity<?> addToCart(@PathVariable int productid, @PathVariable int cartid) {
	        return ResponseEntity.ok(productsService.addProductToCart(productid, cartid));
	    }

	    @DeleteMapping("/removefromcart/{productid}/{cartid}")
	    public ResponseEntity<?> removeFromCart(@PathVariable int productid, @PathVariable int cartid) {
	        return ResponseEntity.ok(productsService.removeProductFromCart(productid, cartid));
	    }
	
	

	
}
