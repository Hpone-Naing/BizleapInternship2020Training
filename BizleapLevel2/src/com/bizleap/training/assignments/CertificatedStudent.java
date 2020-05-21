package com.bizleap.training.assignments;

import java.util.Queue;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CertificatedStudent {

	private String name;

	public CertificatedStudent() {
	}

	public CertificatedStudent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void arrive(Queue<CertificatedStudent> studentsQueue) {
		studentsQueue.add(this);
	}

	public void award(Queue<CertificatedStudent> studentsQueue) {
		studentsQueue.remove(this);
	}

	public void depart(Queue<CertificatedStudent> studentsQueue) {
		studentsQueue.remove(this);
	}

	@Override
	public int hashCode() {
		Integer hash = 1;
		final int prime = 7;
		if (name == null && name.length() < 0)
			return 0;
		for (Character ch : name.toCharArray()) {
			hash += prime * hash + (ch % 0xff);
		}
		hash = hash.hashCode() % 0xff;
		return Math.abs((hash % 13) + 1);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name: " + name).toString();
	}

	public static void main(String[] args) {
		System.out
				.println("Theint Thu Thu Aung hashcode: " + new CertificatedStudent("Theint Thu Thu Aung").hashCode());
		System.out.println("Sandar Win hashcode: " + new CertificatedStudent("Sandar Win").hashCode());
		System.out.println("Htet Wai Lin hashcode: " + new CertificatedStudent("Htet Wai Lin").hashCode());
		System.out.println("Kaung Nyunt Hlaing hashcode: " + new CertificatedStudent("Kaung Nyunt Hlaing").hashCode());
		System.out.println("Hlwan Moe Hein hashcode: " + new CertificatedStudent("Hlwan Moe Hein").hashCode());
		System.out.println("Thuzar Hlaing hashcode: " + new CertificatedStudent("Thuzar Hlaing").hashCode());
		System.out.println("Hpone Naing Tun hashcode: " + new CertificatedStudent("Hpone Naing Tun").hashCode());
		System.out.println("Phu Pwint Eaindray hashcode: " + new CertificatedStudent("Phu Pwint Eaindray").hashCode());
		System.out.println("Saw Than Shwe hashcode: " + new CertificatedStudent("Saw Than Shwe").hashCode());
		System.out.println("Ei Ei Tone hashcode: " + new CertificatedStudent("Ei Ei Tone").hashCode());
		System.out.println("Aye Chan Nyein hashcode: " + new CertificatedStudent("Aye Chan Nyein").hashCode());
		System.out.println(
				"Naw Phaw Hkee Lar Mya hashcode: " + new CertificatedStudent("Naw Phaw Hkee Lar Mya").hashCode());
		System.out.println("Min Thant Khant hashcode: " + new CertificatedStudent("Min Thant Khant").hashCode());
	}
}