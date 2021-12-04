package Utillties;
import io.qameta.allure.Step;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class JDBC extends CommonOps {
    //String dbUrl="remotemysql.com:3306";


    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    @Step
    public void initSQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(getData("DBUrl"),getData("UserNameDB"),getData("PasswordDB"));
            stmt = con.createStatement();
        }
        catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
    }

    @Step("return a list of teachers")
    public List<String> getCredentials() {
        List<String> credentials = new ArrayList<String>();
        try {
            rs= stmt.executeQuery("SELECT Balance FROM BalanceTable WHERE Profession='Teacher'");
            while (rs.next()) {
                credentials.add(rs.getString(1));
            }
        }
        catch(SQLException e) {
            System.out.println("Error Occured While Printing Table Data, See Details: " + e);
        }
        return credentials;
    }

    @Step
    public void closeDBCon() {
        try {
            con.close();
        }
        catch(SQLException e) {
            System.out.println("Error Occured While Closing JDBC, See Details: " + e);
        }
    }
}
