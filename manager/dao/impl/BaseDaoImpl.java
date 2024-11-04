/**
 * BaseDaoImpl.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import manager.dao.BaseDao;
import manager.utils.DatabaseProperties;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class BaseDaoImpl implements BaseDao {

	private static String URL = null;
	private static String USER = null;
	private static String PASSWORD = null;
	private static String DRIVER = null;
	protected Connection conn;

	/**
	 * @see manager.dao.BaseDao#openConnection()
	 */
	@Override
	public Connection openConnection() throws SQLException, ClassNotFoundException {
		try {
			URL = DatabaseProperties.getValue("URL");
			USER = DatabaseProperties.getValue("USER");
			PASSWORD = DatabaseProperties.getValue("PASSWORD");
			DRIVER = DatabaseProperties.getValue("DRIVER");
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error BaseDaoImpl.openConnection(): " + e.getMessage());
			throw e;
		}
		return conn;
	}

	/**
	 * @see manager.dao.BaseDao#closeConnection()
	 */
	@Override
	public void closeConnection() throws SQLException {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Error BaseDaoImpl.closeConnection(): " + e.getMessage());
			throw e;
		}
	}

	/**
	 * @see manager.dao.BaseDao#setAutoCommit(boolean)
	 */
	@Override
	public void setAutoCommit(boolean value) throws SQLException {
		try {
			if (conn != null) {
				conn.setAutoCommit(value);
			}
		} catch (SQLException e) {
			System.out.println("Errors BaseDaoImpl.setAutoCommit(): " + e.getMessage());
			throw e;
		}
	}

	/**
	 * @see manager.dao.BaseDao#commit()
	 */
	@Override
	public void commit() throws SQLException {
		try {
			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println("Error BaseDaoImpl.commit(): " + e.getMessage());
			throw e;
		}
	}

	/**
	 * @see manager.dao.BaseDao#rollBackConnection()
	 */
	@Override
	public void rollBackConnection() throws SQLException {
		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			System.out.println("Errors: BaseDaoImpl:rollbackConnection " + e.getMessage());
			throw e;
		}
	}

}
