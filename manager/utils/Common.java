/**
 * Common.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.UUID;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class Common {
	/**
	 * Phương thức sinh mã salt ngẫu nhiên
	 */
	public static String createSalt() {
		// tạo 1 chuỗi từ sinh random
		String salt = UUID.randomUUID().toString();
		// trả về chuỗi tự sinh
		return salt;
	}

	/**
	 * Phương thức mã hóa dưới dạng SHA-1
	 * 
	 * @param salt chuỗi salt
	 * @param pass giá trị mật khẩu
	 * @return chuối mã hóa
	 * @throws NoSuchAlgorithmException
	 */
	public static String encrypt(String salt, String pass) throws NoSuchAlgorithmException {
		String passEncrypt = salt + pass;
		// mã hóa dạng SHA-1
		MessageDigest m = MessageDigest.getInstance("SHA-1");
		m.reset();
		m.update(passEncrypt.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		// độ dài chuỗi mã hóa ký tự
		String hashtext = bigInt.toString(16);
		// trả về chuỗi đã mã hóa
		return hashtext;
	}

	/**
	 * Phương thức chuyển đổi kiểu dữ liệu từ String sang java.sql.Date.
	 * 
	 * @param stringDate - ngày tháng theo kiểu dữ liệu String.
	 * @return ngày tháng theo kiểu dữ liệu java.sql.Date
	 */
	public static Date convertStringToDate(String stringDate) {
		return Date.valueOf(stringDate);
	}

	/**
	 * Phương thức chuyển đổi kiểu dữ liệu từ java.sql.Date sang String.
	 * 
	 * @param date - ngày tháng theo kiểu dữ liệu java.sql.Date
	 * @return ngày tháng theo kiểu dữ liệu String
	 */
	public static String convertDateToString(Date date) {
		return date.toString();
	}
}
