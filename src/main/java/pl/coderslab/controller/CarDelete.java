package pl.coderslab.controller;

import pl.coderslab.dao.CarDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/carDelete")
public class CarDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = CarDao.delCar(id);
        // if (actOrders != null) {
        // request.setAttribute("order", order);
        if (!result) {
            response.sendError(500, CarDao.errorMessage);
        } else {
            getServletContext().getRequestDispatcher("/cars").forward(request, response);
        }
    }
}
