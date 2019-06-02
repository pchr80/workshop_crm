package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
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

@WebServlet("/customerInsert")
public class CustomerInsert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Enumeration<String> en = request.getParameterNames(); en.hasMoreElements();)
            System.out.println(en.nextElement());
        boolean result = CustomerDao.insCustomer(
                request.getParameter("name"),
                request.getParameter("surname"),
                Date.valueOf(request.getParameter("birth_date"))
                );
        if (!result) {
            response.sendError(500, CustomerDao.errorMessage);
        } else {
            List<Customer> customers = CustomerDao.getCustomers();
            request.setAttribute("customers", customers);
            getServletContext().getRequestDispatcher("/customers.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/customer_insert.jsp").forward(request, response);
    }
}
