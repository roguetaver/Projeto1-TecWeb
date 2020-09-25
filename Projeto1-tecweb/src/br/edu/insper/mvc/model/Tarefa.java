package br.edu.insper.mvc.model;

import java.util.Calendar;

public class Tarefa {
	
	private Integer id;
	private String tarefa;
	private Calendar data;
	private String criador;
	private String categoria;
	
	
	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getTarefa() {return this.tarefa;}
	public void setTarefa(String tarefa) {this.tarefa = tarefa;}
	
	public String getCriador() {return this.criador;}
	public void setCriador(String criador) {this.criador = criador;}
	
	public Calendar getData() {return this.data;}
	public void setData(Calendar data) {this.data = data;}
	
	public String getCategoria() {return this.categoria;}
	public void setCategoria(String categoria) {this.categoria = categoria;}
	

}
