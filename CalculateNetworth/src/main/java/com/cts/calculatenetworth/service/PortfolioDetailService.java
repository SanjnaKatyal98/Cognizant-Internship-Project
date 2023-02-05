package com.cts.calculatenetworth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.calculatenetworth.feignclient.DailyMutualFundNAVClient;
import com.cts.calculatenetworth.feignclient.DailySharePriceClient;
import com.cts.calculatenetworth.model.MutualFund;
import com.cts.calculatenetworth.model.PortfolioDetails;
import com.cts.calculatenetworth.model.StockDetail;
import com.cts.calculatenetworth.repository.PortfolioDetailsRepository;
import com.cts.calculatenetworth.vo.MutualFundVO;
import com.cts.calculatenetworth.vo.StockDetailsVO;

@Service
public class PortfolioDetailService {

	@Autowired
	private PortfolioDetailsRepository portfolioDetailsRepository;
	
	@Autowired
	private DailySharePriceClient sharePriceClient;
	
	@Autowired
	private DailyMutualFundNAVClient mutualFundClient;

	public List<PortfolioDetails> getAll() {
		return portfolioDetailsRepository.findAll();
	}

	public PortfolioDetails findByPfid(int id) {
		PortfolioDetails pfDetail = portfolioDetailsRepository.findByPortfolioid(id);
		if (pfDetail == null) {
			return null;
		}
		return pfDetail;
	}

	public double getcalculateNetworth(int id,String authorization) {
		double totalNetworth=0.0;
		PortfolioDetails pfDetail = findByPfid(id);
		List<StockDetail> stockDetail = pfDetail.getStockDetailList();
		List<MutualFund> mutualFund = pfDetail.getMutualFundList();
		for (StockDetail stock : stockDetail) {
			StockDetailsVO stockDetailsVO=sharePriceClient.getStockDetail(authorization,stock.getStockName());
			totalNetworth += stockDetailsVO.getStockValue() * stock.getStockCount();
		}
		for (MutualFund mfund : mutualFund) {
			MutualFundVO mutualFundVO=mutualFundClient.getMutualFundDetails(authorization,mfund.getMutualFundName());
			totalNetworth += mutualFundVO.getMutualFundValue() * mfund.getMutualFundUnits();
		}

		return totalNetworth;
	}

}
