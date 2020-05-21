//package com.bizleap.assignment32.service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.bizleap.assignment32.entities.Fruit;
//import com.bizleap.assignment32.entities.HydratingFruit;
//import com.bizleap.assignment32.entities.LeastHydrating;
//import com.bizleap.assignment32.entities.MediumHydrating;
//import com.bizleap.assignment32.entities.MostHydrating;
//import com.bizleap.training.enums.CustomerType;
//import com.bizleap.training.enums.TemperatureCatagory;
//import com.bizleap.training.oop.entities.assignments.Customer;
//import com.bizleap.training.oop.entities.assignments.DiscountCalculation;
//
//
//public class FruitService {
//
//	private DiscountCalculation discountCalculation = null;
//
//	public FruitService() {
//		FruitInitializer.getInstance().initialize();
//		discountCalculation = getDiscountInstance();
//	}
//
//	public DiscountCalculation getDiscountInstance() {
//		if (discountCalculation == null)
//			synchronized (DiscountCalculation.class) {
//				if (discountCalculation == null)
//					discountCalculation = new DiscountCalculation();
//			}
//		return discountCalculation;
//	}
//
//	interface Initializer {
//		public void initialize();
//	}
//
//	public static class FruitInitializer implements Initializer {
//
//		private static FruitInitializer instance = null;
//		private List<Fruit> hydratingFruitList = null;
//		private Map<String, List<Fruit>> hydratingFruitTypeMap = null;
//		private Map<Double, List<Fruit>> hydratingFruitPriceMap = null;
//		private List<Customer> customerPurchaseFruitList = null;
//		private List<Fruit> purchasedFruitList = null;
//		private FruitInitializer() {
//		}
//
//		public static FruitInitializer getInstance() {
//			if (instance == null)
//				synchronized (FruitService.class) {
//					if (instance == null)
//						instance = new FruitInitializer();
//				}
//			return instance;
//		}
//
//		public List<Customer> getCustomerPurchaseFruitList() {
//			return customerPurchaseFruitList;
//		}
//
//		private void doInitialize() {
//			hydratingFruitList = Arrays.asList(new MostHydrating("Water Mellon", 20, 10, "lb"),
//					new MostHydrating("Piapple", 40, 5, "lb"), new MostHydrating("Blue Berry", 20, 5, "lb"),
//					new MostHydrating("Grape", 45, 6, "lb"), new MostHydrating("Cherries", 40, 8, "lb"),
//					new MostHydrating("Honey drew", 45, 4, "lb"), new MostHydrating("Mango", 50, 9, "lb"),
//					new MostHydrating("Orange", 45, 4, "lb"), new MediumHydrating("Peach", 45, 10, "lb"),
//					new MediumHydrating("Pair Apple", 45, 30, "lb"), new MediumHydrating("Guava", 45, 6, "lb"),
//					new MediumHydrating("Kiwi", 70, 8, "lb"), new MediumHydrating("Dragon Fruit", 20, 7, "lb"),
//					new LeastHydrating("Banana", 70, 10, "lb"), new LeastHydrating("avogado", 45, 8, "lb"),
//					new LeastHydrating("jackfruit", 80, 5, "lb"), new LeastHydrating("Bread Fruit", 40, 7, "lb"),
//					new LeastHydrating("Passion Fruit", 70, 8, "lb"));
//
//			if (hydratingFruitTypeMap == null)
//				hydratingFruitTypeMap = new HashMap<String, List<Fruit>>();
//			if (hydratingFruitPriceMap == null)
//				hydratingFruitPriceMap = new HashMap<Double, List<Fruit>>();
//		}
//
//		private void pupulateFruitTypeMap() {
//			List<Fruit> sameFruitTypeList = null;
//			for (Fruit fruit : hydratingFruitList) {
//				sameFruitTypeList = hydratingFruitTypeMap.get(fruit.getFruitType());
//				if (sameFruitTypeList == null) {
//					sameFruitTypeList = new ArrayList<Fruit>();
//					sameFruitTypeList.add(fruit);
//				} else {
//					sameFruitTypeList.add(fruit);
//				}
//				hydratingFruitTypeMap.put(fruit.getFruitType(), sameFruitTypeList);
//			}
//		}
//
//		private void pupulateFruitPriceMap() {
//			List<Fruit> sameFruitPriceList = null;
//			for (Fruit fruit : hydratingFruitList) {
//				sameFruitPriceList = hydratingFruitPriceMap.get(fruit.getPrice());
//				if (sameFruitPriceList == null) {
//					sameFruitPriceList = new ArrayList<Fruit>();
//					sameFruitPriceList.add(fruit);
//				} else {
//					sameFruitPriceList.add(fruit);
//				}
//				hydratingFruitPriceMap.put(fruit.getPrice(), sameFruitPriceList);
//			}
//		}
//
//		private void purchase() {
//			purchasedFruitList = Arrays.asList(new MostHydrating("Water Mellon", 20, 10, "lb"),
//					new MostHydrating("Piapple", 40, 5, "lb"), new MostHydrating("Blue Berry", 20, 5, "lb"),
//					new MostHydrating("Grape", 45, 6, "lb"), new MostHydrating("Cherries", 40, 8, "lb"),
//					new MostHydrating("Honey drew", 45, 4, "lb"), new MostHydrating("Mango", 50, 9, "lb"),
//					new MostHydrating("Orange", 45, 4, "lb"), new MediumHydrating("Peach", 45, 10, "lb"),
//					new MediumHydrating("Pair Apple", 45, 30, "lb"), new MediumHydrating("Guava", 45, 6, "lb"),
//					new MediumHydrating("Kiwi", 70, 8, "lb"), new MediumHydrating("Dragon Fruit", 20, 7, "lb"),
//					new LeastHydrating("Banana", 70, 10, "lb"), new LeastHydrating("avogado", 45, 8, "lb"),
//					new LeastHydrating("jackfruit", 80, 5, "lb"), new LeastHydrating("Bread Fruit", 40, 7, "lb"),
//					new LeastHydrating("Passion Fruit", 70, 8, "lb"));
//			
//			customerPurchaseFruitList = Arrays.asList(
//					new Customer("Theint Thu Thu Aung", CustomerType.REGULAR, hydratingFruitList),
//					new Customer("Sandar Win", CustomerType.VALUED, hydratingFruitList),
//					new Customer("Htet Wai Lin", CustomerType.VOLUMED, hydratingFruitList),
//					new Customer("Kaung Nyunt Hlaing", CustomerType.REGULAR, hydratingFruitList),
//					new Customer("Hlwam Moe Hein", CustomerType.VALUED, hydratingFruitList),
//					new Customer("Phoo Pwint Thu", CustomerType.VOLUMED, hydratingFruitList),
//					new Customer("Thuzar Hlaing", CustomerType.REGULAR, hydratingFruitList),
//					new Customer("Phyu Pwint Endrain", CustomerType.VALUED, hydratingFruitList),
//					new Customer("Saw Than Shwe", CustomerType.VOLUMED, hydratingFruitList),
//					new Customer("Ei Ei Thone", CustomerType.REGULAR, hydratingFruitList),
//					new Customer("Aye Chan Nyein", CustomerType.VALUED, hydratingFruitList),
//					new Customer("Naw Phaw Hkee Lar Mya", CustomerType.VOLUMED, hydratingFruitList),
//					new Customer("Min Thant Khant", CustomerType.REGULAR, hydratingFruitList));
//		}
//
//		public void initialize() {
//			doInitialize();
//			pupulateFruitTypeMap();
//			pupulateFruitPriceMap();
//			purchase();
//		}
//	}
//
//	public List<Fruit> getAllFruitListByTemperature(TemperatureCatagory temperature) {
//		List<Fruit> fruitList = new ArrayList<Fruit>();
//		for (List<Fruit> fruits : FruitInitializer.getInstance().hydratingFruitTypeMap.values()) {
//			for (Fruit fruit : fruits) {
//				fruitList.add(new Fruit(fruit.getName(), ((HydratingFruit) fruit).calculatePrice(temperature),
//						fruit.getWeight(),fruit.getUnit()));
//			}
//		}
//		return fruitList;
//	}
//
//	public void displayAllCustomerPurchasedFruitListWithDiscount() {
//		for (Customer customer : FruitInitializer.getInstance().getCustomerPurchaseFruitList()) {
//			System.out
//					.println("\ncustomer name: " + customer.getName() + ", customer type: " + customer.getCustomertype());
//			for (Fruit fruit : customer.getFruitList()) {
//				System.out.println("fruit name: " + fruit.getName() + ", fruit base price: " + fruit.getBasePrice()
//						+ ", actual fruit price: " + fruit.getPrice() + ", fruit weight: " + fruit.getWeight() + ", calculated discount price: " + discountCalculation.calculateDiscount(customer,fruit));
//			}
//			
//		}
//	}
//
//	public static void main(String[] args) {
//		new FruitService().displayAllCustomerPurchasedFruitListWithDiscount();
//	}
//}