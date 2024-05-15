package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Products;
import com.example.demo.modal.cartitem;
import com.example.demo.repo.ProductsRepository;
import com.example.demo.repo.cartitemRepo;






@Service
@Transactional
public class ProductsService {
	final cartitemRepo cartitemRepo;

	final ProductsRepository productsRepository;

	@Autowired
	public ProductsService(ProductsRepository productsRepository, cartitemRepo cartitemRepo) {
		this.cartitemRepo = cartitemRepo;
		this.productsRepository = productsRepository;

	}

	public List<Products> getAllProducts() {
		List<Products> products = new ArrayList<Products>();
		productsRepository.findAll().forEach(product1 -> {
			products.add(product1);
		});
		
		return products;
	}

	public Products getProductsById(int product_id) {
		return productsRepository.findById(product_id).get();
	}

	public void saveOrUpdate(Products products) {
		productsRepository.save(products);
	}

	public void delete(int product_id) {
		productsRepository.deleteById(product_id);
	}
	
	public String addProductToCart(int productId, int cartId) {
		if (cartitemRepo.findById(cartId).isPresent()) {
			if (productsRepository.findById(productId).isPresent()) {
				Products product = productsRepository.getReferenceById(productId);
				cartitem cart = cartitemRepo.getReferenceById(cartId);
				if (!product.getAddedCarts().contains(cart)) {
					product.addProducts(cart);
					productsRepository.save(product);
					return "Product Added in cart Successfully";
				} else {
					return "Product Already in cart";
				}
			}
		}
		return "Product not found";
	}

	public String removeProductFromCart(int productId, int cartId) {
		Products product = productsRepository.getReferenceById(productId);
		cartitem cart = cartitemRepo.getReferenceById(cartId);
		product.removeProducts(cart);
		productsRepository.save(product);
		return "Product Removed from cart successfully";
	}




}