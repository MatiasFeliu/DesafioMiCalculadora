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
                    break;
                case "parimpar":
                    // Determinar si num1 es par o impar
                    if (num1 % 2 == 0) {
                        resultado = 1; // Par
                    } else {
                        resultado = 0; // Impar
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Operación no válida");
            }

            // Enviar el resultado a la página de respuesta según la operación
            request.setAttribute("resultado", resultado);
            request.getRequestDispatcher("resultado.jsp").forward(request, response);

        } catch (ArithmeticException | IllegalArgumentException e) {
            // Enviar a página de error si ocurre un error en la operación
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}