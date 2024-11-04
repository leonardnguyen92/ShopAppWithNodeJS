/**
 * ViewApp.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.view;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import manager.controller.CreateUserController;
import manager.controller.LoginController;
import manager.entities.TblUser;
import manager.utils.Common;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class ViewApp {

	private Scanner scan = new Scanner(System.in);

	public void showMenu() {
		boolean check = true;
		do {
//			viewLogin();
			viewCreateUser();
		} while (check);
	}

	private void viewLogin() {

		System.out.print("Tên đăng nhập:");
		String loginName = scan.nextLine();
		System.out.print("Mật khẩu:");
		String password = scan.nextLine();
		LoginController login = new LoginController();
		boolean checkLogin = login.doLogin(loginName, password);
		if (checkLogin) {
			System.out.println("Login Successfull");
			clearScreen();
		}
	}

	private void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private void viewCreateUser() {
		try {
			System.out.print("Tên đăng nhập:");
			String loginName = scan.nextLine();
			System.out.print("Mật khẩu:");
			String password = scan.nextLine();
			System.out.print("Họ Tên:");
			String fullname = scan.nextLine();
			System.out.print("Phone:");
			String tel = scan.nextLine();
			System.out.print("Ngày Sinh:");
			String birthday = scan.nextLine();
			System.out.print("Rule:");
			String rule = scan.nextLine();
			String salt = Common.createSalt();
			String encryptPass = Common.encrypt(salt, password);
			TblUser tblUser = new TblUser();
			tblUser.setLoginName(loginName);
			tblUser.setPassword(encryptPass);
			tblUser.setFullName(fullname);
			tblUser.setTel(tel);
			tblUser.setBirthday(birthday);
			tblUser.setRule(Integer.parseInt(rule));
			tblUser.setSalt(salt);
			CreateUserController controller = new CreateUserController();
			boolean check = controller.CreatController(tblUser);
			if (check) {
				System.out.println("Thành Công!");
			} else {
				System.out.println("Thất Bại!");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}
}
