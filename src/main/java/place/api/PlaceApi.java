package place.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import place.service.PlaceService;
import place.vo.PlaceVO;

@RestController
@RequestMapping(value = "places")
public class PlaceApi {

	@Autowired
	private PlaceService placeService;

	@ApiOperation(value = "List places by name")
	@GetMapping
	public Collection<?> findByName(@RequestParam String name) {
		return placeService.findByName(name);
	}

	@ApiOperation(value = "List places by uuid")
	@GetMapping(value = "{uuid}")
	public Object findByUuid(@PathVariable String uuid) {
		return placeService.findByUuid(uuid);
	}

	@ApiOperation(value = "Create a place")
	@PostMapping
	public void create(@RequestBody PlaceVO place) {
		placeService.create(place);
	}

	@ApiOperation(value = "Edit a place")
	@PutMapping(value = "{uuid}")
	public void edit(@PathVariable String uuid, @RequestBody PlaceVO place) {
		placeService.edit(uuid, place);
	}

}