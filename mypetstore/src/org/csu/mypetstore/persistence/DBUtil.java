package org.csu.mypetstore.persistence;

import java.sql.*;

/**
 * Created by 梦 on 2017/3/7.
 */
public class DBUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/mypetstore";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            throw e;
        }
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if(connection != null){
            connection.close();
        }
    }

    public static void closeStatement(Statement statement) throws SQLException {
        if(statement != null){
            statement.close();
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if(preparedStatement != null){
            preparedStatement.close();
        }
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        if(resultSet != null){
            resultSet.close();
        }
    }
}
