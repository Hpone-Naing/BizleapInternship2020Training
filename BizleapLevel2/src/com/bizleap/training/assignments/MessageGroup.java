package com.bizleap.training.assignments;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MessageGroup {

	private String id;
	private String name;
	private List<Message> messageList;
	
	public MessageGroup(String id, String name, List<Message> messageList) {
		this.id = id;
		this.name = name;
		this.messageList = messageList;
	}


	public List<Message> getMessageList() {
		return messageList;
	}


	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Message getLatMessage() {
//		return latMessage;
//	}
//
//	public void setLatMessage(Message latMessage) {
//		this.latMessage = latMessage;
//	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(name).append(messageList).toString();
	}
}
