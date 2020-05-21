package com.hponenaingtun.java.test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import com.bizleap.training.assignments.Student;
import com.bizleap.training.enums.SexCategory;

public class SteramTest {

	public static void main(String[] args) {
		List<String> charList = new ArrayList<String>();
		charList.add("a");
		charList.add("b");
		charList.add("c");
		charList.add("d");
		charList.add("e");

		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5);

		int numberList[] = new int[] { 6, 5, 4, 3, 2, 1 };
		String stringList[] = { "A", "B", "C", "D", "E" };

		List<Student> studentList = new ArrayList<Student>();
//		studentList.add(new Student("a", "a@gmail.com", SexCategory.MALE));
//		studentList.add(new Student("b", "b@gmail.com", SexCategory.MALE));
//		studentList.add(new Student("c", "c@gmail.com", SexCategory.FEMALE));
//		studentList.add(new Student("d", "d@gmail.com", SexCategory.MALE));
//		studentList.add(new Student("e", "e@gmail.com", SexCategory.MALE));

		/*
		 * create Stream from source eg..Arrays, Collection, I/O channel
		 * Stream.of() This method returns the stream that is a sequential
		 * ordered stream whose elements are the specified values. You can
		 * obtain a stream by simply use of the source. For example, here we are
		 * getting a stream by Arrays and List.
		 */
		Stream<List<String>> stream = Stream.of(charList);
		stream.forEach(item -> System.out.println("Test stream creation using Stream.of() method: " + item));

		Stream.of(stringList).forEach(
				item -> System.out.println("Test stream creation using Stream.of() method: " + item.toUpperCase()));

		Stream.of(studentList)
				.forEach(student -> System.out.println("Test stream creation using Stream.of() method: " + student));

		/*
		 * another way create stream from source eg..Arrays, Collection, I/O
		 * channel This method returns the sequential stream of the source. It
		 * is a default method of Collection Interface. Note...stream() method
		 * only use for Collection because it is default collection interface.
		 */
		charList.stream().forEach(item -> System.out.println("Test stream creation using stream() method: " + item));
		studentList.stream()
				.forEach(student -> System.out.println("Test stream creation using stream() method: " + student));

		/*
		 * parallelStream
		 * 
		 * it is default method of collection interface
		 */
		System.out.println("test parallel stream method......");
		charList.stream().forEach(System.out::println);
		Stream.of(studentList).forEach(System.out::println);
		integerList.stream().forEach(System.out::println);

		/*
		 * create stream from arrays. not collection stream(T[] array): This
		 * method is used to a stream from Array. It returns a sequential stream
		 * from the source.
		 */
		Arrays.stream(numberList).forEach(item -> System.out.println("testing item create stream from arrays " + item));
		Arrays.stream(stringList).forEach(item -> System.out.println("testing item create stream from arrays " + item));

		/*
		 * chars(): This method is used to a stream from String. It returns an
		 * IntStream from the source.
		 */
		new String("Hpone Naing Tun").chars().forEach(item -> System.out.println("testing chars() method: " + item));

		/*
		 * use intermediate operation Stream.filter()
		 */
		System.out.println("using intermediate operation filter method that filter numbers which is greater than 2");
		integerList.stream().filter(num -> num > 2).forEach(System.out::println);
		System.out.println("using intermediate operation filter method that filter numbers which is less than 5");
		Arrays.stream(numberList).filter(num -> num < 5).forEach(System.out::println);
		studentList.stream().filter((student) -> student.getSexCategory().equals(SexCategory.FEMALE))
				.forEach(System.out::print);

		/*
		 * use intermediate operation map()
		 */
		System.out.println("using intermediate operation map method that map numbers which is power of 2");
		Arrays.stream(numberList).mapToDouble(num -> Math.pow(Double.valueOf(num), 2.0)).forEach(System.out::println);
		System.out.println("using intermediate operation map method that map character convert to lowercase");
		Arrays.stream(stringList).map(ch -> ch.toLowerCase()).forEach(System.out::println);
		System.out.println("using intermediate operation map method that map Student name convert to uppercase");
		studentList.stream().map(student -> student.getName().toUpperCase()).forEach(stud -> System.out.println(stud));

		/*
		 * use sort() intermedate operation
		 * 
		 */
		System.out.println("using intermediate operation sort method that sort numbers ");
		Arrays.stream(numberList).sorted().forEach(System.out::print);
		System.out.println();
		Integer duplicateArray[] = { 1, 2, 5, 6, 1, 2, 8, 6, 4, 4, 5, 9 };
		List<Integer> duplicateList = new ArrayList<Integer>();
		duplicateList.addAll(Arrays.asList(duplicateArray));
		Arrays.stream(duplicateArray).distinct().forEach(System.out::print);
		System.out.println();
		duplicateList.stream().distinct().forEach(System.out::print);
	}
}
