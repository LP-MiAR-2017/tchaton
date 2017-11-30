package fr.iut.tchaton.marketing.service.conversation;


import javax.annotation.Resource;

import fr.iut.domain.entity.Constant;
import fr.iut.domain.entity.History;
import fr.iut.domain.entity.Message;
import fr.iut.domain.factory.IFactory;
import fr.iut.domain.repo.IRepo;

public class Chat {
	@Resource
	IFactory<History> factory;
	@Resource
	IRepo  repository;
	private Message beginConversation() {
		
		return new Message();
	}
	public Message serviceConversation(Exception exception) {
		return new Message(exception);
	}
	public Message serviceConversation(Message messageToService) {
		Message res = null;
		if(messageToService == null || messageToService.isEmpty()){
			res = beginConversation();
		}else{
			res = treatmentMessage(messageToService);
		}
		return res;
	}
	private Message treatmentMessage(Message messageToService) {
		Message response = new Message();
		
		helloCase(messageToService, response);
		
		return response;
	}
	private void helloCase(Message messageToService, Message response) {
		if(messageToService.getMessage().contentEquals(Constant.HELLO_MESSAGE)){
			response.setMessage(Constant.HELLO_MESSAGE);
		}
	}
	public History getHistory() {
		return factory.mkObjectHistory(repository.getHistory());
	}

}
