<%--
  Created by IntelliJ IDEA.
  User: matia
  Date: 01-07-2024
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado</title>
</head>
<body>
<h1>Resultado</h1>
<p><%= request.getAttribute("mensaje") %></p>
<p>El resultado es: <%= request.getAttribute("resultado") %></p>

<%-- Mostrar números ordenados si existe el atributo --%>
<% float[] numeros = (float[]) request.getAttribute("numeros"); %>
<% if (numeros!= null && numeros.length > 0) { %>
<p>Números ordenados:
    <% for (float numero : numeros) { %>
    <%= numero %>
    <% } %>
</p>
<% } %>

</body>
</html>
