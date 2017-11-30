package fr.iut.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Message {
	

	public Message() {
		
	}
	private String message = Constant.DEFAULT_MESSAGE;
	public Message(Exception exception) {
		super();
		this.message = Constant.IN_CASE_ERROR;
	}



	public Message(String message) {
		this.message = message;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	List<Message> history = new ArrayList<>();

	public List<Message> getHistory() {
		return history;
	}

	public void setHistory(List<Message> history) {
		this.history = history;
	}



	public boolean isEmpty() {
		return false;
	}
}
