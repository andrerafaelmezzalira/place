package place.service;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import org.prevayler.Transaction;
import org.springframework.stereotype.Service;

import place.model.Data;
import place.model.Place;
import place.vo.PlaceVO;

@Service
public class PlaceService implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Prevayler prevayler;

	public PlaceService() {
		if (prevayler == null) {
			PrevaylerFactory factory = new PrevaylerFactory();
			factory.configurePrevalenceBase("data");
			factory.configurePrevalentSystem(new Data());
			try {
				prevayler = factory.create();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Collection<Place> findByName(final String name) {
		return name != null ? getPlaces(place -> place.getName() != null
				&& format(place.getName()).matches(String.format("%1$s%2$s%1$s", ".*", format(name))))
						.collect(Collectors.toList())
				: Collections.emptyList();
	}

	public Place findByUuid(String uuid) {
		return uuid != null ? getPlaces(place -> uuid.equals(place.getUuid())).findFirst().orElse(null) : null;
	}

	public void create(PlaceVO placeVO) {

		prevayler.execute(new Transaction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void executeOn(Object data, Date date) {

				Place place = new Place();
				place.setUuid(UUID.randomUUID().toString());
				place.setCreatedAt(LocalDateTime.now());
				place.setName(placeVO.getName());
				place.setSlug(placeVO.getSlug());
				place.setCity(placeVO.getCity());
				place.setState(placeVO.getState());

				((Data) data).getPlaces().add(place);
			}
		});
	}

	public void edit(String uuid, PlaceVO placeVO) {

		prevayler.execute(new Transaction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void executeOn(Object data, Date date) {

				for (int i = 0; i < ((Data) data).getPlaces().size(); i++) {
					if (((Data) data).getPlaces().get(i).getUuid().equals(uuid)) {
						((Data) data).getPlaces().get(i).setUpdatedAt(LocalDateTime.now());
						((Data) data).getPlaces().get(i).setName(placeVO.getName());
						((Data) data).getPlaces().get(i).setSlug(placeVO.getSlug());
						((Data) data).getPlaces().get(i).setCity(placeVO.getCity());
						((Data) data).getPlaces().get(i).setState(placeVO.getState());
						break;
					}
				}
			}
		});
	}

	private String format(String unFormat) {
		return unFormat.trim().toLowerCase();
	}

	private Stream<Place> getPlaces(Predicate<Place> predicate) {
		return ((Data) prevayler.prevalentSystem()).getPlaces().stream().filter(predicate);
	}

}
