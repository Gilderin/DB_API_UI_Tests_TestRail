package tests;

import baseEntity.BaseTestSQL;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL_TestSQL extends BaseTestSQL {

    @Test
    public void selectDataFromDB() {
        String query = "Select * from public.\"project\"" +
                " where id=1";
        ResultSet rs = jdbcService.executeQuery(query);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String projectName = rs.getString("projectName");
                String announcement = rs.getString("announcement");
                boolean showannouncment = rs.getBoolean("showannouncment");
                logger.info("id: " + id);
                logger.info("projectName: " + projectName);
                logger.info("announcement: " + announcement);
                logger.info("email: " + showannouncment);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }

    @Test
    public void select() {
        String sql = "Select * from public.\"Customer\"";
        ResultSet rs = jdbcService.executeQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("Id");
                String forename = rs.getString("forename");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                logger.info("id: " + id);
                logger.info("forename: " + forename);
                logger.info("surname: " + surname);
                logger.info("email: " + email);
                logger.info("age: " + age);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }
}
