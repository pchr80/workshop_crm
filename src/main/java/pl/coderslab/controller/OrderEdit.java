package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.OrderExt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;

@WebServlet("/orderEdit")
public class OrderEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        for (Enumeration<String> en = request.getParameterNames(); en.hasMoreElements();)
            System.out.println(en.nextElement());
        boolean result = OrderDao.updOrder(Integer.parseInt(request.getParameter("id")),
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

            int id = Integer.parseInt(request.getParameter("id"));
            OrderExt order = OrderDao.getOrderDetails(id);
            request.setAttribute("order", order);
            getServletContext().getRequestDispatcher("/order_edit.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderExt order = OrderDao.getOrderDetails(id);
        request.setAttribute("order", order);
        getServletContext().getRequestDispatcher("/order_edit.jsp").forward(request, response);
    }
}
