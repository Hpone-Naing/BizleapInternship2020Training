package com.bizleap.merchant.service;

import java.util.List;

import com.bizleap.merchant.domain.entities.PurchaseRecord;

public interface DataLoader {

	List<PurchaseRecord> loadPurchaseRecord() throws Exception;
	int getIndex();
	void setIndex(int index);
}
