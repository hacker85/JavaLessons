import com.max.test.controllers.TestController;
import com.max.test.interfaces.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration//("src/test/webapp")
@ContextConfiguration
@RunWith(SpringRunner.class)
public class WebTest {
    @Autowired
    private WebApplicationContext applicationContext;
    @Autowired
    MockServletContext servletContext; // cached
    @Autowired
    MockHttpSession session;
    @Autowired
    MockHttpServletRequest request;
    @Autowired
    MockHttpServletResponse response;
    @Autowired
    ServletWebRequest webRequest;
//    @Autowired
//    TestController testController;
    MockMvc mockMvc;
    @Before
    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(new TestController())
                .alwaysExpect(status().isOk()).build();
    }

    @Test
    public void myTest() {
        Car bean = applicationContext.getBean(Car.class);
        bean.drive();
    }

    @Test
    public void webTest() throws Exception {
        mockMvc.perform(get("/test")
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }
    @Test
    public void postTest() throws Exception {
        mockMvc.perform(post("/testPost")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("Max"));
    }

    @Test
    public void paramsTest() throws Exception {
//        mockMvc.perform(get("/testParams/{id}", 22)).andExpect(status().isOk());
//        mockMvc.perform(get("/testParams?id={id}", 22)).andExpect(status().isOk());
        MvcResult result = mockMvc.perform(get("/testParams")
                .param("id", "22"))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Configuration
    @ComponentScan("com.max.test")
    static class TestConfig {
    }
}
