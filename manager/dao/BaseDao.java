/**
 * BaseDao.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public interface BaseDao {

	/**
	 * Phương thức mở kết nối tới Database.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	Connection openConnection() throws SQLException, ClassNotFoundException;

	/**
	 * Phương thức đóng kết nối tới Database.
	 * 
	 * @throws SQLException
	 */
	void closeConnection() throws SQLException;

	/**
	 * 
	 * @param value
	 * @throws SQLException
	 */
	void setAutoCommit(boolean value) throws SQLException;

	/**
	 * 
	 * @throws SQLException
	 */
	void commit() throws SQLException;
	
	/**
	 * 
	 * @throws SQLException
	 */
	void rollBackConnection() throws SQLException;
}
