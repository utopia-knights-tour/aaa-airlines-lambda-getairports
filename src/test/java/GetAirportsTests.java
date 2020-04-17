import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;

import entity.Airport;

public class GetAirportsTests {

	@Test
	public void getAirports() {
		GetAirports getAirports = new GetAirports();
		List<Airport> airports = (List<Airport>) getAirports.handleRequest(null, null);
		assertFalse(airports.isEmpty());
	}

}
