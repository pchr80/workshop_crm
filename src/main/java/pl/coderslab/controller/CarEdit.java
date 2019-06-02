package pl.coderslab.controller;

import pl.coderslab.dao.CarDao;
import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Car;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/carEdit")
public class CarEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = CarDao.updCar(Integer.parseInt(request.getParameter("id")),
                Integer.parseInt(request.getParameter("customer_id")),
                request.getParameter("brand"),
                request.getParameter("model"),
                Integer.parseInt(request.getParameter("prod_year")),
                request.getParameter("reg_nr"),
                Date.valueOf(request.getParameter("review_date"))
                );
        if (!result) {
            response.sendError(500, CarDao.errorMessage);
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            Car car = CarDao.getCarDetails(id);
            request.setAttribute("car", car);
            getServletContext().getRequestDispatcher("/car_edit.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Car car = CarDao.getCarDetails(id);
        request.setAttribute("car", car);
        getServletContext().getRequestDispatcher("/car_edit.jsp").forward(request, response);
    }
}
