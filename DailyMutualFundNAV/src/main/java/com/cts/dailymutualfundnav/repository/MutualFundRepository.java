package com.cts.dailymutualfundnav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.dailymutualfundnav.model.MutualFund;

@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund, Integer> {

	public List<MutualFund> findAll();
	public MutualFund findByMutualFundName(String mutualFundName);
}
