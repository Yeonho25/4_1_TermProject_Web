package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.History;
import domain.Member;
import domain.Paging;
import domain.Review;
import service.HistoryService;
import service.ReviewService;

public class HistoryController implements Controller {

	private final HistoryService historyService = new HistoryService();
	private final ReviewService reviewService = new ReviewService();
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		
		ModelAndView modelAndView = new ModelAndView();

		if (url.equals("/history/history"))
		{
			if (request.getMethod().equals("POST"))
			{
				Review review = new Review();
				
				review.setHistory_id(Integer.valueOf(request.getParameter("id")));
				review.setContent(request.getParameter("content"));
				review.setRating(Float.valueOf(request.getParameter("rating")));
				
				reviewService.insertReview(review);
			}
//			--------------------------
			
			int page=1;
			
			if (request.getParameter("page") != null)
			{
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			paging.setTotalCount(historyService.getTotalCount());
			
//			--------------------------
			
			ArrayList<History> historyList = null;
			
			Member member = new Member();
			member.setId("root");	// 로그인시 아이디 받아와야함
			
			historyList = historyService.findHistory(member, paging);
			request.setAttribute("paging", paging);
			
			modelAndView.setViewName("history/history");
			modelAndView.getModel().put("history", historyList);
			
			
		}else {
			modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		
		return modelAndView;
	}

}
