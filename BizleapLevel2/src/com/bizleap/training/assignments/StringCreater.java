package com.bizleap.training.assignments;

public class StringCreater {

	public void createString() {
		String tenandId;
		long n = 999999999;
		long freeMemoyBefore = Runtime.getRuntime().freeMemory();
		System.out.println("Free memroy: " + freeMemoyBefore);

		do {
			tenandId = new String("Bizleap");
		} while (n-- > 0);

		long FreeMemoryNow = Runtime.getRuntime().freeMemory();
		System.out.println("Free/Used now: " + FreeMemoryNow + "\n" + (freeMemoyBefore - FreeMemoryNow ));
	}
}