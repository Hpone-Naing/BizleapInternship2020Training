package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class BirthdayGuestUtil {

	private static BirthdayGuestUtil birthdayGuestUtil = null;

	private BirthdayGuestUtil() {
		super();
	}

	public static synchronized BirthdayGuestUtil getInstance() {
		if (birthdayGuestUtil == null)
			birthdayGuestUtil = new BirthdayGuestUtil();
		return birthdayGuestUtil;
	}

	public List<String> getAllServedStudentList(List<Entry<Student, String>> sortedArrivalGuestList) {
		List<String> awardedStudentList = null;
		for (Entry<Student, String> guest : sortedArrivalGuestList) {
			if (awardedStudentList == null)
				awardedStudentList = new ArrayList<>();
			awardedStudentList.add(((BirthdayGuest) guest.getKey()).serve());
		}
		return awardedStudentList;
	}
}
