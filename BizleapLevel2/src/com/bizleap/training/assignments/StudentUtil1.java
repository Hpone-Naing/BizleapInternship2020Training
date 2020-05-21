package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.bizleap.training.enums.SexCategory;

public class StudentUtil1 {

	private static StudentUtil1 instance = null;

	private StudentUtil1() {
	}

	public static synchronized StudentUtil1 getInstance() {
		if (instance == null)
			instance = new StudentUtil1();
		return instance;
	}

	public List<Student> getAllStudentBySex(List<Student> studentList, SexCategory sexType) {
		List<Student> sameSexTypeStudentList = new ArrayList<Student>();
		if (studentList != null) {
			for (Student student : studentList) {
				if (student.isSameSex(sexType))
					sameSexTypeStudentList.add(student);
			}
		}
		return sameSexTypeStudentList;
	}

//	public List<Entry<Student, String>> getAllSortedArrivalStudents(List<Student> studentList) {
//		List<Entry<Student, String>> sortedArrivalTimeStudents = null;
//		for (Student student : studentList) {
//			if (sortedArrivalTimeStudents == null)
//				sortedArrivalTimeStudents = new ArrayList<Entry<Student, String>>();
//			sortedArrivalTimeStudents.addAll(student.arrive().entrySet());
//		}
//		Collections.sort(sortedArrivalTimeStudents, timeComparator);
//		return sortedArrivalTimeStudents;
//	}
//
//	public List<String> getAllAwardedStudentList(List<Entry<Student, String>> sortedArrivalTimeStudentList) {
//		List<String> awardStudentList = null;
//		for (Entry<Student, String> entry : sortedArrivalTimeStudentList) {
//			if (awardStudentList == null)
//				awardStudentList = new ArrayList<String>();
//			awardStudentList.add(entry.getKey().award());
//		}
//		return awardStudentList;
//	}

	public Map<String, List<Integer>> getStudentNameWordCharacterCountPairs(List<Student> studentList) {
		Map<String, List<Integer>> nameWordCharCountPairs = new HashMap<String, List<Integer>>();
		for (Student student : studentList) {
			List<Integer> countStudentList = new ArrayList<Integer>();
			countStudentList.add(WordUtil.getInstance().getCountedWord(student.getName()));
			countStudentList.add(WordUtil.getInstance().getCountedCharacter(student.getName()));
			nameWordCharCountPairs.put(student.getName(), countStudentList);
		}
		return nameWordCharCountPairs;
	}

	private Comparator<Entry<Student, String>> timeComparator = new Comparator<Entry<Student, String>>() {
		@Override
		public int compare(Entry<Student, String> entry1, Entry<Student, String> entry2) {
			int entity1Hour = Integer.parseInt(entry1.getValue().split(":")[0]);
			int entity2Hour = Integer.parseInt(entry2.getValue().split(":")[0]);
			int entity1Minute = Integer.parseInt(entry1.getValue().split(":")[1]);
			int entity2Minute = Integer.parseInt(entry2.getValue().split(":")[1]);
			if (entity1Hour > entity2Hour)
				return 1;
			if (entity1Hour < entity2Hour)
				return -1;
			if (entity1Hour == entity2Hour) {
				if (entity1Minute > entity2Minute)
					return 1;
				if (entity1Minute < entity2Minute)
					return -1;
			}
			return 0;
		}
	};
}
