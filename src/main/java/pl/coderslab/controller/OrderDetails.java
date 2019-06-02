package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;
import pl.coderslab.model.OrderExt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderDetails")
public class OrderDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderExt order = OrderDao.getOrderDetails(id);
        // if (actOrders != null) {
        request.setAttribute("order", order);
        getServletContext().getRequestDispatcher("/order_details.jsp").forward(request, response);
    }
}
