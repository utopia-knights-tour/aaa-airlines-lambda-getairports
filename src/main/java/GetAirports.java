
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import entity.Airport;
import proxy.ApiGatewayProxyResponse;
import proxy.ApiGatewayRequest;
import service.AgentService;

public class GetAirports implements RequestHandler<ApiGatewayRequest, ApiGatewayProxyResponse> {

	private AgentService agentService = new AgentService();

	public ApiGatewayProxyResponse handleRequest(ApiGatewayRequest request, Context context) {
		LambdaLogger logger = context.getLogger();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Access-Control-Allow-Origin", "*");
		headers.put("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
		try {
			List<Airport> airports = agentService.getAirports();
			return new ApiGatewayProxyResponse(200, headers, new Gson().toJson(airports));
		} catch (SQLException e) {
			logger.log(e.getMessage());
			return new ApiGatewayProxyResponse(400, headers, null);
		} catch (ClassNotFoundException e) {
			logger.log(e.getMessage());
			return new ApiGatewayProxyResponse(500, headers, null);
		}
	}
}