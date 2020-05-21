package com.bizleap.marchant.service.test;

import org.junit.Test;

import com.bizleap.merchant.domain.entities.Fruit;
import com.bizleap.merchant.domain.entities.Purchase;
import com.bizleap.merchant.service.FruitService;

public class FruitServiceTest extends ServiceTest {

	@Test
	public void test() {
		for (Purchase purchase : new FruitService().getAllCustomerPurchasedFruitListWithDiscount()) {
			System.out.println("\ncustomer name: " + purchase.getCustomer().getName() + ", customer type: "
					+ purchase.getCustomer().getCustomertype());
			for (Fruit fruit : purchase.getFruitList()) {
				System.out.println("frit name: " + fruit.getName() + ", fruit base price: " + fruit.getBasePrice()
						+ ", fruit price: " + fruit.getPrice() + ", fruit weight: " + fruit.getWeight()
						+ ", fruit weight unit: " + fruit.getUnit());
			}
			System.out.println("customer: " + purchase.getCustomer().getName() + " Total Price: "
					+ purchase.getTotalPrice() + ",discount price: " + purchase.getDiscountTotalPrice());
		}
	}
}