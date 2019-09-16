package place.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Place> places = new ArrayList<>();

	public List<Place> getPlaces() {
		return places;
	}
}
