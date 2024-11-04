/**
 * LoginController.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.controller;

import java.util.ArrayList;
import java.util.List;

import manager.validates.ValidateUser;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class LoginController {

	public boolean doLogin(String loginName, String password) {
		boolean checkLogin = true;
		try {

			ValidateUser validate = new ValidateUser();
			List<String> error = new ArrayList<String>();
			error = validate.validateLogin(loginName, password);
			if (error.size() != 0) {
				for (String key : error) {
					System.out.println(key);
					checkLogin = false;
				}
			}
		} catch (Exception e) {
			System.out.println("Error LoginController.doLogin(): " + e.getMessage());
		}
		return checkLogin;
	}

}
