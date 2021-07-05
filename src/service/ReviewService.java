package service;

import domain.Review;
import persistence.ReviewRepository;

public class ReviewService {
	private final ReviewRepository reviewRepository = new ReviewRepository();
	
	public void insertReview(Review review)
	{
		reviewRepository.insertReview(review);
	}
}
