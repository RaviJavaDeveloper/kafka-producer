package org.ravi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.ravi.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = KafkaProducerApplication.class)
@AutoConfigureMockMvc
public class KafkaProducerApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	KafkaService kafkaService;


	@Test
	public void contextLoads() throws Exception {

		Mockito.when(kafkaService.sendMessage("hello"))
				.thenReturn("Sent successfully");

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/kafka/message/hello")
		.accept(MediaType.ALL)).andReturn();

		System.out.println(result.getResponse().getContentAsString());

		Mockito.verify(kafkaService).sendMessage("hello");

	}



}
