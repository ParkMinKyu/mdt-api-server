package kr.niee.mdt.scheduler;

import java.sql.Timestamp;
import java.util.Date;

import kr.niee.mdt.scheduler.vo.SchedulerVO;
import kr.niee.mdt.spring.SpringWebInitializer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringWebInitializer.class)
@WebAppConfiguration
public class SchedulerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;
	private SchedulerVO schedulerVO;
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		schedulerVO = new SchedulerVO();
		schedulerVO.setId(1);
		schedulerVO.setTitle("test");
		schedulerVO.setContents("testddddd");
		schedulerVO.setStarttime(new Timestamp(new Date().getTime()));
		schedulerVO.setEndtime(new Timestamp(new Date().getTime()));
		schedulerVO.setWriter("niee");
	}
	
	@Test
	public void scheduler() throws Exception {
		
		ResultActions scheduler = mockMvc.perform(MockMvcRequestBuilders.get("/mdt/scheduler?starttime="+new Date().getTime()+"&endtime="+new Date().getTime()).content(MediaType.TEXT_HTML_VALUE));
		
		scheduler.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());

	}

}
