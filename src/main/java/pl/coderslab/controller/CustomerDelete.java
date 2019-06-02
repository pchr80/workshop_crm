package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customerDelete")
public class CustomerDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = CustomerDao.delCustomer(id);
        // if (actOrders != null) {
        // request.setAttribute("order", order);
        if (!result) {
            response.sendError(500, OrderDao.errorMessage);
        } else {
            getServletContext().getRequestDispatcher("/customers").forward(request, response);
        }
    }
}
