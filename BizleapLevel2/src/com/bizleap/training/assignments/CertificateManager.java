package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CertificateManager {

	private Queue<CertificatedStudent> arrivedStudentQueue = null;
	private Queue<CertificatedStudent> awardedStudentQueue = null;
	private Map<Integer, CertificatedStudent> studentMap = null;
	private List<CertificatedStudent> studentList = null;
	private List<Integer> keyList = null;

	public CertificateManager() {
		start();
	}
	
	public Queue<CertificatedStudent> getStudentQueue() {
		return arrivedStudentQueue;
	}

	public void setDepartStudentQueue(Queue<CertificatedStudent> departStudentQueue) {
		this.awardedStudentQueue = departStudentQueue;
	}

	public Map<Integer, CertificatedStudent> getStudentMap() {
		if (studentMap == null)
			studentMap = new HashMap<Integer, CertificatedStudent>();
		return studentMap;
	}

	public List<Integer> getKeyList() {
		if (keyList == null)
			keyList = new ArrayList<Integer>();
		return keyList;
	}

	public void setKeyList(List<Integer> keyList) {
		this.keyList = keyList;
	}

	private void doInitialize() {
		studentList = Arrays.asList(new CertificatedStudent[] { new CertificatedStudent("Theint Thu Thu Aung"),
				new CertificatedStudent("Sandar Win"), new CertificatedStudent("Htet Wai Lin"),
				new CertificatedStudent("Kaung Nyunt Hlaing"), new CertificatedStudent("Hlwan Moe Hein"),
				new CertificatedStudent("Thuzar Hlaing"), new CertificatedStudent("Hpone Naing Tun"),
				new CertificatedStudent("Phu Pwint Eaindray"), new CertificatedStudent("Saw Than Shwe"),
				new CertificatedStudent("Ei Ei Tone"), new CertificatedStudent("Aye Chan Nyein"),
				new CertificatedStudent("Naw Phaw Hkee Lar Mya"), new CertificatedStudent("Min Thant Khant") });
		setStudentMap();
		if (arrivedStudentQueue == null)
			arrivedStudentQueue = new ConcurrentLinkedQueue<CertificatedStudent>();
		if (awardedStudentQueue == null)
			awardedStudentQueue = new ConcurrentLinkedQueue<CertificatedStudent>();
	}

	private void doArrival() {
		if (studentMap == null)
			System.out.println("there is no student");
		for (int i = 0; i < getStudentMap().size(); i++) {
			getAStudent().arrive(arrivedStudentQueue);
		}
		System.out.println("arrival students: " + arrivedStudentQueue);
	}

	private void doAward() {
		while (!arrivedStudentQueue.isEmpty()) {
			CertificatedStudent student = arrivedStudentQueue.poll();
			student.award(arrivedStudentQueue);
			awardedStudentQueue.add(student);
			System.out.println(student + " certificate awarded.");
		}
	}

	private void doDepart() {
		while (!awardedStudentQueue.isEmpty()) {
			CertificatedStudent student = awardedStudentQueue.poll();
			student.depart(arrivedStudentQueue);
			System.out.println(student + " departs.");
		}
	}

	private CertificatedStudent getAStudent() {
		return studentMap != null? studentMap.get(keyList.get(RandomNumberGenerator.getInstance().getUniqueRandomNumber(studentList.size()))): null;
	}

	private void setStudentMap() {
		for (CertificatedStudent student : studentList) {
			getStudentMap().put(getLocation(student.hashCode()), student);
		}
		getKeyList().addAll(getStudentMap().keySet());
	}

	private int getLocation(int currentLocation) {
		while (getStudentMap().containsKey(currentLocation)) {
			currentLocation++;
			if (currentLocation > studentList.size()) {
				currentLocation = 0;
			}
		}
		return currentLocation;
	}

	public void start() {
		doInitialize();
		doArrival();
		doAward();
		doDepart();
	}

	public static void main(String[] args) {
		 new CertificateManager();
	}
}
