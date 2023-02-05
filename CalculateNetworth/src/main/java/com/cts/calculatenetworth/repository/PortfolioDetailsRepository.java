package com.cts.calculatenetworth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.calculatenetworth.model.PortfolioDetails;

public interface PortfolioDetailsRepository extends JpaRepository<PortfolioDetails, Integer> {
	public PortfolioDetails findByPortfolioid(int id);

}
