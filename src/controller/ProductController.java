package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Basket;
import domain.Product;
import domain.Review;
import service.ProductService;

public class ProductController implements Controller{

	private final ProductService productService = new ProductService();
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {		
		ModelAndView modelAndView = new ModelAndView();
		
		if(url.equals("/product/list")) {
			String category = request.getParameter("category");
			
			ArrayList<Product> products = productService.getCategoryList(category);
			
			
			modelAndView.setViewName("product/product-list");
			modelAndView.getModel().put("products", products);
			request.setAttribute("category", category);
			
		} else if (url.equals("/product/detail")) {
			if(request.getMethod().equals("GET")) {	
				String productName = request.getParameter("productName");
				ArrayList<Product> productList = null;
				// 창 열때
				ArrayList<Review> productReview = null;
				// 클릭한 상품 ID 가져와야됨
				Product product = new Product();
				product.setName(productName);	// 상품 받아와야함
				
				
				productList = productService.findProduct(product);
				productReview = productService.findReview(product);
				
				modelAndView.setViewName("product/detail");
				
				modelAndView.getModel().put("detail", productList);
				modelAndView.getModel().put("review", productReview);
				
				
			}
			else if (request.getMethod().equals("POST")) {
				Basket basket = new Basket();
				
				basket.setProductName(request.getParameter("product_name"));
				basket.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				basket.setPrice(Integer.parseInt(request.getParameter("price")));
				basket.setMemberId("jun");	// id 받아와야함.
				
//				System.out.println(basket.toString());
				productService.insert_basket(basket);
				
				modelAndView.setViewName("main");
			}
			
			
				
		} 
		
		else {
			modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return modelAndView;
	}
}
