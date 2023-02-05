package com.cts.dailymutualfundnav.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8081", name = "AUTHORIZATION-SERVICE")
public interface AuthorizationClient {
	//end point
	@GetMapping("/getuname")
	public String getUname(@RequestHeader("Authorization") String authorization);

}
