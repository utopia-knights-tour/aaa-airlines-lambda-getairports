
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import entity.Airport;
import util.ConnectUtil;

public class GetAirports implements RequestHandler<Map<String, String>, Object> {

	public Object handleRequest(Map<String, String> event, Context context) {
		List<Airport> airports = new ArrayList<Airport>();
		Connection connection = null;
		try {
			connection = ConnectUtil.getInstance().getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Airport");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Airport airport = new Airport();
				airport.setCode(rs.getString("airportCode"));
				airport.setName(rs.getString("airportName"));
				airport.setLocation(rs.getString("airportLocation"));
				airports.add(airport);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return airports;
	}
}