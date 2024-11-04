/**
 * ValidateUser.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.validates;

import java.util.ArrayList;
import java.util.List;

import manager.logic.TblUserLogic;
import manager.logic.impl.TblUserLogicImple;
import manager.utils.MessageErrorProperties;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class ValidateUser {

	private TblUserLogic tblUserLogic = new TblUserLogicImple();

	public List<String> validateLogin(String loginName, String password) throws Exception {
		List<String> listError = new ArrayList<String>();
		try {
			if (loginName == null || "".equals(loginName)) {
				listError.add(MessageErrorProperties.getValue("ERR001_LoginName"));
			}
			if ("".equals(password) || password == null) {
				listError.add(MessageErrorProperties.getValue("ERR001_Password"));
			}
			if (listError.size() == 0 && !tblUserLogic.checkExistsAccount(loginName, password)) {
				listError.add(MessageErrorProperties.getValue("ERR016"));
			}
		} catch (Exception e) {
			System.out.println("Error ValidateUser.validateLogin(): " + e.getMessage());
			throw e;
		}
		return listError;
	}
}
