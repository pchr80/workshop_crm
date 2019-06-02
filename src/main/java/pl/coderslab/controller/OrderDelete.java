package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.OrderExt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderDelete")
public class OrderDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = OrderDao.delOrder(id);
        // if (actOrders != null) {
        // request.setAttribute("order", order);
        if (!result) {
            response.sendError(500, OrderDao.errorMessage);
        } else {
            getServletContext().getRequestDispatcher("/orders").forward(request, response);
        }
    }
}
