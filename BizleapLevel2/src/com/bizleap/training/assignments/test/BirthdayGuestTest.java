package com.bizleap.training.assignments.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import com.bizleap.training.assignments.BirthdayGuest;
import com.bizleap.training.assignments.BirthdayGuestUtil;
import com.bizleap.training.assignments.Student;

public class BirthdayGuestTest {

	public static void main(String[] args) {
		BirthdayGuest students[] = new BirthdayGuest[] { new BirthdayGuest("mgmg"), new BirthdayGuest("aung aung"),
				new BirthdayGuest("hla hla"), new BirthdayGuest("mya mya"), new BirthdayGuest("bo aung din"),
				new BirthdayGuest("poe lay"), new BirthdayGuest("khaing lay"), new BirthdayGuest("ei ei"),
				new BirthdayGuest("ei khaing") };
	//	List<Entry<Student, String>> sortedArrivalGueseList = BirthdayGuestUtil.getInstance().getAllSortedArrivalStudents(Arrays.asList(students));
//		System.out.println("service ice-cream to student who arriveed birthday party first: " + BirthdayGuestUtil.getInstance().getAllServedStudentList(sortedArrivalGueseList));
	}
}
