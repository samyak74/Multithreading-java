package miscTest;

import java.util.Objects;

public class Geo {
	Product p;

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public Geo(Product p, Double lat, Double lon) {
		this.p = p;
		this.lat = lat;
		this.lon = lon;
	}

	Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	private Double lat;
	private Double lon;

	public Geo() {
	}

	@Override
	public String toString() {
		return "Geo{" +
						"p=" + p +
						", lat=" + lat +
						", lon=" + lon +
						'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Geo geo = (Geo) o;
		return Objects.equals(p, geo.p) &&
						Objects.equals(lat, geo.lat) &&
						Objects.equals(lon, geo.lon);
	}

	@Override
	public int hashCode() {
		return Objects.hash(p, lat, lon);
	}

	public Geo(Double lat, Double lon) {
		this.lat = lat;
		this.lon = lon;
	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o.getClass() != this.getClass()) return false;
//		Geo geo = (Geo) o;
//		return this.getLat().equals(geo.getLat()) && this.getLon().equals(geo.getLon());
//
//	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}
}
