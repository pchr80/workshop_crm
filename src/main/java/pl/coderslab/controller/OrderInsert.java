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
import java.sql.Date;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/orderInsert")
public class OrderInsert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        for (Enumeration<String> en = request.getParameterNames(); en.hasMoreElements();)
            System.out.println(en.nextElement());
        boolean result = OrderDao.insOrder(
                Integer.parseInt(request.getParameter("car_id")),
                Integer.parseInt(request.getParameter("employee_id")),
                Date.valueOf(request.getParameter("receive_date")),
                Date.valueOf(request.getParameter("planned_start_date")),
                Date.valueOf(request.getParameter("start_date")),
                Date.valueOf(request.getParameter("end_date")),
                request.getParameter("problem_desc"),
                request.getParameter("repair_desc"),
                request.getParameter("status_code"),
                Double.parseDouble(request.getParameter("repair_price")),
                Double.parseDouble(request.getParameter("parts_price")),
                Double.parseDouble(request.getParameter("man_hour")),
                Double.parseDouble(request.getParameter("work_hours"))
        );
        if (!result) {
            response.sendError(500, OrderDao.errorMessage);
        } else {

             List<Order> orders = OrderDao.getOrders("ALL");
             request.setAttribute("actOrders", orders);
             getServletContext().getRequestDispatcher("/orders.jsp").forward(request, response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/order_insert.jsp").forward(request, response);
    }
}
