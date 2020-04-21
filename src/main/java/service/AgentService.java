package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.AirportDao;
import datasource.HikariCPDataSource;
import entity.Airport;

public class AgentService {

	public List<Airport> getAirports() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		try {
			connection = HikariCPDataSource.getConnection();
			return new AirportDao(connection).get();
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
	}
}
