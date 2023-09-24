package dataBaseConnection;

import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

public class MariaDataBase implements ConnectionLocator {
	private static  MariaDataBase singleton;

	public static MariaDataBase getInstance() {
		if (singleton == null) {
			singleton = new MariaDataBase();
		}

		return singleton;
	}

	@Override
	public Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
		String path = getClass().getResource("/dataBaseInfo.properties").getPath();
		FileReader resources = new FileReader(path);
		Properties properties = new Properties();
		properties.load(resources);

		String url = properties.getProperty("mariaDbUrl");
		String user = properties.getProperty("mariaDbUser");
		String password = properties.getProperty("mariaDbPassword");

		Class.forName("org.mariadb.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(true);
		resources.close();

		return connection;
	}
}