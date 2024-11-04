/**
 * CreateUserController.java
 * ExpenseManagement
 * 01-11-2024
 */
package manager.controller;

import manager.entities.TblUser;
import manager.logic.TblUserLogic;
import manager.logic.impl.TblUserLogicImple;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class CreateUserController {

	public boolean CreatController(TblUser tblUser) {
		boolean checkCreate = false;
		try {
			TblUserLogic tblUserLogicImple = new TblUserLogicImple();
			if (tblUserLogicImple.checkCreateUser(tblUser)) {
				checkCreate = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkCreate;
	}
}
