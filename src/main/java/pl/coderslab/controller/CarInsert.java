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
import java.util.Enumeration;
import java.util.List;

@WebServlet("/carInsert")
public class CarInsert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Enumeration<String> en = request.getParameterNames(); en.hasMoreElements();)
            System.out.println(en.nextElement());
        boolean result = CarDao.insCar(
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
            List<Car> cars = CarDao.getCars();
            request.setAttribute("cars", cars);
            getServletContext().getRequestDispatcher("/cars.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/car_insert.jsp").forward(request, response);
    }
}
