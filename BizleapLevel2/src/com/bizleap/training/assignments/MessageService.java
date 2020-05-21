package com.bizleap.training.assignments;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bizleap.training.enums.StatusCategory;

public class MessageService {

	private MessengingManager mm = null;
	private Map<StatusCategory, List<MessageGroup>> messageGroupMap = null;

	public MessageService() {

	}

	public MessageService(MessengingManager mm) {
		this.mm = mm;
	}

	public Map<StatusCategory, List<MessageGroup>> getMessageGroupMap() {
		return mm.getMessageGroupMap();
	}
	public void showMessageGroup() {
		Map<StatusCategory, List<MessageGroup>> messageGroupMap = getMessageGroupMap();
		Set<StatusCategory> keys = messageGroupMap.keySet();
		for (StatusCategory key : keys) {
			if (key.equals(StatusCategory.DELIVERED)) {
				for (MessageGroup messageGroup : messageGroupMap.get(key)) {
					System.out.println(messageGroup.getName());
					Message lastMessage = messageGroup.getMessageList().get(messageGroup.getMessageList().size() - 1);
					System.out.println(lastMessage.getStudent().getName() + " : " + lastMessage.getLastMessage() + " : "
							+ lastMessage.getStatus());
					System.out.println("--------------------------");
				}
			}
		}
	}

	public static void main(String[] args) {
		new MessageService(new MessengingManager()).showMessageGroup();
	}
}
