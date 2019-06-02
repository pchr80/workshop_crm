package pl.coderslab.dao;

import pl.coderslab.model.Order;
import pl.coderslab.model.OrderExt;
import pl.coderslab.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class OrderDao {

    public static String errorMessage = "";

    private static final String ACTUAL_ORDERS =
            "SELECT\n" +
                    "orders.id, \n" +
                    "orders.car_id,\n" +
                    "orders.employee_id,\n" +
                    "orders.start_date,\n" +
                    "orders.repair_desc\n" +
                    "FROM \n" +
                    "orders\n" +
                    "WHERE\n" +
                    "orders.status_code = ?\n" +
                    "OR ? = 'ALL'\n" +
                    "ORDER BY id";

    private static final String ORDER_DETAILS =
            "SELECT\n" +
                    "o.*, s.status_desc \n" +
                    "FROM \n" +
                    "orders o \n" +
                    "JOIN \n" +
                    "order_status s\n" +
                    "WHERE\n" +
                    "o.status_code = s.status_code\n" +
                    "AND o.id = ?";

    private static final String UPD_ORDER =
            "UPDATE orders SET\n" +
                    "car_id = ?,\n" +
                    "employee_id = ?,\n" +
                    "receive_date = ?,\n" +
                    "planned_start_date = ?,\n" +
                    "start_date = ?,\n" +
                    "end_date = ?,\n" +
                    "problem_desc = ?,\n" +
                    "repair_desc = ?,\n" +
                    "status_code = ?,\n" +
                    "repair_price = ?,\n" +
                    "parts_price = ?,\n" +
                    "man_hour = ?,\n" +
                    "work_hours = ?\n" +
                    "WHERE\n" +
                    "id = ?";

    private static final String DEL_ORDER =
            "delete\n" +
                    "from\n" +
                    "orders \n" +
                    "where\n" +
                    "id = ?";

    private static final String INS_ORDER =
            "INSERT INTO orders\n" +
                    "\t\t\t\t(   car_id,\n" +
                    "                    employee_id,\n" +
                    "                    receive_date,\n" +
                    "                    planned_start_date,\n" +
                    "                    start_date,\n" +
                    "                    end_date,\n" +
                    "                    problem_desc,\n" +
                    "                    repair_desc,\n" +
                    "                    status_code,\n" +
                    "                    repair_price,\n" +
                    "                    parts_price,\n" +
                    "                    man_hour,\n" +
                    "                    work_hours )\n" +
                    "VALUES\n" +
                    "(?, ?, ?, ?, ? ,? ,?, ?, ?, ?, ?, ?, ?)";

    public static List<Order> getOrders(String status_code) {
        try {
            List<Order> result = new ArrayList<>();
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(ACTUAL_ORDERS);
            stmt.setString(1, status_code);
            stmt.setString(2, status_code);
            ResultSet rs = stmt.executeQuery();
            while ((rs.next())) {
                int orderId = rs.getInt("id");
                int carId = rs.getInt("car_id");
                int employeeId = rs.getInt("employee_id");
                Date startDate = rs.getDate("start_date");
                String repairDesc = rs.getString("repair_desc");
                result.add(new Order(orderId, carId, employeeId, startDate, repairDesc));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static OrderExt getOrderDetails(int id) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(ORDER_DETAILS);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while ((rs.next())) {
                int orderId = rs.getInt("id");
                int carId = rs.getInt("car_id");
                int employeeId = rs.getInt("employee_id");
                Date receiveDate = rs.getDate("receive_date");
                Date plannedStartDate = rs.getDate("planned_start_date");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                String problemDesc = rs.getString("problem_desc");
                String repairDesc = rs.getString("repair_desc");
                String statusCode = rs.getString("status_code");
                double repairPrice = rs.getDouble("repair_price");
                double partsPrice = rs.getDouble("parts_price");
                double manHour = rs.getDouble("man_hour");
                double workHours = rs.getDouble("work_hours");
                String statusDesc = rs.getString("status_desc");
                return new OrderExt(orderId, carId, employeeId, receiveDate, plannedStartDate, startDate, endDate, problemDesc, repairDesc, statusCode, repairPrice, partsPrice, manHour, workHours, statusDesc);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

        public static boolean updOrder(int orderId, int carId, int employeeId, Date receiveDate, Date plannedStartDate, Date startDate, Date endDate, String problemDesc, String repairDesc, String statusCode, double repairPrice, double partsPrice, double manHour, double workHours) {
            try {
                Connection conn = DbUtil.getConn();
                PreparedStatement stmt = conn.prepareStatement(UPD_ORDER);
                stmt.setInt(1, carId);
                stmt.setInt(2, employeeId);
                stmt.setDate(3, receiveDate);
                stmt.setDate(4, plannedStartDate);
                stmt.setDate(5, startDate);
                stmt.setDate(6, endDate);
                stmt.setString(7, problemDesc);
                stmt.setString(8, repairDesc);
                stmt.setString(9, statusCode);
                stmt.setDouble(10, repairPrice);
                stmt.setDouble(11, partsPrice);
                stmt.setDouble(12, manHour);
                stmt.setDouble(13, workHours);
                stmt.setInt(14, orderId);
                int updated = stmt.executeUpdate();
                if (updated != 0) {
                    System.out.println("Zupdatowano " + updated + " wierszy");
                    return true;
                }
                else {
                    System.out.println("Zupdatowano 0 wierszy");
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                errorMessage = e.getMessage();
                return false;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }

    public static boolean delOrder(int orderId) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(DEL_ORDER);
            stmt.setInt(1, orderId);
            int deleted = stmt.executeUpdate();
            if (deleted != 0) {
                System.out.println("Usunieto " + deleted + " wierszy");
                return true;
            }
            else {
                System.out.println("Usunieto 0 wierszy");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorMessage = e.getMessage();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean insOrder(int carId, int employeeId, Date receiveDate, Date plannedStartDate, Date startDate, Date endDate, String problemDesc, String repairDesc, String statusCode, double repairPrice, double partsPrice, double manHour, double workHours) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(INS_ORDER);
            stmt.setInt(1, carId);
            stmt.setInt(2, employeeId);
            stmt.setDate(3, receiveDate);
            stmt.setDate(4, plannedStartDate);
            stmt.setDate(5, startDate);
            stmt.setDate(6, endDate);
            stmt.setString(7, problemDesc);
            stmt.setString(8, repairDesc);
            stmt.setString(9, statusCode);
            stmt.setDouble(10, repairPrice);
            stmt.setDouble(11, partsPrice);
            stmt.setDouble(12, manHour);
            stmt.setDouble(13, workHours);

            int count = stmt.executeUpdate();
            if (count != 0) {
                System.out.println("Ins " + count + " wierszy");
                return true;
            }
            else {
                System.out.println("Ins 0 wierszy");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorMessage = e.getMessage();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}
