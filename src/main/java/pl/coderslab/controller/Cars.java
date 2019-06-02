package pl.coderslab.controller;

import pl.coderslab.dao.CarDao;
import pl.coderslab.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class Cars extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("customer_id") != null) {
            int custId = Integer.parseInt(request.getParameter("customer_id"));
            List<Car> cars = CarDao.getCarsCustId(custId);
            request.setAttribute("cars", cars);
        } else {
            List<Car> cars = CarDao.getCars();
            request.setAttribute("cars", cars);
        }
        getServletContext().getRequestDispatcher("/cars.jsp").forward(request, response);
    }
}
