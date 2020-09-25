package br.edu.insper.mvc.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {
	private Connection connection = null;
	public DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto1?serverTimezone=UTC", "root", "hank12345");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Tarefa> getLista() throws SQLException {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		Statement stmt = connection.createStatement();
        //String sql = "SELECT * FROM tarefasplus ";
        String sql = "SELECT * FROM tarefasplus WHERE categoria='Profissional' ORDER BY data ASC";
        ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getInt("id"));
			tarefa.setTarefa(rs.getString("tarefa"));
			tarefa.setCriador(rs.getString("criador"));
			tarefa.setCategoria(rs.getString("categoria"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			
			
			tarefas.add(tarefa);
		}

		rs.close();
		stmt.close();
		
		return tarefas;
		
	}
	
	public List<Tarefa> getListaPessoal() throws SQLException {
		List<Tarefa> tarefas1 = new ArrayList<Tarefa>();
		Statement stmt = connection.createStatement();
        //String sql = "SELECT * FROM tarefasplus ";
        String sql = "SELECT * FROM tarefasplus WHERE categoria='Pessoal' ORDER BY data ASC";
        ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getInt("id"));
			tarefa.setTarefa(rs.getString("tarefa"));
			tarefa.setCriador(rs.getString("criador"));
			tarefa.setCategoria(rs.getString("categoria"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			
			
			tarefas1.add(tarefa);
		}

		rs.close();
		stmt.close();
		
		return tarefas1;
		
	}
	
	public void close() throws SQLException {
			connection.close();
	}
	
	public void adiciona(Tarefa tarefa) throws SQLException {
		//String sql = "INSERT INTO tarefasplus" + " ( tarefa ) values(?)";
		String sql = "INSERT INTO tarefasplus" + " (tarefa,data,criador,categoria) values(?,?,?,?)" ;
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,tarefa.getTarefa());
		stmt.setDate(2, new java.sql.Date(tarefa.getData().getTimeInMillis()));
		stmt.setString(3, tarefa.getCriador());	
		stmt.setString(4, tarefa.getCategoria());
		stmt.execute();
		stmt.close();
		}
	
	
	public void altera(Tarefa tarefa) throws SQLException {
		//String sql = "UPDATE tarefasplus SET " + "tarefa=? WHERE id=?";
		String sql = "UPDATE tarefasplus SET " + "tarefa=?, data=?, criador=?, categoria=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getTarefa());
		stmt.setDate(2, new java.sql.Date(tarefa.getData().getTimeInMillis()));
		stmt.setString(3, tarefa.getCriador());	
		stmt.setString(4, tarefa.getCategoria());
		stmt.setInt(5, tarefa.getId());		
		stmt.execute();
		stmt.close();
		}
	
	
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM tarefasplus WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		}
	
}


