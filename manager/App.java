/**
 * App.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager;

import manager.view.ViewApp;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class App {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ViewApp view = new ViewApp();
		view.showMenu();
	}
}
