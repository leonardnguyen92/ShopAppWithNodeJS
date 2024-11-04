/**
 * TblUserDao.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.dao;

import java.sql.SQLException;
import java.text.ParseException;

import manager.entities.TblUser;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public interface TblUserDao extends BaseDao {

	/**
	 * Phương thức lấy thông tin user để đăng nhập và hiển thị.
	 * 
	 * @param loginName - tên đăng nhập.
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	TblUser getAccount(String loginName) throws SQLException, ClassNotFoundException;

	/**
	 * Phuơng thức kiểm tra id có tồn tại trong database.
	 * 
	 * @param userID
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	boolean chechExistsUserId(int userID) throws SQLException, ClassNotFoundException;

	/**
	 * Phương thức tạo user mới trong database.
	 * 
	 * @param tblUser
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	int createUser(TblUser tblUser) throws SQLException, ClassNotFoundException;

	/**
	 * Phương thức update user trong database.
	 * 
	 * @param tblUser
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	boolean updateUser(TblUser tblUser) throws SQLException, ClassNotFoundException;

	/**
	 * Phương thức xóa user trong database.
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	boolean deleteUser(int userId) throws SQLException, ClassNotFoundException;

	/**
	 * Phương thức thay đổi mật khẩu của user.
	 * 
	 * @param userId
	 * @param pass
	 * @param salt
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	boolean changePass(int userId, int pass, int salt) throws SQLException, ClassNotFoundException;
}
