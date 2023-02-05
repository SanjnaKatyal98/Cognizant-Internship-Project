package com.cts.calculatenetworth.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="portfolio")
public class PortfolioDetails {
	
	@Id
	@GeneratedValue
	@Column(name="portfolio_id") 
	private Integer portfolioid;
	
	@JsonManagedReference
	@OneToMany(mappedBy="portfolioDetails",cascade={CascadeType.MERGE},fetch=FetchType.LAZY)
	private List<StockDetail> stockDetailList=new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="portfolioDetails",cascade={CascadeType.MERGE},fetch=FetchType.LAZY)
	private List<MutualFund> mutualFundList=new ArrayList<>();
	
	
}
