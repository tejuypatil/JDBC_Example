import java.util.Date;
public class EmployeePayrollData {
    public String employeeName;
    public int employeeID;
    public int employeeSalary;
    public  double employeeSalary1;
    public String gender;
    public Date start;
    public EmployeePayrollData(String employeeName, String gender, int employeeID, double employeeSalary, Date start_date)
    {
        this.employeeName = employeeName;
        this.gender = gender;
        this.employeeID = employeeID;
        this.employeeSalary1 = employeeSalary;
        this.start = start_date;

    }

    @Override
    public String toString()
    {
        return "EmployeePayrollData{" +
                "employeeName='" + employeeName + '\'' +
                ", gender="+ gender+
                ", employeeID=" + employeeID +
                ", employeeSalary=" + employeeSalary +
                ",startDate=" +start+
                '}';
    }

}

