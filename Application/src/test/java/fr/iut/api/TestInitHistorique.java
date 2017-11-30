package fr.iut.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.GsonBuilder;

import fr.iut.application.api.Conversation;
import fr.iut.domain.entity.Constant;
import fr.iut.domain.entity.Message;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Conversation.class)
@AutoConfigureMockMvc
public class TestInitHistorique {

	@Autowired
	private MockMvc mvc;

	@Test
	public void startAConversationMustStartWithEmptyHistory() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/conversation"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.history").isEmpty());
	}
	@Test
	public void startAConversationMustContainDefaultMessage() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/conversation"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constant.DEFAULT_MESSAGE));
	}
	
	@Test
	public void startAConversationWithHelloMessage() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/conversation").param("message", Constant.HELLO_MESSAGE))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constant.HELLO_MESSAGE));
	}
	
	@Test
	public void sentTwoMessageHistoryNotEmpty() throws Exception {
		List<Message> messages = new ArrayList<>();
		messages.add(new Message("first"));
		messages.add(new Message("second"));		
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		
		mvc.perform(MockMvcRequestBuilders.get("/conversation").param("message", messages.get(0).getMessage()));
		mvc.perform(MockMvcRequestBuilders.get("/conversation").param("message", messages.get(1).getMessage()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.history").value(gsonBuilder.create().toJson(messages)));
	}
	
	
	
}
