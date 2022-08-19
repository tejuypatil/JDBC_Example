import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {
    public List<EmployeePayrollData> readData() {
        String sql = "select * from employee_payroll;";
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

        try (Connection connection = (Connection) this.getConnection())
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                Date start_date = resultSet.getDate("start_date");
                employeePayrollDataList.add(new EmployeePayrollData(name,gender,id,salary,start_date));
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return employeePayrollDataList;
    }

    private Object getConnection() throws SQLException {
        String jdbcULR = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "12345";
        Connection connection;
        System.out.println("Connecting To DB: " + jdbcULR);
        connection = DriverManager.getConnection(jdbcULR,userName,password);
        System.out.println("Connection is successful..! " + connection);
        return connection;

    }

    public static void main(String[] args) {
        EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
        employeePayrollDBService.readData().forEach(System.out::println);
    }
}