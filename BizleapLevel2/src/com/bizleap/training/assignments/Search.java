package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.bizleap.training.enums.SexCategory;
import com.bizleap.training.oop.entities.assignments.OtherStudent;
import com.bizleap.training.oop.entities.assignments.Student;
import com.bizleap.training.oop.entities.assignments.UcsyStudent;

public class Search {

	private List<Student> studentList = null;

	public Search() {
		doInitialize();
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
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
	}

	public void search() {
		List<Student> studentMatchList = new ArrayList<Student>();
		System.out.print("Enter keyword......");
		Scanner sc = new Scanner(System.in);
		String str = "";
		while (sc.hasNext()) {
			str += sc.next();
			for (Student student : studentList) {
				String searchString = makeString(student.getName());
				if (searchString.contains(makeString(str)))
					studentMatchList.add(student);
			}
			if (studentMatchList.isEmpty()) {
				System.out.println("no result found....");
				System.exit(0);
			}
			if (studentMatchList.size() == 1) {
				break;
			}
			if (studentMatchList.size() > 1) {
				System.out.println("search ...." + str + "\n searched result: " + studentMatchList);
				studentMatchList.clear();
			}

		}
		System.out.println("search...." + studentMatchList.get(0).getName() + "\nmatch result: " + studentMatchList);
	}

	private String makeString(String str) {
		StringBuffer sb = new StringBuffer();
		for (String word : str.split("\\s+")) {
			sb.append(word.toLowerCase());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Search search = new Search();
		search.search();
	}

}
