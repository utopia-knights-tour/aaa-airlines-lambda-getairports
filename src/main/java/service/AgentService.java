package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.AirportDao;
import entity.Airport;
import util.ConnectUtil;

public class AgentService {

	public List<Airport> getAirports() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		try {
			connection = ConnectUtil.getInstance().getConnection();
			return new AirportDao(connection).get();
		} catch (SQLException e) {
			throw e;
		}
	}
}
