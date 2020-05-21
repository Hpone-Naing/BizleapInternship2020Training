package com.bizleap.merchant.service.impl;

import com.bizleap.merchant.domain.entities.PurchaseRecord;
import com.bizleap.merchant.service.impl.DataLoaderImpl;

public class Seller {

	double flowerInitialOrder = 22500;
	double fruitInitialOrder = 80000;
	double candyBarInitialOrder = 66000;
	private DataLoader dataLoader;

	public void restock() throws Exception {
		dataLoader = new DataLoaderImpl();
		for (PurchaseRecord purchaseRecord : dataLoader.loadPurchaseRecord()) {
			switch (purchaseRecord.getProduct().getProductType()) {
			case FLOWER :
				flowerInitialOrder -= purchaseRecord.getQuantity();
				 if (flowerInitialOrder <= 100)
				 System.out.println("flower restock at: " + purchaseRecord.getDate());
		    break;
			case FRUIT : 
				 flowerInitialOrder -= purchaseRecord.getQuantity();
					 if (flowerInitialOrder <= 100) 
						 System.out.println("flower restock at: " +  purchaseRecord.getDate());
		    break;
		    default : 
		    	candyBarInitialOrder -= purchaseRecord.getQuantity();
				 if (candyBarInitialOrder <= 100)
				 System.out.println("CandyBar restock at: " + purchaseRecord.getDate());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new Seller().restock();
	}
}
