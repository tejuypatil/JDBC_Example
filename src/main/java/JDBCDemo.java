import java.sql.*;


import java.util.Enumeration;

public class JDBCDemo {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/sample";
        String USER = "root";
        String PASS = "12345";
        Connection connection;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        }
        catch (ClassNotFoundException e){
            throw new IllegalStateException("Cannot find the driver in ths classpath!",e);
        }

        listDrivers();

        try
        {
            System.out.println("Connecting to database: "+URL);
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection is successful!!!! "+connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements()){
            Driver driverClass = driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}


