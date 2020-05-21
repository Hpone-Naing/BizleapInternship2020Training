package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BirthdayGuestManager {

	private Queue<BirthdayGuest1> arrivedStudentQueue = null;
	private Queue<BirthdayGuest1> awardedStudentQueue = null;
	private Map<Integer, BirthdayGuest1> studentMap = null;
	private List<BirthdayGuest1> studentList = null;
	private List<Integer> keyList = null;

	public BirthdayGuestManager() {
		start();
	}

	public Queue<BirthdayGuest1> getStudentQueue() {
		return arrivedStudentQueue;
	}

	public void setDepartStudentQueue(Queue<BirthdayGuest1> departStudentQueue) {
		this.awardedStudentQueue = departStudentQueue;
	}

	public Map<Integer, BirthdayGuest1> getStudentMap() {
		if (studentMap == null)
			studentMap = new HashMap<Integer, BirthdayGuest1>();
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
		studentList = Arrays.asList(new BirthdayGuest1[] { new BirthdayGuest1("Theint Thu Thu Aung"),
				new BirthdayGuest1("Sandar Win"), new BirthdayGuest1("Htet Wai Lin"),
				new BirthdayGuest1("Kaung Nyunt Hlaing"), new BirthdayGuest1("Hlwan Moe Hein"),
				new BirthdayGuest1("Thuzar Hlaing"), new BirthdayGuest1("Hpone Naing Tun"),
				new BirthdayGuest1("Phu Pwint Eaindray"), new BirthdayGuest1("Saw Than Shwe"),
				new BirthdayGuest1("Ei Ei Tone"), new BirthdayGuest1("Aye Chan Nyein"),
				new BirthdayGuest1("Naw Phaw Hkee Lar Mya"), new BirthdayGuest1("Min Thant Khant") });
		setStudentMap();
		if (arrivedStudentQueue == null)
			arrivedStudentQueue = new ConcurrentLinkedQueue<BirthdayGuest1>();
		if (awardedStudentQueue == null)
			awardedStudentQueue = new ConcurrentLinkedQueue<BirthdayGuest1>();
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
			BirthdayGuest1 student = arrivedStudentQueue.poll();
			student.award(arrivedStudentQueue);
			awardedStudentQueue.add(student);
			System.out.println(student + " certificate awarded.");
		}
	}

	private void doDepart() {
		while (!awardedStudentQueue.isEmpty()) {
			BirthdayGuest1 student = awardedStudentQueue.poll();
			student.depart(arrivedStudentQueue);
			System.out.println(student + " departs.");
		}
	}

	private BirthdayGuest1 getAStudent() {
		return studentMap != null
				? studentMap
						.get(keyList.get(RandomNumberGenerator.getInstance().getUniqueRandomNumber(studentList.size())))
				: null;
	}

	private void setStudentMap() {
		for (BirthdayGuest1 student : studentList) {
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
