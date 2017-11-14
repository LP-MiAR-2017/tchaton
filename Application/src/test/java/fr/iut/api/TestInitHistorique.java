package fr.iut.api;

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

import fr.iut.application.api.Conversation;

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
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Bonjour, que puis je faire pour vous !"));
	}
}
