/**
 * TblUserLogic.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.logic;

import manager.entities.TblUser;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public interface TblUserLogic {

	/**
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	boolean checkExistsAccount(String loginName, String password) throws Exception;

	/**
	 * 
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	int checkRule(TblUser tblUser) throws Exception;

	/**
	 * 
	 * @param tblUser
	 * @return
	 * @throws Exception
	 */
	boolean checkCreateUser(TblUser tblUser) throws Exception;
}
