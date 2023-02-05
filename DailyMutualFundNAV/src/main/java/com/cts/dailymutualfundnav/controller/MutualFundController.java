package com.cts.dailymutualfundnav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dailymutualfundnav.exception.MutualFundNotFoundException;
import com.cts.dailymutualfundnav.feignclient.AuthorizationClient;
import com.cts.dailymutualfundnav.model.MutualFund;
import com.cts.dailymutualfundnav.service.MutualFundService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/DailyMutualFundNAV")
public class MutualFundController {

	@Autowired
	private MutualFundService mutualFundService;

	@Autowired
	private AuthorizationClient authorizationClient;

	@GetMapping(value = "/{mutualFundName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MutualFund getMutualFundDetails(@RequestHeader("Authorization") String authorization,
			@PathVariable String mutualFundName) throws MutualFundNotFoundException {
		authorizationClient.getUname(authorization);
		log.info("Fetching MutualFund using MutualName");
		return mutualFundService.getByMutualFundName(mutualFundName);
	}
	
	@GetMapping(value="/allmf", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MutualFund> getAllMutualFund(@RequestHeader("Authorization") String authorization) throws MutualFundNotFoundException
	{
		authorizationClient.getUname(authorization);
		return mutualFundService.getAll();
	}

}
