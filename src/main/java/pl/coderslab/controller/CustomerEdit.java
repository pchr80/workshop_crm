package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.OrderExt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

@WebServlet("/customerEdit")
public class CustomerEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Enumeration<String> en = request.getParameterNames(); en.hasMoreElements();)
            System.out.println(en.nextElement());
        boolean result = CustomerDao.updCustomer(Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("surname"),
                Date.valueOf(request.getParameter("birth_date"))
                );
        if (!result) {
            response.sendError(500, CustomerDao.errorMessage);
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            Customer customer = CustomerDao.getCustomerDetails(id);
            request.setAttribute("customer", customer);
            getServletContext().getRequestDispatcher("/customer_edit.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = CustomerDao.getCustomerDetails(id);
        request.setAttribute("customer", customer);
        getServletContext().getRequestDispatcher("/customer_edit.jsp").forward(request, response);
    }
}
