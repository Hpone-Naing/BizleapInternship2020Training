package com.bizleap.training.assignments;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.training.enums.StatusCategory;
import com.bizleap.training.oop.entities.assignments.Student;

public class Message {

	private int id;
	private String message;
	private StatusCategory status;
	private Student student;

	public Message(int id, String message, StatusCategory status) {
		this.id = id;
		this.message = message;
		this.status = status;
	}

	public Message(int id, Student student, String message, StatusCategory status) {
		this(id, message, status);
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastMessage() {
		return message;
	}

	public void setLastMessage(String lastMessage) {
		this.message = lastMessage;
	}

	public StatusCategory getStatus() {
		return status;
	}

	public void setStatus(StatusCategory status) {
		this.status = status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isContainStatus(Map<StatusCategory, List<MessageGroup>> messageGroupMap) {
		return messageGroupMap.containsKey(this.status);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(message).append(status).append(student).toString();
	}
}
