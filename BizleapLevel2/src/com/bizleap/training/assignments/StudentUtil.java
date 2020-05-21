package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bizleap.training.enums.SexCategory;

public class StudentUtil {

	private static StudentUtil instance = null;

	private StudentUtil() {

	}

	public static StudentUtil getInstance() {
		if (instance == null)
			synchronized (StudentUtil.class) {
				if (instance == null)
					instance = new StudentUtil();
			}
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

	public Map<String, List<Integer>> getStudentNameWordAndCharacterCountPairs(List<Student> studentList) {
		Map<String, List<Integer>> nameWordCharCountPairs = new HashMap<String, List<Integer>>();
		for (Student student : studentList) {
			List<Integer> countStudentList = new ArrayList<Integer>();
			countStudentList.add(WordUtil.getInstance().getCountedWord(student.getName()));
			countStudentList.add(WordUtil.getInstance().getCountedCharacter(student.getName()));
			nameWordCharCountPairs.put(student.getName(), countStudentList);
		}
		return nameWordCharCountPairs;
	}
}