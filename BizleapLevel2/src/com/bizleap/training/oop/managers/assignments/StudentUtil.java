package com.bizleap.training.oop.managers.assignments;

import com.bizleap.training.oop.entities.assignments.Student;

public class StudentUtil {

	private StudentManager sm = null;

	public StudentUtil() {

	}

	public StudentUtil(StudentManager sm) {
		this.sm = sm;
	}

	public int getAverageAge() {
		int total = 0;
		for (Student student : sm.getStudentList()) {
			total += student.getAge();
		}
		return total / sm.getStudentList().size();
	}

	public Student getYoungestStudent() {
		Student youngestStudent = sm.getStudentList().get(0);
		for (Student student : sm.getStudentList()) {
			if (student.isYounger(youngestStudent))
				youngestStudent = student;
		}
		return youngestStudent;
	}

	public Student getEldestStudent() {
		Student eldestStudent = sm.getStudentList().get(0);
		for (Student student : sm.getStudentList()) {
			if (student.isElder(eldestStudent))
				eldestStudent = student;
		}
		return eldestStudent;
	}

	public Student getYoungestMale() {
		for (Student student : sm.getStudentList()) {
			if (student.isSameAge(getYoungestStudent()) && student.isMale())
				return student;
		}
		return null;
	}

	public Student getYoungestFemale() {
		for (Student student : sm.getStudentList()) {
			if (student.isSameAge(getYoungestStudent()) && student.isFemale())
				return student;
		}
		return null;
	}

	public Student getEldestMale() {
		for (Student student : sm.getStudentList()) {
			if (student.isSameAge(getEldestStudent()) && student.isMale())
				return student;
		}
		return null;
	}

	public Student getEldestFemale() {
		for (Student student : sm.getStudentList()) {
			if (student.isSameAge(getEldestStudent()) && student.isFemale())
				return student;
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("hello");
		StudentUtil sm = new StudentUtil(new StudentManager());
		System.out.println("avg: " + sm.getAverageAge());
		System.out.println("youngest std: " + sm.getYoungestStudent());
		System.out.println("eldest std: " + sm.getEldestStudent());
		System.out.println("youngest female: " + sm.getYoungestFemale());
		System.out.println("youngest male: " + sm.getYoungestMale());
	}
}