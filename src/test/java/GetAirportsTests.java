import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import proxy.ApiGatewayProxyResponse;
import proxy.ApiGatewayRequest;

public class GetAirportsTests {

	private static Context context = null;
	private static LambdaLogger logger = null;

	@BeforeAll
	public static void beforeAll() {
		context = Mockito.mock(Context.class);
		logger = Mockito.mock(LambdaLogger.class);
		Mockito.when(context.getLogger()).thenReturn(logger);
	}

	@Test
	public void getAirports() {
		GetAirports getAirports = new GetAirports();
		ApiGatewayRequest request = Mockito.mock(ApiGatewayRequest.class);
		ApiGatewayProxyResponse response = getAirports.handleRequest(request, context);
		assertEquals(200, response.getStatusCode());
	}

}
