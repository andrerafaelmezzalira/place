package place.vo;

import java.io.Serializable;

public class PlaceVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String slug;
	
	private String city;
	
	private String state;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
}
