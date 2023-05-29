package dao;

import model.Staff;

import java.sql.SQLException;
import java.util.Currency;
import java.util.List;

public interface IStaffDao {
     void insertStaff(Staff staff) throws SQLException;
     Staff selectStaff(int id);
     List<Staff> selectAllStaff();
     boolean updateStaff(Staff staff) throws SQLException;
     boolean deleteStaff(int id) throws SQLException;
     Staff findById(int id) throws SQLException;

}
