package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Product;
import service.MemberService;

public class MemberController implements Controller {

	private final MemberService memberService = new MemberService();
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {		
		ModelAndView modelAndView = new ModelAndView();
		if(url.equals("/member/login")) {
			if(request.getMethod().equals("GET")) {	
				modelAndView.setViewName("member/login");
			}else if(request.getMethod().equals("POST")) {
				String memberID = request.getParameter("memberID");
				String memberPassword = request.getParameter("memberPassword");
				memberService.login(memberID, memberPassword);
				modelAndView.setViewName("main");
				HttpSession session = request.getSession();
				//request.getServletContext().setAttribute("memberID",memberID);
				session.setAttribute("memberID", memberID);
				modelAndView.setViewName("main");
				
			}
			
		}
		
		else {
			modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return modelAndView;
	}
	
}
