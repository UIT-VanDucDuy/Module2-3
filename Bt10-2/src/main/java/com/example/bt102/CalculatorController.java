package com.example.bt102;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calculate")
public class CalculatorController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
            double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
            String operator = request.getParameter("operator");

            double result;
            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand == 0) {
                        request.setAttribute("error", "Không thể chia cho 0!");
                        request.getRequestDispatcher("result.jsp").forward(request, response);
                        return;
                    }
                    result = firstOperand / secondOperand;
                    break;
                default:
                    request.setAttribute("error", "Phép toán không hợp lệ!");
                    request.getRequestDispatcher("result.jsp").forward(request, response);
                    return;
            }

            request.setAttribute("firstOperand", firstOperand);
            request.setAttribute("secondOperand", secondOperand);
            request.setAttribute("operator", operator);
            request.setAttribute("result", result);
            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Giá trị nhập không hợp lệ!");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}
