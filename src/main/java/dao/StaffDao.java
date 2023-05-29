package dao;

import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDao implements IStaffDao {
    private static final String SELECT_STAFF_SQL = "SELECT name, email, address, phone_number, salary, department_name FROM staff_management.staff " +
            "INNER JOIN staff_management.Department ON staff.staff_id = department.staff_id";
    private static final String SELECT_ALL_STAFF_SQL = "SELECT name, email, address, phone_number, salary, department_name FROM staff_management.staff " +
            "INNER JOIN staff_management.Department ON staff.staff_id = department.staff_id";
    private static final String INSERT_STAFF_SQL = "INSERT INTO staff_management.staff (name, email, address, phone_number, salary) VALUES (?,?,?,?,?)";
    private static final String UPDATE_STAFF_SQL = "UPDATE staff_management.staff SET name =?, email=?, address=?, phone_number=?, salary=? where staff_id =?";
    private static final String DELETE_STAFF_SQL = "DELETE FROM staff_management.staff WHERE staff_id = ?";
    private static final String Find_STAFF_SQL = "SELECT * FROM staff WHERE id = ?;";
//    private static final String FIND_BY_ID ;

    @Override
    public void insertStaff(Staff staff) throws SQLException {
        try(Connection connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STAFF_SQL);
        ){preparedStatement.setString(1,staff.getName());
            preparedStatement.setString(2,staff.getEmail());
            preparedStatement.setString(3,staff.getAddress());
            preparedStatement.setString(4,staff.getPhone_number());
            preparedStatement.setDouble(5,staff.getSalary());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Staff selectStaff(int id) {
        Staff staff = null ;
        try(
                Connection connection = ConnectDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STAFF_SQL);
        ){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("address");
                String phone = resultSet.getString("phone_number");
                double salary = resultSet.getDouble("salary");
                String department_name = resultSet.getString("department_name");

                staff = new Staff(name, email, country,phone, salary, department_name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return staff;
    }

    @Override
    public List<Staff> selectAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        try (
                Connection connection = ConnectDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STAFF_SQL);
        ) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("address");
                String phone = resultSet.getString("phone_number");
                double salary = resultSet.getDouble("salary");
                String department_name = resultSet.getString("department_name");
                staffList.add(new Staff(name, email, country,phone, salary, department_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;

    }

    @Override
    public boolean updateStaff(Staff staff) throws SQLException {
        boolean rowUpdate;
        try(
                Connection connection = ConnectDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STAFF_SQL);
        ){
            preparedStatement.setInt(1,staff.getId());
            preparedStatement.setString(2,staff.getName());
            preparedStatement.setString(3,staff.getEmail());
            preparedStatement.setInt(4,staff.getId());
            rowUpdate = preparedStatement.executeUpdate() >0;
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteStaff(int id) throws SQLException {
        boolean rowDeleted;
        try(
                Connection connection = ConnectDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STAFF_SQL);
        ){
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() >0;
        }
        return rowDeleted;

    }

    @Override
    public Staff findById(int id) throws SQLException {

//        String sql = "SELECT * FROM staff WHERE id = ?";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, "John Doe");
//        ResultSet result = statement.executeQuery();
        return null;
    }
}
