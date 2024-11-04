/**
 * TblUserDaoImpl.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import manager.dao.BaseDao;
import manager.dao.TblUserDao;
import manager.entities.TblUser;
import manager.utils.Constant;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class TblUserDaoImpl extends BaseDaoImpl implements TblUserDao {

	/**
	 * @see manager.dao.TblUserDao#getAccount(java.lang.String)
	 */
	@Override
	public TblUser getAccount(String loginName) throws SQLException, ClassNotFoundException {
		TblUser tblUser = null;
		try {
			openConnection();
			if (conn != null) {
				String sql = "SELECT tbl_user.password, tbl_user.salt, tbl_user.rule FROM tbl_user WHERE tbl_user.login_name = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, loginName);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					tblUser = new TblUser();
					tblUser.setPassword(rs.getString("password"));
					tblUser.setSalt(rs.getString("salt"));
					tblUser.setRule(rs.getInt("rule"));
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error TblUserDaoImpl.getAccount(): " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return tblUser;
	}

	/**
	 * @see manager.dao.TblUserDao#chechExistsUserId(int)
	 */
	@Override
	public boolean chechExistsUserId(int userID) throws SQLException, ClassNotFoundException {
		boolean checkExistsId = false;
		try {
			int value = 0;
			PreparedStatement ps;
			openConnection();
			if (conn != null) {
				String sql = "SELECT user_id FROM tbl_user WHERE tbl_user.user_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, userID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					value = rs.getInt("user_id");
				}
				if (value != 0) {
					checkExistsId = true;
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error TblUserDaoImpl.checkExistsUserId(): " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return checkExistsId;
	}

	/**
	 * @see manager.dao.TblUserDao#createUser(manager.entities.TblUser)
	 */
	@Override
	public int createUser(TblUser tblUser) throws SQLException, ClassNotFoundException {
		int userId = 0;
		try {
			openConnection();
			if (conn != null) {
				conn.setAutoCommit(false);
				StringBuilder sql = new StringBuilder();
				Date date = Date.valueOf(tblUser.getBirthday());
				sql.append("INSERT INTO tbl_user (login_name, password, full_name, tel, birthday, rule, salt) ");
				sql.append("VALUES (?,?,?,?,?,?,?)");
				PreparedStatement ps = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

				int index = 1;
				ps.setString(index++, tblUser.getLoginName());
				ps.setString(index++, tblUser.getPassword());
				ps.setString(index++, tblUser.getFullName());
				ps.setString(index++, tblUser.getTel());
				ps.setDate(index++, date);
				ps.setInt(index++, tblUser.getRule());
				ps.setString(index++, tblUser.getSalt());
				ps.executeUpdate();
				conn.commit();
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					userId = rs.getInt(1);
				}

			}
		} catch (SQLException | ClassNotFoundException e) {
			conn.rollback();
			System.out.println("Error TblUserDaoImpl.createUser(): " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}

		return userId;
	}

	/**
	 * @see manager.dao.TblUserDao#updateUser(manager.entities.TblUser)
	 */
	@Override
	public boolean updateUser(TblUser tblUser) throws SQLException, ClassNotFoundException {
		boolean checkUpdate = false;
		try {
			openConnection();
			if (conn != null) {
				conn.setAutoCommit(false);

			}
		} catch (SQLException | ClassNotFoundException e) {
			conn.rollback();
			System.out.println("Error TblUserDaoImpl.updateUser(): " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}

		return checkUpdate;
	}

	/**
	 * @see manager.dao.TblUserDao#deleteUser(int)
	 */
	@Override
	public boolean deleteUser(int userId) throws SQLException, ClassNotFoundException {
		boolean checkDelete = false;
		try {
			openConnection();
			if (conn != null) {
				conn.setAutoCommit(checkDelete);
				StringBuilder sql = new StringBuilder();
				sql.append("DELETE FROM tbl_user ");
				sql.append("WHERE user_id = ? AND rule = ?");
				PreparedStatement ps = conn.prepareStatement(sql.toString());
				int index = 1;
				ps.setInt(index++, userId);
				ps.setInt(index++, Constant.RULE_USER);
				int result = ps.executeUpdate();
				if(result > 0) {
					checkDelete = true;
				}
				conn.commit();
			}
		} catch (SQLException | ClassNotFoundException e) {
			conn.rollback();
			System.out.println("Error TblUserDaoImpl.deleteUser(): " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}

		return checkDelete;
	}

	/**
	 * @see manager.dao.TblUserDao#changePass(int, int, int)
	 */
	@Override
	public boolean changePass(int userId, int pass, int salt) throws SQLException, ClassNotFoundException {
		boolean checkChange = false;
		try {
			openConnection();
			if (conn != null) {

			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error TblUserDaoImpl.changePass(): " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}

		return checkChange;
	}

}
