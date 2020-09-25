<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, br.edu.insper.mvc.controller.* ,  br.edu.insper.mvc.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Tarefas</title>
<link href="style.css" rel="stylesheet"/>
</head>
<body>
<div>
<h1>  Tarefas Profissionais </h1>
	<ul class="lista">
		<c:forEach var="tarefa" items="${tarefas}">
			<li class="cont">
			
				<p> ${tarefa.tarefa}</p>
				<br>
				<p> ${tarefa.criador}</p>
				<br>
				<p> <fmt:formatDate value="${tarefa.data.time}" pattern="dd/MM/yyyy"/></p>
				<br>
				<p> ${tarefa.categoria}</p>
				<br>
				
				<form action='Remove' method='post'>
				<input type='hidden' name='id' value='${tarefa.id}'>
				<input type='submit' value='remover' class="button delete">
				</form>
				
				
				<form action='Atualiza' method='get'>
				<input type='hidden' name='id' value='${tarefa.id}'>
				<input type='hidden' name='tarefa' value='${tarefa.tarefa}'>
				<input type='hidden' name='data' value= <fmt:formatDate value="${tarefa.data.time}" pattern="dd/MM/yyyy"/>>
				<input type='hidden' name='criador' value='${tarefa.criador}'>
				<input type='hidden' name='categoria' value='${tarefa.categoria}'>
				<input type='submit' value='atualizar' class="button edit">
				</form>
			
			</li>
		</c:forEach>
	</ul>
	<h1>  Tarefas Pessoais </h1>
	<ul class="lista">
		<c:forEach var="tarefa1" items="${tarefas1}">
			<li class="cont">
			
				<p> ${tarefa1.tarefa}</p>
				<br>
				<p> ${tarefa1.criador}</p>
				<br>
				<p> <fmt:formatDate value="${tarefa1.data.time}" pattern="dd/MM/yyyy"/></p>
				<br>
				<p> ${tarefa1.categoria}</p>
				<br>
				
				<form action='Remove' method='post'>
				<input type='hidden' name='id' value='${tarefa1.id}'>
				<input type='submit' value='remover' class="button delete">
				</form>
				
				
				<form action='Atualiza' method='get'>
				<input type='hidden' name='id' value='${tarefa1.id}'>
				<input type='hidden' name='tarefa' value='${tarefa1.tarefa}'>
				<input type='hidden' name='data' value= <fmt:formatDate value="${tarefa1.data.time}" pattern="dd/MM/yyyy"/>>
				<input type='hidden' name='criador' value='${tarefa1.criador}'>
				<input type='hidden' name='categoria' value='${tarefa1.categoria}'>
				<input type='submit' value='atualizar' class="button edit">
				</form>
			
			</li>
		</c:forEach>
	</ul>
	
	<form action="Adiciona" method='post' class="forms">
		 <h1> Crie sua tarefa </h1> <br>
		 Tarefa :  <input type='text' name='tarefa' size="100" class="input"><br>
		 Data  :    <input type='text' name='data' size="100" class="input" ><br>
		 Criador: <input type='text' name='criador' size="100" class="input">
		 <p> Categoria: </p>
		 <select name="categoria" id="cars" class="select1">
			  <option value="Pessoal">Pessoal</option>
			  <option value="Profissional">Profissional</option>
		 </select>
		 <input type='hidden' name='categoria' value=categoria.value>
		 <br>
	<input type='submit' value='Submit' class="button add"> 
	</form>
</div>
</body>
</html>