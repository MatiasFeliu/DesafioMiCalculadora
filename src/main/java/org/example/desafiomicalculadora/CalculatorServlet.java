import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1Str = request.getParameter("numero1");
        String num2Str = request.getParameter("numero2");
        String operacion = request.getParameter("operacion");

        try {
            // Validar que los parámetros num1 y num2 no sean nulos ni vacíos
            if (num1Str == null || num1Str.trim().isEmpty() || num2Str == null || num2Str.trim().isEmpty()) {
                throw new IllegalArgumentException("Ingrese números válidos.");
            }

            float num1 = Float.parseFloat(num1Str);
            float num2 = Float.parseFloat(num2Str);
            float resultado = 0;

            switch (operacion) {
                case "suma":
                    resultado = num1 + num2;
                    break;
                case "resta":
                    resultado = num1 - num2;
                    break;
                case "multiplicacion":
                    resultado = num1 * num2;
                    break;
                case "division":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        throw new ArithmeticException("No se puede dividir por cero");
                    }
                    break;
                case "ordenar":
                    // Ordenar números en orden ascendente
                    float[] numeros = {num1, num2};
                    Arrays.sort(numeros);
                    resultado = numeros[0]; // Tomamos el menor número después de ordenar
                    request.setAttribute("numeros", numeros);
                    request.setAttribute("Mensaje", "Números ordenados de forma ascendente: ");
                    break;
                case "parimpar":
                    // Validar que num1 sea un número válido para determinar si es par o impar
                    if (num1 % 1 != 0) {
                        throw new IllegalArgumentException("El número debe ser entero para determinar par o impar.");
                    }
                    String mensajeParImpar = num1 % 2 == 0 ? "El primer número es par." : "El primer número es impar.";
                    resultado = num1; // Solo necesitamos mostrar si es par o impar, no afecta al resultado final
                    request.setAttribute("mensaje", mensajeParImpar);
                    break;

                default:
                    throw new IllegalArgumentException("Operación no válida");
            }

            // Enviar el resultado a la página de respuesta según la operación
            request.setAttribute("resultado", resultado);
            request.getRequestDispatcher("resultado.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // Enviar a página de error si ocurre un error en la conversión de números
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            // Enviar a página de error si los datos no son válidos
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
