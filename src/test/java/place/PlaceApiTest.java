package place;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import place.api.PlaceApi;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaceApiTest {

	private MockMvc mockMvc;

	@Autowired
	private PlaceApi placeApi;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(placeApi).build();
	}

	@Test
	public void findByName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/places?name=place"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void findByUuid() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/places/uuid")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
