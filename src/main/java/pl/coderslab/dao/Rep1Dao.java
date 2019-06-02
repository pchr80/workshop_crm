package pl.coderslab.dao;

import pl.coderslab.model.Car;
import pl.coderslab.model.Rep1Mod;
import pl.coderslab.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Rep1Dao {

    private static final String REP1_DATA =
            "SELECT \n" +
                    "CONCAT(e.name, ' ', e.surname) name,\n" +
                    "SUM(o.work_hours) work_hours\n" +
                    "FROM\n" +
                    "employee e JOIN\n" +
                    "orders o\n" +
                    "WHERE\n" +
                    "o.employee_id = e.id\n" +
                    "AND o.start_date >= ?\n" +
                    "AND o.end_date <= ?\n" +
                    "GROUP BY e.id";

    public static List<Rep1Mod> getRep1(Date dateFrom, Date dateTo) {
        try {
            List<Rep1Mod> result = new ArrayList<>();
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = conn.prepareStatement(REP1_DATA);
            stmt.setDate(1, dateFrom);
            stmt.setDate(2, dateTo);
            ResultSet rs = stmt.executeQuery();
            while ((rs.next())) {
                String name = rs.getString("name");
                int workHours = rs.getInt("work_hours");
                result.add(new Rep1Mod(name, workHours));
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

}
