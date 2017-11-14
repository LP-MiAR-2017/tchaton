package fr.iut.application.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.GsonBuilder;

import fr.iut.application.enf.BuilderStatus;
import fr.iut.application.enf.Status;
import fr.iut.domain.entity.Message;
import fr.iut.tchaton.marketing.service.conversation.Chat;

@Controller
@EnableAutoConfiguration
public class Conversation {
	private final static Logger LOGGER = LoggerFactory.getLogger(Conversation.class);
	private Chat chat = new Chat();
	@ResponseBody
	@GetMapping("conversation")
	public String conversation(String message) {
			return mkResponse(message,checkIfWellFormed(message));
	}
	private String mkResponse(String message, Status checkIfWellFormed) {
			Message messageToService = mkMessage(message,checkIfWellFormed) ;
			GsonBuilder builder = new GsonBuilder();
			String res = builder.create().toJson(chat.serviceConversation(messageToService));
			return res;
	}
	private Message mkMessage(String message, Status checkIfWellFormed) {
		return null;
	}
	private Status checkIfWellFormed(String message) {
		LOGGER.info("message ==> " + message);
		return BuilderStatus.treat(message);
	}
}
