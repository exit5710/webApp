package racers.dao;

import dataBaseConnection.ConnectionLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import racers.vo.RacerVo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RacerDao {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static RacerDao singleton;

	private ConnectionLocator connectionLocator;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	private RacerDao(ConnectionLocator connectionLocator) {
		this.connectionLocator = connectionLocator;
	}

	// RacerDao getInstance
	public static RacerDao getInstance(ConnectionLocator connectionLocator) {
		if (singleton == null) {
			singleton = new RacerDao(connectionLocator);
		}

		return singleton;
	}

	// selectRacer
	public ArrayList<RacerVo> selectRacer() throws SQLException {
		logger.info("RacerDao selectRacer /");

		ArrayList<RacerVo> arrayList = new ArrayList<>();

		try {
			connection = connectionLocator.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT FIRST_NAME");
			sql.append("       , LAST_NAME");
			sql.append("       , GENDER");
			sql.append("       , MINUTES");
			sql.append("       , SECONDS");
			sql.append("  FROM RACER");
			//sql.append(" WHERE IDX = ?");

			ps = connection.prepareStatement(sql.toString());
			//ps.setInt(1, 1);
			rs = ps.executeQuery();

			while (rs.next()) {
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String gender = rs.getString("GENDER");
				String minutes = rs.getString("MINUTES");
				String seconds = rs.getString("SECONDS");

				arrayList.add(new RacerVo(firstName, lastName, gender, minutes, seconds));
			}
		} catch (NullPointerException | ClassNotFoundException | IOException e) {
			logger.error(e.toString());
		} finally {
			close(rs, ps, connection);
		}

		return arrayList;
	}

	// insertRacer
	public void insertRacer(RacerVo racerVo) throws SQLException {
		logger.info("RacerDao insertRacer /");

		try {
			connection = connectionLocator.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO RACER VALUES (");
			sql.append("NULL, ?, ?, ?, ?, ?, NOW()");
			sql.append(")");

			ps = connection.prepareStatement(sql.toString());
			ps.setString(1, racerVo.getFirstName());
			ps.setString(2, racerVo.getLastName());
			ps.setString(3, racerVo.getGender());
			ps.setString(4, racerVo.getMinutes());
			ps.setString(5, racerVo.getSeconds());
			ps.executeUpdate();

			connection.commit();
		} catch (NullPointerException | ClassNotFoundException | IOException e) {
			connection.rollback();
			logger.error(e.toString());
		} finally {
			close(rs, ps, connection);
		}
	}

	// close
	private void close(ResultSet rs, PreparedStatement ps, Connection connection) {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (connection != null) connection.close();
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}
}