package com.bizleap.merchant.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bizleap.marchant.domain.enums.CustomerType;
import com.bizleap.marchant.domain.enums.TemperatureCatagory;
import com.bizleap.merchant.domain.entities.Customer;
import com.bizleap.merchant.domain.entities.Fruit;
import com.bizleap.merchant.domain.entities.HydratingFruit;
import com.bizleap.merchant.domain.entities.LeastHydrating;
import com.bizleap.merchant.domain.entities.MediumHydrating;
import com.bizleap.merchant.domain.entities.MostHydrating;
import com.bizleap.merchant.domain.entities.Purchase;

public class FruitService {

	public FruitService() {
		FruitInitializer.getInstance().initialize();
	}

	interface Initializer {
		public void initialize();
	}

	public static class FruitInitializer implements Initializer {

		private static FruitInitializer instance = null;
		private List<Fruit> hydratingFruitList = null;
		private Map<String, List<Fruit>> hydratingFruitTypeMap = null;
		private Map<Double, List<Fruit>> hydratingFruitPriceMap = null;
		private List<Purchase> purchasedList = null;

		private FruitInitializer() {
		}

		public static FruitInitializer getInstance() {
			if (instance == null)
				synchronized (FruitService.class) {
					if (instance == null)
						instance = new FruitInitializer();
				}
			return instance;
		}

		public List<Purchase> getPurchasedList() {
			return purchasedList;
		}

		public void setPurchasedList(List<Purchase> purchasedList) {
			this.purchasedList = purchasedList;
		}

		private void doInitialize() {
			hydratingFruitList = Arrays.asList((Fruit) new MostHydrating("Water Mellon", 20, 10, "lb"),
					new MostHydrating("Piapple", 40, 5, "lb"), new MostHydrating("Blue Berry", 20, 5, "lb"),
					new MostHydrating("Grape", 45, 6, "lb"), new MostHydrating("Cherries", 40, 8, "lb"),
					new MostHydrating("Honey drew", 45, 4, "lb"), new MostHydrating("Mango", 50, 9, "lb"),
					new MostHydrating("Orange", 45, 4, "lb"), new MediumHydrating("Peach", 45, 10, "lb"),
					new MediumHydrating("Pair Apple", 45, 30, "lb"), new MediumHydrating("Guava", 45, 6, "lb"),
					new MediumHydrating("Kiwi", 70, 8, "lb"), new MediumHydrating("Dragon Fruit", 20, 7, "lb"),
					new LeastHydrating("Banana", 70, 10, "lb"), new LeastHydrating("avogado", 45, 8, "lb"),
					new LeastHydrating("jackfruit", 80, 5, "lb"), new LeastHydrating("Bread Fruit", 40, 7, "lb"),
					new LeastHydrating("Passion Fruit", 70, 8, "lb"));

			if (hydratingFruitTypeMap == null)
				hydratingFruitTypeMap = new HashMap<String, List<Fruit>>();
			if (hydratingFruitPriceMap == null)
				hydratingFruitPriceMap = new HashMap<Double, List<Fruit>>();
		}

		private void pupulateFruitTypeMap() {
			List<Fruit> sameFruitTypeList = null;
			for (Fruit fruit : hydratingFruitList) {
				sameFruitTypeList = hydratingFruitTypeMap.get(fruit.getFruitType());
				if (sameFruitTypeList == null) {
					sameFruitTypeList = new ArrayList<Fruit>();
					sameFruitTypeList.add(fruit);
				} else {
					sameFruitTypeList.add(fruit);
				}
				hydratingFruitTypeMap.put(fruit.getFruitType(), sameFruitTypeList);
			}
		}

		private void pupulateFruitPriceMap() {
			List<Fruit> sameFruitPriceList = null;
			for (Fruit fruit : hydratingFruitList) {
				sameFruitPriceList = hydratingFruitPriceMap.get(fruit.getPrice());
				if (sameFruitPriceList == null) {
					sameFruitPriceList = new ArrayList<Fruit>();
					sameFruitPriceList.add(fruit);
				} else {
					sameFruitPriceList.add(fruit);
				}
				hydratingFruitPriceMap.put(fruit.getPrice(), sameFruitPriceList);
			}
		}

		private void purchase() {
			purchasedList = Arrays.asList(
					new Purchase(new Customer("Theint Thu Thu Aung", CustomerType.REGULAR), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Sandar Win", CustomerType.VALUED), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Sandar Win", CustomerType.VALUED), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Htet Wai Lin", CustomerType.VOLUMED), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Kaung Nyunt Hlaing", CustomerType.REGULAR), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Hlwam Moe Hein", CustomerType.VALUED), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Phoo Pwint Thu", CustomerType.VOLUMED), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Thuzar Hlaing", CustomerType.REGULAR), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Phyu Pwint Endrain", CustomerType.VALUED), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Saw Than Shwe", CustomerType.VALUED), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Ei Ei Thone", CustomerType.VOLUMED), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Aye Chan Nyein", CustomerType.REGULAR), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Naw Phaw Hkee Lar My", CustomerType.VALUED), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)),
					new Purchase(new Customer("Min Thant Khant", CustomerType.VOLUMED), hydratingFruitList,
							getTotalBasePrice(hydratingFruitList)));
		}

		private double getTotalBasePrice(List<Fruit> fruitList) {
			int total = 0;
			for (Fruit fruit : fruitList) {
				total += fruit.getBasePrice();
			}
			return total;
		}

		public void initialize() {
			doInitialize();
			pupulateFruitTypeMap();
			pupulateFruitPriceMap();
			purchase();
		}
	}

	public List<Fruit> getAllFruitListByTemperature(TemperatureCatagory temperature) {
		List<Fruit> fruitList = new ArrayList<Fruit>();
		for (List<Fruit> fruits : FruitInitializer.getInstance().hydratingFruitTypeMap.values()) {
			for (Fruit fruit : fruits) {
				fruitList.add(new Fruit(fruit.getName(), ((HydratingFruit) fruit).calculatePrice(temperature),
						fruit.getWeight(), fruit.getUnit()));
			}
		}
		return fruitList;
	}
	
	public List<Purchase> getAllCustomerPurchasedFruitListWithDiscount() {
		List<Purchase> purchasedList = new ArrayList<Purchase>();
		for (Purchase purchase : FruitInitializer.getInstance().getPurchasedList()) {
			List<Fruit> purchaseFruitList = new ArrayList<Fruit>();
			for (Fruit fruit : purchase.getFruitList()) {
				fruit.doPricing(purchase);
				System.out.println("customer name: " + purchase.getCustomer().getName() + ", customer type : "
						+ purchase.getCustomer().getCustomertype());
				System.out.println("price: " + fruit.getPrice());
				purchaseFruitList.add(new Fruit(fruit.getName(), fruit.getBasePrice(), fruit.getPrice(),
						fruit.getWeight(), fruit.getUnit()));
			}
			purchasedList.add(new Purchase(purchase.getCustomer(), purchaseFruitList, purchase.getTotalPrice(),
					purchase.getDiscountTotalPrice()));
		}
		return purchasedList;
	}

	public static void main(String[] args) {
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