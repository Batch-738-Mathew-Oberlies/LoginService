package com.revature.rideshare.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "distance-service", url = "http://distance-service:8080")
public interface DistanceService {
	@GetMapping(value = "/?api-key=true")
	public String getGoogleMAPKey();
}
