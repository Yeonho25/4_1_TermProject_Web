package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.BasketRepository;
import persistence.MemberRepository;

@WebServlet("/front/MainController")

public class MainController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pName = request.getParameter("pName");
		String userId = request.getParameter("userId");
		String pw = request.getParameter("passWord");
		int price = 0;
		if (request.getParameter("price") != null)
			price = Integer.parseInt(request.getParameter("price"));

		try {
			if (request.getParameter("button") != null) {
				BasketRepository.deleteData(id, pName);
				request.getRequestDispatcher("view/basket/basket.jsp").forward(request, response);
			} else if (request.getParameter("calculation") != null) {
				BasketRepository.calculator(id, price);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}  else
				request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

