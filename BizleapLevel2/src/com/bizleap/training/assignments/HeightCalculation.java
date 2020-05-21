package com.bizleap.training.assignments;

public class HeightCalculation {

	public Double getCalculatedTotalHeight(String personHeight) {
		Double totalHeight = 0.0;
		for (String height : StringUtil.getInstance().getWordList(personHeight)) {
			totalHeight = IntegerUtil.sum(totalHeight, Double.parseDouble(height));
		}
		return totalHeight;
	}
}