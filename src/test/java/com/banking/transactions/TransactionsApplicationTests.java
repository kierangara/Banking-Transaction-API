package com.banking.transactions;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.banking.transactions.model.AccountDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void standardAccountCreationIsSuccessful() throws Exception {
		AccountDTO account = new AccountDTO("John", "Smith", 500);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(account);
		this.mockMvc.perform(post("/accounts").contentType(APPLICATION_JSON_UTF8)
				.content(requestJson)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void negativeAccountBalanceCreationFailsGracefully() throws Exception {
		AccountDTO account = new AccountDTO("John", "Smith", -500);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(account);
		this.mockMvc.perform(post("/accounts").contentType(APPLICATION_JSON_UTF8)
				.content(requestJson)).andDo(print()).andExpect(status().isBadRequest());
	}

}
