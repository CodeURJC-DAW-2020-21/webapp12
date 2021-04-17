package undersociety.controller.api.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import undersociety.models.Statistics;
import undersociety.services.AdminService;

@RestController
@CrossOrigin
@RequestMapping("api/statistics")
public class StatisticsRestController {

	@Autowired
	private AdminService statistics;
	
	@Operation(summary = "Get a all Statistics")
	@ApiResponses(value = { 
			@ApiResponse(
					responseCode = "200", 
					description = "Found the statistics", 
					content = {@Content(
							mediaType = "application/json"
							)}
					) 
	})
	@GetMapping("/")
	public Statistics getStatistics() {
		return statistics.getStatics();
	}
	
}
