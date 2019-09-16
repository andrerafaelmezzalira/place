package place.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Place implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uuid;

	private String name;

	private String slug;

	private String city;

	private String state;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int hashCode() {
		return uuid != null ? uuid.hashCode() : super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Place && obj != null) {
			Place place = (Place) obj;
			return hashCode() == place.hashCode();
		}
		return super.equals(obj);
	}
}
