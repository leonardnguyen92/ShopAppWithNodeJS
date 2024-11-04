/**
 * TblUserLogicImple.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.logic.impl;

import java.sql.Connection;

import manager.dao.TblUserDao;
import manager.dao.impl.TblUserDaoImpl;
import manager.entities.TblUser;
import manager.logic.TblUserLogic;
import manager.utils.Common;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class TblUserLogicImple implements TblUserLogic {

	private TblUserDao tblUserDaoImple = new TblUserDaoImpl();

	/**
	 * @see manager.logic.TblUserLogic#checkExistsAccount(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean checkExistsAccount(String loginName, String password) throws Exception {
		boolean checkExists = false;
		TblUser tblUser = tblUserDaoImple.getAccount(loginName);
		if (tblUser != null) {
			String salt = tblUser.getSalt();
			String pass = tblUser.getPassword();
			String encryptPassword = Common.encrypt(salt, password);
			if (encryptPassword.equals(pass)) {
				checkExists = true;
			}
		}
		return checkExists;
	}

	/**
	 * @see manager.logic.TblUserLogic#checkRule(java.lang.String)
	 */
	@Override
	public int checkRule(TblUser tblUser) throws Exception {
		return tblUser.getRule();
	}

	/**
	 * @see manager.logic.TblUserLogic#checkCreateUser(manager.entities.TblUser)
	 */
	@Override
	public boolean checkCreateUser(TblUser tblUser) throws Exception {
		boolean checkCreate = false;
		try {
			int rule = tblUser.getRule();
			if (rule != 0) {
				tblUserDaoImple.createUser(tblUser);
				checkCreate = true;
			} 

		} catch (Exception e) {
			System.out.println("Error TblUserLogicImpl.checkCreateUser: " + e.getMessage());
			throw e;
		}
//		finally {
//			tblUserDaoImple.closeConnection();
//		}
		return checkCreate;
	}

}
