package com.bizleap.merchant.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.chainsaw.Main;

import com.bizleap.merchant.domain.entities.PurchaseRecord;
import com.bizleap.merchant.service.DataLoader;
import com.bizleap.merchant.service.FileLoader;
import com.bizleap.merchant.util.BizleapUtils;;

public class DataLoaderImpl implements DataLoader {

	private FileLoader fileLoader = null;

	// private ErrorHandler errorHandler;

	// @Value("${application.path}")
	String path = "D:\\bizleap2020internshipdatafile\\data";

	// public Map<Integer, Error> errorMap;
	public int index = 1;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getFullPath(String fileName) {
		return BizleapUtils.makePath(path, fileName);
	}

	public List<PurchaseRecord> loadPurchaseRecord() throws Exception {
		fileLoader = new FileLoaderImpl();
		fileLoader.start(getFullPath("purchaserecord.txt"));
		String dataLine = "";
		List<PurchaseRecord> purchaseRecordList = new ArrayList<PurchaseRecord>();
		PurchaseRecord purchaseRecord = null;
		while (fileLoader.hasMore()) {
			try {
				dataLine = fileLoader.getLine();
				purchaseRecord = PurchaseRecord.parsePurchaseRecord(dataLine);
				if (purchaseRecord != null) {
					purchaseRecordList.add(purchaseRecord);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
				// errorHandler.handleLoadingError(fileLoader.getLineNumber(),"Location
				// file loading: "+e.toString(),fileLoader.getLine());
			}
		}
		fileLoader.finish();
		return purchaseRecordList;
	}
}