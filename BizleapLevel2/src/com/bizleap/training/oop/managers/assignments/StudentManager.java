package com.bizleap.training.oop.managers.assignments;

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

	private void doInitialize() {
		studentList = Arrays.asList(new Student[] { new OtherStudent("Theint Thu Thu Aung", 18, SexCategory.FEMALE, "UCSH"),
				new UcsyStudent("Sandar Win", 15, SexCategory.FEMALE),
				new OtherStudent("Htet Wai Lin", 16, SexCategory.MALE, "UCSH"),
				new OtherStudent("Kaung Nyunt Hlaing", 20, SexCategory.MALE, "UCSR"),
				new UcsyStudent("Hlwan Moe Hein", 20, SexCategory.MALE),
				new OtherStudent("Thuzar Hlaing", 18, SexCategory.FEMALE, "UCSR"),
				new UcsyStudent("Hpone Naing Tun", 16, SexCategory.MALE),
				new OtherStudent("Phu Pwint Eaindray", 20, SexCategory.FEMALE, "YTU"),
				new OtherStudent("Saw Than Shwe", 19, SexCategory.MALE, "UCSP"),
				new OtherStudent("Ei Ei Tone", 20, SexCategory.FEMALE, "UCSH"),
				new UcsyStudent("Aye Chan Nyein", 18, SexCategory.MALE),
				new UcsyStudent("Naw Phaw Hkee Lar Mya", 19, SexCategory.FEMALE),
				new OtherStudent("Min Thant Khant", 20, SexCategory.MALE, "UCSP") });
	}
}