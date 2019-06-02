package pl.coderslab.dao;

import pl.coderslab.model.Car;
import pl.coderslab.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    public static String errorMessage = "";

    private static final String ALL_CARS = "SELECT * FROM car";

    private static final String CARS_CUST_ID = "SELECT * FROM car WHERE customer_id =?";

    private static final String CAR_DETAILS = "SELECT * FROM car WHERE id = ?";

    private static final String UPD_CAR =
            "UPDATE car SET \n" +
                    "customer_id = ?,\n" +
                    "brand = ?,\n" +
                    "model = ?,\n" +
                    "prod_year = ?,\n" +
                    "reg_nr = ?,\n" +
                    "review_date = ?\n" +
                    "WHERE \n" +
                    "id = ?";

    private static final String DEL_CAR = "DELETE FROM car WHERE id = ?";

    private static final String INS_CAR = "INSERT INTO car (customer_id, brand, model, prod_year, reg_nr, review_date) VALUES (?, ?, ?, ?, ?, ?)";


    public static List<Car> getCars() {
        try {
            List<Car> result = new ArrayList<>();
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(ALL_CARS);
            ResultSet rs = stmt.executeQuery();
            while ((rs.next())) {
                int carId = rs.getInt("id");
                int customerId = rs.getInt("customer_id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int prodYear = rs.getInt("prod_year");
                String regNr = rs.getString("reg_nr");
                Date reviewDate = rs.getDate("review_date");
                result.add(new Car(carId, customerId, brand, model, prodYear, regNr, reviewDate));
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

    public static List<Car> getCarsCustId(int custId) {
        try {
            List<Car> result = new ArrayList<>();
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(CARS_CUST_ID);
            stmt.setInt(1, custId);
            ResultSet rs = stmt.executeQuery();
            while ((rs.next())) {
                int carId = rs.getInt("id");
                int customerId = rs.getInt("customer_id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int prodYear = rs.getInt("prod_year");
                String regNr = rs.getString("reg_nr");
                Date reviewDate = rs.getDate("review_date");
                result.add(new Car(carId, customerId, brand, model, prodYear, regNr, reviewDate));
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

    public static Car getCarDetails(int id) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(CAR_DETAILS);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while ((rs.next())) {
                int carId = rs.getInt("id");
                int customerId = rs.getInt("customer_id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int prodYear = rs.getInt("prod_year");
                String regNr = rs.getString("reg_nr");
                Date reviewDate = rs.getDate("review_date");
                return new Car(carId, customerId, brand, model, prodYear, regNr, reviewDate);
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

    public static boolean updCar(int carId, int customerId, String brand, String model, int prodYear, String regNr, Date reviewDate) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(UPD_CAR);
            stmt.setInt(1, customerId);
            stmt.setString(2, brand);
            stmt.setString(3, model);
            stmt.setInt(4, prodYear);
            stmt.setString(5, regNr);
            stmt.setDate(6, reviewDate);
            stmt.setInt(7, carId);
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

    public static boolean delCar(int carId) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(DEL_CAR);
            stmt.setInt(1, carId);
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

    public static boolean insCar(int customerId, String brand, String model, int prodYear, String regNr, Date reviewDate) {
        try {
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(INS_CAR);
            stmt.setInt(1, customerId);
            stmt.setString(2, brand);
            stmt.setString(3, model);
            stmt.setInt(4, prodYear);
            stmt.setString(5, regNr);
            stmt.setDate(6, reviewDate);
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
