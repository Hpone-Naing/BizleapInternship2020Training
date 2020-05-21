package com.bizleap.merchant.domain.entities;


import com.bizleap.marchant.domain.enums.SeasonCategory;
import com.bizleap.merchant.service.impl.CandyBarPricing;
import com.bizleap.merchant.service.impl.UnknowCandyPricing;

public class Candy extends Product {

	public Candy(String name, double basePrice, double weight, String unit) {
		super(name, basePrice, weight, unit);
	}

	public void doPricing(SeasonCategory season) {
		setPricing(new UnknowCandyPricing(this));
		((CandyBarPricing) getPricing()).doPricing(season);
	}
}