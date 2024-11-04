/**
 * TblExpenseDetailDao.java
 * ExpenseManagement
 * 02-11-2024
 */
package manager.dao;

import java.sql.SQLException;

import manager.entities.TblExpenseDetail;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public interface TblExpenseDetailDao extends BaseDao {

	/**
	 * Phương thức lấy thông tin toàn bộ chi tiêu theo userId.
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	TblExpenseDetail getExpenseDetail(int userId) throws SQLException, ClassNotFoundException;

	/**
	 * Phương thức tạo bản ghi chi tiêu.
	 * 
	 * @param expense
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	int createExpense(TblExpenseDetail expense) throws SQLException, ClassNotFoundException;

	/**
	 * Phương thức chỉnh sửa một bản ghi.
	 * 
	 * @param expense
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	boolean updateExpense(TblExpenseDetail expense) throws SQLException, ClassNotFoundException;

	/**
	 * Phương thức xóa một bản ghi trong cơ sở dữ liệu.
	 * 
	 * @param expenseDetailId
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	boolean deleteExpense(int expenseDetailId) throws SQLException, ClassNotFoundException;

}
