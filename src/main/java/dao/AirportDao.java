package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Airport;

public class AirportDao {

	private Connection connection;

	public AirportDao(Connection connection) {
		this.connection = connection;
	}

	public List<Airport> get() throws SQLException {
		List<Airport> airports = new ArrayList<Airport>();
		PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Airport");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Airport airport = new Airport();
			airport.setAirportCode(rs.getString("airportCode"));
			airport.setAirportName(rs.getString("airportName"));
			airport.setAirportLocation(rs.getString("airportLocation"));
			airports.add(airport);
		}
		return airports;
	}
}
