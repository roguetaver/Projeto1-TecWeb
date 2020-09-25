<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, br.edu.insper.mvc.controller.* ,  br.edu.insper.mvc.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>atualizar</title>
<link href="style.css" rel="stylesheet"/>
</head>
<body>

<form action='Atualiza' method='post' class="forms">
Tarefa: <input type='text' name= 'tarefa' value='${param.tarefa}' class="input"><br>
Data: <input type='text' name='data' value= '${param.data}' class="input"><br>
Criador: <input type='text' name='criador' value='${param.criador}' class="input">
<p> Categoria </p>
<select name="categoria" id="cars" class="select1">
	  <option value="Pessoal">Pessoal</option>
	  <option value="Profissional">Profissional</option>
</select>

<input type='hidden' name='categoria' value=categoria.value>
<input type='hidden' name='id' value='${param.id}'>
<br>
<input type='submit' value='atualizar' class="button edit">
</form>

</body>
</html>