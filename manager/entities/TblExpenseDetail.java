/**
 * TblExpenseDetail.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.entities;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class TblExpenseDetail {

	// 1. Attributes.
	private int expenseDetailId;
	private int userId;
	private String detail;
	private String date;
	private String note;

	// 2. Getter - Setter.
	/**
	 * @return the expenseDetailId
	 */
	public int getExpenseDetailId() {
		return expenseDetailId;
	}

	/**
	 * @param expenseDetailId the expenseDetailId to set
	 */
	public void setExpenseDetailId(int expenseDetailId) {
		this.expenseDetailId = expenseDetailId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
}
