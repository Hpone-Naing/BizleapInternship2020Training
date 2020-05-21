package com.bizleap.training.assignments.test;

import com.bizleap.training.assignments.StringOperation;

public class StringOperationTest {

	public static void main(String[] args) {
		StringOperation stringOperation = new StringOperation("Hpone Naing Tun");
		System.out.println("Is Hpone Naing Tun equals Hpone Naing Tun: " + stringOperation.equals("Hpone Naing Tun"));
		System.out.println("Is Hpone Naing Tun equals Tun Naing Hpone: " + stringOperation.equals("Tun Naing Hpone"));

		System.out.println("Length of Hpone Naing Tun: " + stringOperation.length());

		System.out.println("Is Naing contain: " + stringOperation.contains("Naing"));
		System.out.println("Is nuT contain: " + stringOperation.contains("nuT"));

		System.out.println("After replacing all n with e: " + stringOperation.replace('n', 'e'));

		System.out.println("Is sequence Hpone Naing Tun start with 'Hpone': " + stringOperation.startsWith("Hpone"));
		System.out.println("Is sequence Hpone Naing Tun start with 'Hpone': " + stringOperation.startsWith("Naing"));

		System.out.println("Is sequence Hpone Naing Tun end with 'Hpone': " + stringOperation.endsWith("Tun"));
		System.out.println("Is sequence Hpone Naing Tun end with 'Hpone': " + stringOperation.endsWith("Naing"));
		System.out.println("Is sequence Hpone Naing Tun end with 'Hpone': " + stringOperation.endsWith("Tun"));
		
		System.out.println("Hpone Naing Tun Concact UCSY  " + stringOperation.concat("UCSY"));
		
		System.out.println("UpperCase of Hpone Naing Tun: " + stringOperation.toUpperCase());
		System.out.println("LowerCase of Hpone Naing Tun: " + stringOperation.toLowerCase());
	}
}
