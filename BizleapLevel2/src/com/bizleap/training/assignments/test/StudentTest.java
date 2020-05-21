package com.bizleap.training.assignments.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import com.bizleap.training.assignments.Student;
import com.bizleap.training.assignments.StudentUtil1;
import com.bizleap.training.enums.SexCategory;

public class StudentTest {

	public static void main(String[] args) {
		Student students[] = new Student[] { new Student("mgmg", 18, "mgmg@gmail.com", SexCategory.MALE, "+959123"),
				new Student("aung aung", 18, "aungaung@gmail.com", SexCategory.MALE, "+959123"),
				new Student("hla hla", 18, "hlahla@gmail.com", SexCategory.FEMALE, "+123"),
				new Student("mya mya", 18, "myamya@gmail.com", SexCategory.FEMALE, "+234"),
				new Student("bo aung din", 19, "boaungdin@gmail.com", SexCategory.MALE, "+123"),
				new Student("poe lay", 20, "poelay@gmail.com", SexCategory.FEMALE, "+123"),
				new Student("khaing lay", 20, "khainglay@gmail.com", SexCategory.FEMALE, "123"),
				new Student("ei ei", 21, "eiei@gmail.com", SexCategory.FEMALE, "1"),
				new Student("ei khaing", 20, "eikhaing@gmail.com", SexCategory.FEMALE, "2")};
//		System.out.println("Student with sex type of female: "
//				+ StudentUtil1.getInstance().getAllStudentBySex(Arrays.asList(students), SexCategory.FEMALE));
//		List<Entry<Student, String>> sortedArrivalStudent = StudentUtil1.getInstance()
//				.getAllSortedArrivalStudents(Arrays.asList(students));
		//System.out.println("sorted arrival time student: " + sortedArrivalStudent);
		//System.out.println("awarded student: " + StudentUtil1.getInstance().getAllAwardedStudentList(sortedArrivalStudent));
	    System.out.println("words and characters count of students's name" + StudentUtil1.getInstance().getStudentNameWordCharacterCountPairs(Arrays.asList(students)));
	}

}
