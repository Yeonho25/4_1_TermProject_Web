package service;

import java.util.ArrayList;

import domain.Basket;
import domain.Product;
import domain.Review;
import persistence.ProductRepository;


public class ProductService {
	private final ProductRepository productRepository = new ProductRepository();
	public ProductService() {
		
	}
	
	public ArrayList<Product> getCategoryList(String category) {
		return productRepository.findCategoryAll(category);
	}
	
	public void insert_basket(Basket basket) {		
		productRepository.insert_basket(basket);
	}	
	public ArrayList<Review> findReview(Product product)
	{
		return productRepository.findReview(product);
	}
	public ArrayList<Product> findProduct(Product board)
	{
		return productRepository.findProduct(board);
	}
}
