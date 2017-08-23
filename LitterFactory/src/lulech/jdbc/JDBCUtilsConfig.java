package lulech.jdbc;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtilsConfig {
	private static Connection connection;
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;

	private JDBCUtilsConfig() {
	};

	static {
		try {
			readConfig();
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, username, password);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void close(Connection connection) {
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void readConfig() throws FileNotFoundException, IOException, SQLException {
		InputStream in = JDBCUtilsConfig.class.getClassLoader().getResourceAsStream("database.properties");
		Properties properties = new Properties();
		properties.load(new BufferedInputStream(in));
		driverClass = properties.getProperty("driverClass");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
	}
}
