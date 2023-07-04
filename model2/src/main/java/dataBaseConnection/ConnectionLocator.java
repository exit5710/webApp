package dataBaseConnection;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionLocator {
	Connection getConnection() throws ClassNotFoundException, SQLException, IOException;
}