/**
 * MessageProperties.java
 * ExpenseManagement
 * 28-10-2024
 */
package manager.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @author: Nguyễn Hoàn
 */
public class MessageProperties {

	// Khởi tạo map.
	private static Map<String, String> data = new HashMap<String, String>();
	/**
	 * Phương thức load và duyệt file properties, và lưu vào Map.
	 */
	static {
		try {
			// Khởi tạo properties.
			Properties properties = new Properties();
			// Load file properties.
			properties.load(new InputStreamReader(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("manager/utils/message.properties"), "UTF-8"));
			// Duyệt file properties và lưu vào Map.
			for (String key : properties.stringPropertyNames()) {
				String value = properties.getProperty(key);
				data.put(key, value);
			}
		} catch (IOException e) {
			System.out.println("Error MessageProperties: " + e.getMessage());
		}
	}

	/**
	 * Phương thức lấy giá trị trong map theo key.
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		String value = "";
		if (data.containsKey(key)) {
			value = data.get(key);
		}
		return value;
	}
}
