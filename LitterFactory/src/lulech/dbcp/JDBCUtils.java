package lulech.dbcp;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import lulech.jdbc.JDBCUtilsConfig;
/**
 * @author lulech
 * */
public class JDBCUtils {
	private static BasicDataSource dataSource = new BasicDataSource();
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	private static String initialSize;
	private static String maxActive;
	private static String maxIdle;
	private static String minIdle;
	
	
	static{
		//Êý¾Ý¿â
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(Integer.parseInt(initialSize));
		dataSource.setMaxActive(Integer.parseInt(maxActive));
		dataSource.setMaxIdle(Integer.parseInt(maxIdle));
		dataSource.setMinIdle(Integer.parseInt(minIdle));
	}
	
	/**
	 * read config file into class
	 * @author lulech
	 * @version 0.1
	 * @return void
	 * @exception FileNotFoundException,IOException,SQLException
	 * */
	private static void readConfig() throws FileNotFoundException, IOException, SQLException {
		InputStream in = JDBCUtilsConfig.class.getClassLoader().getResourceAsStream("database.properties");
		Properties properties = new Properties();
		properties.load(new BufferedInputStream(in));
		driverClass = properties.getProperty("driverClass");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		initialSize = properties.getProperty("initialSize");
		maxActive = properties.getProperty("maxActive");
		maxIdle = properties.getProperty("maxIdle");
		minIdle = properties.getProperty("minIdle");
	}
	
	
	public static DataSource getDataSource(){
		return dataSource;
	}
}
