package taskjava;


import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class TaskJava21 {

    public class Employee {

        private int employee_id;
        private String first_name;
        private String last_name;
        private String email;
        private String phone_number;

        public int getEmployee_id() {
            return employee_id;
        }

        public void setEmployee_id(int employee_id) {
            this.employee_id = employee_id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public Date getHire_date() {
            return hire_date;
        }

        public void setHire_date(Date hire_date) {
            this.hire_date = hire_date;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        public BigDecimal getCommission_pct() {
            return commission_pct;
        }

        public void setCommission_pct(BigDecimal commission_pct) {
            this.commission_pct = commission_pct;
        }

        public int getManager_id() {
            return manager_id;
        }

        public void setManager_id(int manager_id) {
            this.manager_id = manager_id;
        }

        public int getDepartment_id() {
            return department_id;
        }

        public void setDepartment_id(int department_id) {
            this.department_id = department_id;
        }

        private Date hire_date;
        private BigDecimal salary;
        private BigDecimal commission_pct;
        private int manager_id;
        private int department_id;

        @Override
        public String toString() {
            return "Employee{" +
                    "employee_id=" + employee_id +
                    ", first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    ", email='" + email + '\'' +
                    ", phone_number='" + phone_number + '\'' +
                    ", hire_date=" + hire_date +
                    ", salary=" + salary +
                    ", commission_pct=" + commission_pct +
                    ", manager_id=" + manager_id +
                    ", department_id=" + department_id +
                    '}';
        }
    }

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    public ArrayList<Employee> getEmployeesTable
            () {
        System.out.println("getEmployeesTable=");
        ArrayList<Employee> employees = new ArrayList<Employee>();;
        Connection dbConnection = null;

        try {
            dbConnection = getDBConnection();
            String query = "SELECT * FROM sakila.employees";
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setCommission_pct(rs.getBigDecimal("commission_pct"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setEmail(rs.getString("email"));
                employee.setFirst_name(rs.getString("first_name"));
                employee.setLast_name(rs.getString("last_name"));
                employee.setHire_date(rs.getDate("hire_date"));
                employee.setPhone_number(rs.getString("phone_number"));
                employee.setSalary(rs.getBigDecimal("salary"));

                employees.add(employee);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        if (dbConnection != null) {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
      return employees;
    }



    public static void expCSV(String par){

        if (par=="e") {
            try
            {
                String sFileName="c:\\test3.csv";

                FileWriter writer = new FileWriter(sFileName);
                TaskJava21 taskJava3 =new TaskJava21();
                ArrayList<Employee> employees= taskJava3.getEmployeesTable();
                writer.append("DisplayName");
                writer.append(',');

                for(int i=0; i<employees.size(); i++){
                    Employee employee = employees.get(i);
                    writer.append((char) employee.getEmployee_id());
                    writer.append(',');
                    writer.append(employee.getEmail());
                    writer.append(',');
                    writer.append(employee.getFirst_name());
                    writer.append(',');
                    writer.append(employee.getLast_name());
                    writer.append(',');
                    writer.append(employee.getPhone_number());
                    writer.append(',');
                    if (employee.getCommission_pct()!=null) {
                        writer.append(employee.getCommission_pct().toString());
                    }
                    else {writer.append("null");};
                    writer.append(',');
                    writer.append((char) employee.getDepartment_id());
                    writer.append(',');
                    if (employee.getHire_date()!=null) {
                        writer.append(employee.getHire_date().toString());
                    }
                    else {writer.append("null");};

                    writer.append(',');
                    if (employee.getSalary()!=null) {
                        writer.append(employee.getSalary().toString());
                    }
                    else {writer.append("null");};

                    writer.append(',');

                    writer.append('\n');


                }

                writer.flush();
                writer.close();
                System.out.println("very good");
            }
            catch(IOException e)
            {
                System.out.println("not good="+e.toString());
            }
            System.out.println(par.toString());

        }

    }

    public static void main(String[] args) {

        for (String s: args) {
            System.out.println("parameter="+s);
            expCSV(s);//e

        }


    }
}
