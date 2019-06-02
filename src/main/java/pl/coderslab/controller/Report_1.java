package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.Rep1Dao;
import pl.coderslab.model.Order;
import pl.coderslab.model.Rep1Mod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/report_1")
public class Report_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date dateFrom = Date.valueOf(request.getParameter("date_from"));
        Date dateTo = Date.valueOf(request.getParameter("date_to"));

        List<Rep1Mod> rep1List = Rep1Dao.getRep1(dateFrom, dateTo);
        request.setAttribute("rep1List", rep1List);
        getServletContext().getRequestDispatcher("/result_rep1.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/order_rep1.jsp").forward(request, response);
    }
}
