package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bizleap.training.enums.SexCategory;
import com.bizleap.training.oop.entities.assignments.OtherStudent;
import com.bizleap.training.oop.entities.assignments.Student;
import com.bizleap.training.oop.entities.assignments.UcsyStudent;

public class StudentAnalyzer {

	private Map<Integer, List<Student>> studentWordMap;
	private Map<Integer, List<Student>> studentCharacterMap;
	private List<Student> studentList = null;

	public StudentAnalyzer() {
		start();
	}

	public Map<Integer, List<Student>> getStudentWordMap() {
		return studentWordMap;
	}

	public void setStudentWordMap(Map<Integer, List<Student>> studentWordMap) {
		this.studentWordMap = studentWordMap;
	}

	public Map<Integer, List<Student>> getStudentCharacterMap() {
		return studentCharacterMap;
	}

	public void setStudentCharacterMap(Map<Integer, List<Student>> studentCharacterMap) {
		this.studentCharacterMap = studentCharacterMap;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	private void doInitialize() {
		studentList = Arrays
				.asList(new Student[] { new OtherStudent("Theint Thu Thu Aung", 18, SexCategory.FEMALE, "UCSH"),
						new UcsyStudent("Sandar Win", 20, SexCategory.FEMALE),
						new OtherStudent("Htet Wai Lin", 20, SexCategory.MALE, "UCSH"),
						new OtherStudent("Kaung Nyunt Hlaing", 20, SexCategory.MALE, "UCSR"),
						new UcsyStudent("Hlwan Moe Hein", 20, SexCategory.MALE),
						new OtherStudent("Thuzar Hlaing", 18, SexCategory.FEMALE, "UCSR"),
						new UcsyStudent("Hpone Naing Tun", 20, SexCategory.MALE),
						new OtherStudent("Phu Pwint Eaindray", 20, SexCategory.FEMALE, "YTU"),
						new OtherStudent("Saw Than Shwe", 19, SexCategory.MALE, "UCSP"),
						new OtherStudent("Ei Ei Tone", 20, SexCategory.FEMALE, "UCSH"),
						new UcsyStudent("Aye Chan Nyein", 18, SexCategory.MALE),
						new UcsyStudent("Naw Phaw Hkee Lar Mya", 19, SexCategory.FEMALE),
						new OtherStudent("Min Thant Khant", 20, SexCategory.MALE, "UCSP") });
		if (studentWordMap == null)
			studentWordMap = new HashMap<Integer, List<Student>>();
		if (studentCharacterMap == null)
			studentCharacterMap = new HashMap<Integer, List<Student>>();
	}

	private void pupulateWordMap() {
		List<Student> studentSameWordCountList = null;
		for (Student student : studentList) {
			int wordCount = student.getNameWordCount();
			if (!student.isContainWord(studentWordMap)) {
				studentSameWordCountList = new ArrayList<Student>();
				studentSameWordCountList.add(student);
			} else {
				studentSameWordCountList = studentWordMap.get(wordCount);
				studentSameWordCountList.add(student);
			}
			studentWordMap.put(wordCount, studentSameWordCountList);
		}
		System.out.println(studentWordMap);
	}

	private void pupulateCharacterMap() {
		List<Student> studentSameCharacterCountList = null;
		for (Student student : studentList) {
			int characterCount = student.getNameCharacterCount();
			if (!student.isContainCharacter(studentCharacterMap)) {
				studentSameCharacterCountList = new ArrayList<Student>();
				studentSameCharacterCountList.add(student);
			} else {
				studentSameCharacterCountList = studentCharacterMap.get(characterCount);
				studentSameCharacterCountList.add(student);
			}
			studentCharacterMap.put(characterCount, studentSameCharacterCountList);
		}
		System.out.println(studentCharacterMap);
	}

	public void start() {
		doInitialize();
		pupulateWordMap();
		pupulateCharacterMap();
	}

	public static void main(String[] args) {
		new StudentAnalyzer();
	}
}