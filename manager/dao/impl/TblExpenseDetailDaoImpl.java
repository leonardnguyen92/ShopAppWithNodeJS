/**
 * TblExpenseDetailDaoImpl.java
 * ExpenseManagement
 * 02-11-2024
 */
package manager.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import manager.dao.TblExpenseDetailDao;
import manager.entities.TblExpenseDetail;
import manager.utils.Common;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class TblExpenseDetailDaoImpl extends BaseDaoImpl implements TblExpenseDetailDao {

	/**
	 * @see manager.dao.TblExpenseDetailDao#getExpenseDetail(int)
	 */
	@Override
	public TblExpenseDetail getExpenseDetail(int userId) throws SQLException, ClassNotFoundException {
		TblExpenseDetail expense = null;
		try {
			openConnection();
			if (conn != null) {
				String sql = "SELECT * FROM tbl_expense_detail WHERE user_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, userId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					expense = new TblExpenseDetail();
					expense.setExpenseDetailId(rs.getInt("expense_detail_id"));
					expense.setUserId(rs.getInt("user_id"));
					expense.setDetail(rs.getString("detail"));
					expense.setDate(rs.getString("date"));
					expense.setNote(rs.getString("note"));
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error TblExpenseDetailDaoImpl.getExpenseDetail(): " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return expense;
	}

	/**
	 * @see manager.dao.TblExpenseDetailDao#createExpense(manager.entities.TblExpenseDetail)
	 */
	@Override
	public int createExpense(TblExpenseDetail expense) throws SQLException, ClassNotFoundException {
		int expenseId = 0;
		try {
			openConnection();
			if (conn != null) {
				Date date = Common.convertStringToDate(expense.getDate());
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO tbl_expense_detail (user_id, detail, date, note) ");
				sql.append("VALUES (?,?,?,?)");
				PreparedStatement ps = conn.prepareStatement(sql.toString());
				int index = 1;
				ps.setInt(index++, expense.getUserId());
				ps.setString(index++, expense.getDetail());
				ps.setDate(index++, date);
				ps.setString(index++, expense.getNote());
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					expenseId = rs.getInt(1);
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error TblExpenseDetailDaoImpl. " + e.getMessage());
			throw e;
		}
		return expenseId;
	}

	/**
	 * @see manager.dao.TblExpenseDetailDao#updateExpense(manager.entities.TblExpenseDetail)
	 */
	@Override
	public boolean updateExpense(TblExpenseDetail expense) throws SQLException, ClassNotFoundException {
		boolean checkUpdate = false;
		try {
			openConnection();
			if (conn != null) {
				Date date = Common.convertStringToDate(expense.getDate());
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE tbl_expense_detail SET user_id = ?, detail = ?, date = ?, note = ? ");
				sql.append("WHERE expenxe_detail_id = ?");
				PreparedStatement ps = conn.prepareStatement(sql.toString());
				int index = 1;
				ps.setInt(index++, expense.getUserId());
				ps.setString(index++, expense.getDetail());
				ps.setDate(index++, date);
				ps.setString(index++, expense.getNote());
				int result = ps.executeUpdate();
				if(result > 0) {
					checkUpdate = true;
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error TblExpenseDetailDaoImpl. " + e.getMessage());
			throw e;
		}
		return checkUpdate;
	}

	/**
	 * @see manager.dao.TblExpenseDetailDao#deleteExpense(int)
	 */
	@Override
	public boolean deleteExpense(int expenseDetailId, int userId) throws SQLException, ClassNotFoundException {
		boolean checkDelete = false;
		try {
			openConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("DELETE FROM tbl_expense_detail ");
				sql.append("WHERE expense_detail_id = ? ");
				if(userId != 0 || !("".equals(userId))) {
					sql.append(")
				}
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, expenseDetailId);
				int result = ps.executeUpdate();
				if(result > 0) {
					checkDelete = true;
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error TblExpenseDetailDaoImpl. " + e.getMessage());
			throw e;
		}
		// TODO Auto-generated method stub
		return checkDelete;
	}

}
