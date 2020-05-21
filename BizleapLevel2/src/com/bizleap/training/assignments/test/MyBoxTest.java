package com.bizleap.training.assignments.test;

import com.bizleap.training.assignments.MyBox;
import com.bizleap.training.assignments.Student;
import com.bizleap.training.enums.SexCategory;

public class MyBoxTest {

	public static void main(String[] args) {
		MyBox<String> stringObj = new MyBox<String>("1");
		System.out.println("Assign string: " + stringObj);
		
		MyBox<Integer> intObj = new MyBox<Integer>(1);
		System.out.println("Assign integer: " + intObj);
		
		MyBox<Double> doubleObj = new MyBox<Double>(99.99);
		System.out.println("Assign double: " + doubleObj);
		
		MyBox<Float> floatObj = new MyBox<Float>((float) 1.1);
		System.out.println("Assign float: " + floatObj);

		MyBox<Long> longObj = new MyBox<Long>(new Long(999999999));
		System.out.println("Assign long: " + longObj);
		
		MyBox<Boolean> booleanObj = new MyBox<Boolean>(true);
		System.out.println("Assign booleanObj: " + booleanObj);
		
		MyBox<Student> studentObj = new MyBox<Student>(new Student("a", 18, "a@g", SexCategory.FEMALE, "09123"));
		System.out.println("Assign student: " + studentObj);
		
	
	}
}
