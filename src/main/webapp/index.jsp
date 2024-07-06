<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Calculadora</title>
  <link rel="stylesheet" href="css/picocss.min.css">
  <link rel="stylesheet" href="assets/styles.css">
  <!-- Otros estilos o referencias -->
  <style>

    .container {
      max-width: 500px;
      margin: 0 auto;
      padding: 20px;
    }
    .form-group {
      margin-bottom: 15px;
    }
  </style>

</head>
<body>
<div class="container">
  <h1 class="text-center">Calculadora</h1>
  <form action="CalculadoraServlet" method="POST" >
    <div class="form-group">
      <label for="numero1">Número 1:</label>
      <input type="number" name="numero1" placeholder="Ingrese primer numero" id="numero1" aria-label="Number"  class="form-input">
    </div>
    <div class="form-group">
      <label for="numero2">Número 2:</label>
      <input type="number" name="numero2" placeholder="Ingrese segundo numero" id="numero2" aria-label="Number"  class="form-input">
    </div>
    <div class="form-group">
      <label for="operacion">Operación:</label>
      <select id="operacion" name="operacion" class="form-select">
        <option value="suma">Suma</option>
        <option value="resta">Resta</option>
        <option value="multiplicacion">Multiplicación</option>
        <option value="division">División</option>
        <option value="ordenar">Ordenar número</option>
        <option value="parimpar">Par e Impar</option>
      </select>
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-primary">Calcular</button>
    </div>
  </form>
</div>
</body>
</html>