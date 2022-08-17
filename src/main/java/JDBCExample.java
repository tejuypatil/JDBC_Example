import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class JDBCExample {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String USER = "root";
        String PASS = "12345";
        Connection connection;
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Loaded!");
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Cannot find the driver in ths classpath!", e);
            }
            listDrivers();
            try {
                System.out.println("connecting to database: " + URL);
                connection = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("connection is successful! " + connection);
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private static void listDrivers(){
        Enumeration<Driver> driverList=DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driverClass=driverList.nextElement();
            System.out.println(driverClass.getClass().getName()+" ");
        }
    }
}