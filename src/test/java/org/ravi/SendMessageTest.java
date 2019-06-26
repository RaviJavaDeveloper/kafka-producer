package org.ravi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.ravi.resource.KafkaResource;
import org.ravi.services.KafkaService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class SendMessageTest {

    private MockMvc mockMvc;

    @InjectMocks
    KafkaResource kafkaResource;

    @Mock
    KafkaService kafkaService;

    @Before
    public void setUp(){
        System.out.println("Setting up resource");
        mockMvc = MockMvcBuilders.standaloneSetup(kafkaResource).build();
    }

    @Test
    public void test() throws Exception {
        System.out.println("testing send message");
        Mockito.when(kafkaService.sendMessage("hello")).thenReturn("hello");
        mockMvc.perform(MockMvcRequestBuilders.get("/kafka/message/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(kafkaService).sendMessage("hello");
    }

}
