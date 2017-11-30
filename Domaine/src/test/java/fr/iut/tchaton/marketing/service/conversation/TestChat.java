package fr.iut.tchaton.marketing.service.conversation;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.iut.domain.entity.Message;

public class TestChat {

	@Test
	public void twoMessagesSentHistorySizeTwo() {
		Chat chat = new Chat();
		
		chat.serviceConversation(new Message("First"));
		chat.serviceConversation(new Message("Second"));
		
		assertEquals(2,chat.getHistory().size() );
		
		
	}

}
