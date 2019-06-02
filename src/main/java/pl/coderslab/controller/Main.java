package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  int numberOfSolutions = Integer.parseInt(getServletContext().getInitParameter("number-of-solutions"));
        List<Order> actOrders = OrderDao.getOrders("REPR");
        // if (actOrders != null) {
        request.setAttribute("actOrders", actOrders);
        getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
        // } else {
        //     response.sendError(500, "Blad bazy danych");
        // }
    }
}
