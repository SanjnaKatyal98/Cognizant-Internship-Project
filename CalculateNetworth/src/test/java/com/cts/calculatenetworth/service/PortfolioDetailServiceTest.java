package com.cts.calculatenetworth.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.calculatenetworth.model.MutualFund;
import com.cts.calculatenetworth.model.PortfolioDetails;
import com.cts.calculatenetworth.model.StockDetail;
import com.cts.calculatenetworth.repository.PortfolioDetailsRepository;

@SpringBootTest
class PortfolioDetailServiceTest {
	@MockBean
	private PortfolioDetailsRepository portfolioDetailsRepository;

	@Autowired
	private PortfolioDetailService portfolioDetailService;

	MutualFund mutualFund=new MutualFund(10,"CTS",10);
	MutualFund mutualFund1=new MutualFund(11,"SBI",10);
	
	StockDetail stockDetail=new  StockDetail(21,"GGE",10);
	StockDetail stockDetail1=new  StockDetail(22,"YHO",10);
	



	@Test
	void testPortfolioDetails() {
		List<MutualFund> mfList = new ArrayList<>();
		mfList.add(mutualFund);
		List<StockDetail> sdList = new ArrayList<>();
		sdList.add(stockDetail);
		PortfolioDetails portfolioDetails = new PortfolioDetails(101, sdList, mfList);

		Mockito.when(portfolioDetailsRepository.findByPortfolioid(101)).thenReturn(portfolioDetails);
		assertEquals(portfolioDetails, portfolioDetailService.findByPfid(101));
		status().isOk();
	}

	@Test
	void testGetAll() {
		List<MutualFund> mfList = new ArrayList<>();
		mfList.add(mutualFund);
		List<StockDetail> sdList = new ArrayList<>();
		sdList.add(stockDetail);
		PortfolioDetails portfolioDetails = new PortfolioDetails(101, sdList, mfList);
		
		List<MutualFund> mfList1 = new ArrayList<>();
		mfList1.add(mutualFund);
		List<StockDetail> sdList1 = new ArrayList<>();
		sdList1.add(stockDetail);
		PortfolioDetails portfolioDetails1 = new PortfolioDetails(102, sdList1, mfList1);
		
		List<PortfolioDetails> records = new ArrayList<>(Arrays.asList(portfolioDetails, portfolioDetails1));

		Mockito.when(portfolioDetailsRepository.findAll()).thenReturn(records);
		assertEquals(records, portfolioDetailService.getAll());
		status().isOk();
	}

}
