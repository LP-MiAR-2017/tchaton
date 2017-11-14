package fr.iut.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Message {
	private static final String DEFAULT_MESSAGE = "Bonjour, que puis je faire pour vous !";

	public Message() {
		
	}
	private String message = DEFAULT_MESSAGE;
	public Message(Exception exception) {
		super();
		this.message ="Bonjour, je ne comprends pas votre demande, que souhaitez vous ?";
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	List<Message> history = new ArrayList<Message>();

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
