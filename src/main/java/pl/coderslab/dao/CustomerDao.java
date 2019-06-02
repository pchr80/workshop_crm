package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.model.OrderExt;
import pl.coderslab.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public static String errorMessage = "";

    private static final String ALL_CUSTOMERS = "SELECT * FROM customer";

    private static final String CUSTOMER_DETAILS = "SELECT * FROM customer WHERE id = ?";

    private static final String UPD_CUSTOMER =
            "UPDATE customer SET\n" +
                    "name = ?,\n" +
                    "surname = ?,\n" +
                    "birth_date = ?\n" +
                    "WHERE \n" +
                    "id = ?";

    private static final String DEL_CUSTOMER = "DELETE FROM customer WHERE id = ?";

    private static final String INS_CUSTOMER = "INSERT INTO customer (name, surname, birth_date) VALUES (?, ?, ?)";


    public static List<Customer> getCustomers() {
        try {
            List<Customer> result = new ArrayList<>();
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(ALL_CUSTOMERS);
            ResultSet rs = stmt.executeQuery();
            while ((rs.next())) {
                int customerId = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Date birthDate = rs.getDate("birth_date");
                result.add(new Customer(customerId, name, surname, birthDate));
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

    public static Customer getCustomerDetails(int id) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(CUSTOMER_DETAILS);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while ((rs.next())) {
                int customerId = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Date birthDate = rs.getDate("birth_date");
                return new Customer(customerId, name, surname, birthDate);
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

    public static boolean updCustomer(int customerId, String name, String surname, Date birthDate) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(UPD_CUSTOMER);
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setDate(3, birthDate);
            stmt.setInt(4, customerId);
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

    public static boolean delCustomer(int customerId) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(DEL_CUSTOMER);
            stmt.setInt(1, customerId);
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

    public static boolean insCustomer(String name, String surname, Date birthDate) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(INS_CUSTOMER);
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setDate(3, birthDate);
            //  stmt.setInt(13, orderId);
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
