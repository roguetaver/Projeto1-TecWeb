package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tarefa;


/**
 * Servlet implementation class Atualiza
 */
@WebServlet("/Atualiza")
public class Atualiza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("atualizaform.html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/atualiza.jsp");
		dispatcher.forward(request, response); 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		DAO dao = new DAO();
		
		Tarefa tarefa = new Tarefa();
		tarefa.setId(Integer.valueOf(request.getParameter("id")));
		tarefa.setTarefa(request.getParameter("tarefa"));
		tarefa.setCriador(request.getParameter("criador"));
		tarefa.setCategoria(request.getParameter("categoria"));
		
		String nascimento = request.getParameter("data");
		Date data = null;
		try {
			data = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);
		tarefa.setData(dataNascimento);
		
		
		try {
			dao.altera(tarefa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Visualiza");
		dispatcher.forward(request, response);
		//response.sendRedirect("/Projeto1-tecweb/Visualiza");
	}

}
