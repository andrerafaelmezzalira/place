package place;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import place.service.PlaceService;
import place.vo.PlaceVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaceServiceTest {

	@Autowired
	private PlaceService placeService;

	@Before
	public void setUp() {
		if (placeService.findByName("place").size() == 0) {
			PlaceVO placeVO = new PlaceVO();
			placeVO.setName("place");
			placeService.create(placeVO);
		}
	}

	@Test
	public void findByName() {
		assertThat(placeService.findByName("place").size(), is(1));
	}

}
