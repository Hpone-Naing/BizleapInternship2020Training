package com.bizleap.merchant.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.bizleap.marchant.domain.enums.CustomerType;
import com.bizleap.marchant.domain.enums.TemperatureCatagory;
import com.bizleap.merchant.domain.entities.Customer;
import com.bizleap.merchant.domain.entities.Flower;
import com.bizleap.merchant.domain.entities.Fruit;
import com.bizleap.merchant.domain.entities.HydratingFruit;
import com.bizleap.merchant.domain.entities.LeastHydrating;
import com.bizleap.merchant.domain.entities.LongShelfLife;
import com.bizleap.merchant.domain.entities.MediumHydrating;
import com.bizleap.merchant.domain.entities.MediumShelfLife;
import com.bizleap.merchant.domain.entities.MostHydrating;
import com.bizleap.merchant.domain.entities.Product;
import com.bizleap.merchant.domain.entities.Purchase;
import com.bizleap.merchant.domain.entities.ShelfLife;
import com.bizleap.merchant.domain.entities.ShortShelfLife;
import com.bizleap.merchant.service.impl.FruitService;

public class ProductService {

	public ProductService() {
		FruitInitializer.getInstance().initialize();
	}

	interface Initializer {
		public void initialize();
	}

	public static class FruitInitializer implements Initializer {

		private static FruitInitializer instance = null;
		private List<Product> flowerList = null;

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

		private void doInitialize() {
			flowerList = Arrays.asList((Product) new LongShelfLife("Rose", 10, 10, 2, "lb", 7, 2),
					new MediumShelfLife("Lanveder", 6, 6, 1, "lb", 4, 2),
					new MediumShelfLife("Cape Jasmine", 8, 8, 2, "lb", 5, 2),
					new ShortShelfLife("Aster", 5, 5, 6, "lb", 3, 2), new ShortShelfLife("Tulip", 5, 5, 3, "lb", 3, 2),
					new LongShelfLife("Orchid", 9, 9, 4, "lb", 7, 2),
					new MediumShelfLife("Sunflower", 6, 6, 9, "lb", 4, 2),
					new MediumShelfLife("Lily", 5, 5, 4, "lb", 5, 2), new ShortShelfLife("Dahly", 4, 4, 10, "lb", 3, 2),
					new ShortShelfLife("Marigold", 8, 8, 4, "lb", 3, 2),
					new LongShelfLife("Butter cup", 4, 4, 7, "lb", 6, 2),
					new MediumShelfLife("Camelia", 2, 2, 10, "lb", 6, 2),
					new LongShelfLife("Tuberrose", 7, 7, 8, "lb", 6, 2),
					new LongShelfLife("Peony", 4, 4, 8, "lb", 7, 2));
		}

		@Override
		public void initialize() {
			doInitialize();
		}
	}

	public List<Product> getAllFruitListByTemperature() {
		List<Product> fruitList = new ArrayList<Product>();
		for (Product flower : FruitInitializer.getInstance().flowerList) {
			((ShelfLife) flower).doPricing();
			fruitList.add(new Flower(flower.getName(), flower.getBasePrice(), flower.getPrice(), flower.getWeight(),
					flower.getUnit(), ((Flower) flower).getExpireDate(), ((Flower) flower).getStorageDate()));
		}
		System.out.println(fruitList);
		return fruitList;
	}

	public static void main(String[] args) {
		for (Product product : new ProductService().getAllFruitListByTemperature()) {
			System.out.println("frit name: " + product.getName() + ", fruit base price: " + product.getBasePrice()
					+ ", fruit price: " + product.getPrice() + ", fruit weight: " + product.getWeight()
					+ ", fruit weight unit: " + product.getUnit() + ", flower shelf life: " + ((Flower) product).getExpireDate() + ", flower storage date: " + ((Flower) product).getStorageDate());
		}
	}
}
