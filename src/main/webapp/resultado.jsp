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
<% int resultado = (int) request.getAttribute("resultado"); %>
<p>El resultado es: <%= resultado %></p>
</body>
</html>
