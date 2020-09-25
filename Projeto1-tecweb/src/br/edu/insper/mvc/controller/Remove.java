package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;


/**
 * Servlet implementation class Remove
 */
@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	 protected void doGet(HttpServletRequest request,HttpServletResponse response)
	 throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/removeform.html");
		//dispatcher.forward(request, response); 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	@Override
	 protected void doPost(HttpServletRequest request,HttpServletResponse response)
	 throws ServletException, IOException {
		
		 DAO dao = new DAO();
		try {
			dao.remove(Integer.valueOf(request.getParameter("id")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		RequestDispatcher dispatcher = request.getRequestDispatcher("Visualiza");
		dispatcher.forward(request, response); 
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 	 
		 
		 
		 
	 }

}
