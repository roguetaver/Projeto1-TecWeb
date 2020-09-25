package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tarefa;



@WebServlet("/Visualiza")
public class Visualiza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException {
			
		DAO dao = new DAO();
		
		List<Tarefa> tarefas = null;
		List<Tarefa> tarefas1 = null;
		try {
			tarefas = dao.getLista();	
			tarefas1 = dao.getListaPessoal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		request.setAttribute("tarefas",tarefas);
		request.setAttribute("tarefas1",tarefas1);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/lista.jsp");
		dispatcher.forward(request , response);
		

		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


