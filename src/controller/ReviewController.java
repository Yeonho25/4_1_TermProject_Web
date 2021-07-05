package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.History;
import domain.Member;
import domain.Review;
import service.HistoryService;
import service.ReviewService;

public class ReviewController implements Controller {
	private final ReviewService reviewService = new ReviewService();
	private final HistoryService historyService = new HistoryService();
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if (url.equals("/review/review"))
		{
			Review review = new Review();
				
			review.setHistory_id(Integer.valueOf(request.getParameter("id")));
			
			modelAndView.getModel().put("review", review);
			modelAndView.setViewName("review/review");
			
		} else if (url.equals("/review/insert"))
		{
			Review review = new Review();
			
			review.setHistory_id(Integer.valueOf(request.getParameter("id")));
			review.setContent(request.getParameter("content"));
			review.setRating(Float.valueOf(request.getParameter("rating")));
			
			reviewService.insertReview(review);
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/History/history.jsp");
//			dispatcher.forward(request, response);
//			ArrayList<History> historyList = null;
//			
//			Member member = new Member();
//			member.setId("root");	// 로그인시 아이디 받아와야함
//			
//			historyList = historyService.findHistory(member);
//			
//			modelAndView.getModel().put("history", historyList);
//			modelAndView.setViewName("History/history");
		}
		return modelAndView;
	}
	
}
