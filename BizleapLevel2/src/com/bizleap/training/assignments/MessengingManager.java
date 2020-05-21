package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bizleap.training.enums.SexCategory;
import com.bizleap.training.enums.StatusCategory;
import com.bizleap.training.oop.entities.assignments.UcsyStudent;
import com.bizleap.training.oop.entities.assignments.OtherStudent;

public class MessengingManager {

	private Map<StatusCategory, List<MessageGroup>> messageGroupMap = null;
	private List<MessageGroup> messageGroupList = null;
	private List<Message> bizleapInternship2020 = null;
	private List<Message> internshipMeeting = null;
	private List<Message> internshipDicussion = null;

	public MessengingManager() {
		start();
	}

	public Map<StatusCategory, List<MessageGroup>> getMessageGroupMap() {
		return messageGroupMap;
	}

	public void setMessageGroupMap(Map<StatusCategory, List<MessageGroup>> messageGroupMap) {
		this.messageGroupMap = messageGroupMap;
	}

	public List<MessageGroup> getMessageGroupList() {
		return messageGroupList;
	}

	public void setMessageGroupList(List<MessageGroup> messageGroupList) {
		this.messageGroupList = messageGroupList;
	}

	private void doInitialize() {
		internshipDicussion = Arrays.asList(new Message[] {
				new Message(1, new UcsyStudent("Hlwan Moe Hein", 20, SexCategory.MALE), "Hello I am Hlwan Moe Heil",
						StatusCategory.SEEN),
				new Message(2, new OtherStudent("Htet Wai Lin", 20, SexCategory.MALE, "UCSP"),
						"Hello I am Htet Wai Lin", StatusCategory.SEEN),

				new Message(3, new UcsyStudent("Sandar Win", 20, SexCategory.FEMALE), "Hello I am Sandar Win",
						StatusCategory.SEEN),
				new Message(4, new OtherStudent("Thuzar Hlaing", 20, SexCategory.FEMALE, "UCSP"),
						"Hello I am Thuzar Hlaing", StatusCategory.DELIVERED) });

		internshipMeeting = Arrays.asList(new Message[] {
				new Message(1, new UcsyStudent("Theint Thu Thu Aung", 20, SexCategory.FEMALE),
						"Hello I am Theint Thu Thu Aung", StatusCategory.SEEN),
				new Message(2, new OtherStudent("Kaung Nyunt Hlaing", 20, SexCategory.MALE, "UCSP"),
						"Hello I am Htet Wai Lin", StatusCategory.SEEN),
				new Message(3, new UcsyStudent("Aye Chan Nyein", 20, SexCategory.MALE), "Hello I am Aye Chan Nyein",
						StatusCategory.SEEN),
				new Message(4, new OtherStudent("Ei Ei Thone", 20, SexCategory.FEMALE, "UCSH"),
						"Hello I am Ei Ei Thone", StatusCategory.DELIVERED) });

		bizleapInternship2020 = Arrays.asList(new Message[] {
				new Message(1, new OtherStudent("Min Thant Khant", 20, SexCategory.MALE, "UCSH"),
						"Hello I am Min Thant Khant", StatusCategory.SEEN),
				new Message(2, new OtherStudent("Saw Than Shwe", 20, SexCategory.MALE, "UCSP"),
						"Hello I am Saw Than Shwe", StatusCategory.SEEN),
				new Message(3, new UcsyStudent("Phu Pwint Endrain", 20, SexCategory.FEMALE),
						"Hello I am Phu Pwint Endrain", StatusCategory.SEEN),
				new Message(4, new UcsyStudent("Phoo Pwint Thu", 20, SexCategory.FEMALE),
						"Hello I am Pink Power Ranger", StatusCategory.SEEN),
				new Message(5, new UcsyStudent("Naw Phaw Hkee Lar Mya", 20, SexCategory.FEMALE),
						"Hello I am yellow Power Ranger", StatusCategory.SEEN),
				new Message(6, new UcsyStudent("Hpone Naing Tun", 20, SexCategory.MALE), "Hello I am red Power Ranger",
						StatusCategory.DELIVERED) });
		messageGroupList = Arrays
				.asList(new MessageGroup[] { new MessageGroup("1", "Internship Discussion", internshipDicussion),
						new MessageGroup("2", "Internship Meeting", internshipMeeting),
						new MessageGroup("3", "Bileap Internship 2020", bizleapInternship2020) });

		if (messageGroupMap == null)
			messageGroupMap = new HashMap<StatusCategory, List<MessageGroup>>();
	}

	private void pupulateMessageGroupMap() {
		List<MessageGroup> sameStatusMessageGroupList = null;
		for (MessageGroup messageGroup : messageGroupList) {
			for (Message message : messageGroup.getMessageList()) {
				if (!message.isContainStatus(messageGroupMap)) {
					sameStatusMessageGroupList = new ArrayList<MessageGroup>();
					sameStatusMessageGroupList.add(messageGroup);
				} else {
					sameStatusMessageGroupList = messageGroupMap.get(message.getStatus());
					sameStatusMessageGroupList.add(messageGroup);
				}
				messageGroupMap.put(message.getStatus(), sameStatusMessageGroupList);
			}
		}
		//System.out.println(messageGroupMap);

	}

	public void start() {
		doInitialize();
		pupulateMessageGroupMap();
	}
	
	public static void main(String[] args) {
		MessengingManager mm = new MessengingManager();
		System.out.println(mm.messageGroupMap);
	}
}