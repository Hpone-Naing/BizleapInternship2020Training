package com.hponenaingtun.java.test;

import java.util.Arrays;
import java.util.List;

import com.bizleap.training.enums.SexCategory;
import com.bizleap.training.oop.entities.assignments.OtherStudent;
import com.bizleap.training.oop.entities.assignments.Student;
import com.bizleap.training.oop.entities.assignments.UcsyStudent;

public class StudentManager {

	private List<Student> studentList = null;

	public StudentManager() {
		doInitialize();
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public void doInitialize() {
		studentList = Arrays
				.asList(new Student[] { new OtherStudent("Theint Thu Thu Aung", 18, SexCategory.FEMALE, "UCSH"),
						new UcsyStudent("Sandar Win", 17, SexCategory.FEMALE),
						new OtherStudent("Htet Wai Lin", 16, SexCategory.MALE, "UCSH"),
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
	}

	public int getAverageAge() {
		int total = 0;
		for (Student student : studentList) {
			total += student.getAge();
		}
		return total / studentList.size();
	}

	public Student getYoungestStudent() {
		Student youngestStudent = studentList.get(0);
		for (Student student : studentList) {
			if (student.isYounger(youngestStudent))
				youngestStudent = student;
		}
		return youngestStudent;
	}

	public Student getEldestStudent() {
		Student eldestStudent = studentList.get(0);
		for (Student student : studentList) {
			if (student.isElder(eldestStudent))
				eldestStudent = student;
		}
		return eldestStudent;
	}

	public Student getYoungestMale() {
		for (Student student : studentList) {
			if (student.isSameAge(getYoungestStudent()) && student.isMale())
				return student;
		}
		return null;
	}

	public Student getYoungestFemale() {
		for (Student student : studentList) {
			if (student.isSameAge(getYoungestStudent()) && student.isFemale())
				return student;
		}
		return null;
	}

	public Student getEldestMale() {
		for (Student student : studentList) {
			if (student.isSameAge(getEldestStudent()) && student.isMale())
				return student;
		}
		return null;
	}

	public Student getEldestFemale() {
		for (Student student : studentList) {
			if (student.isSameAge(getEldestStudent()) && student.isFemale())
				return student;
		}
		return null;
	}

	public static void main(String[] args) {
		StudentManager sm = new StudentManager();
		System.out.println("average age: " + sm.getAverageAge());
		System.out.println("youngest std: " + sm.getYoungestStudent());
		System.out.println("oldest std: " + sm.getEldestStudent());

	}
}