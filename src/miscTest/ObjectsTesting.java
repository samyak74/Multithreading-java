package miscTest;

import java.util.Objects;

public class ObjectsTesting {
	public static void main(String[] args) {
		Geo geo = new Geo();
		geo.setLat(2.2);
		geo.setLon(1.2);
		geo.setP(new Product("a","b",3.0));
		Geo geo1 = new Geo(new Product("a","b",3.0),2.2,1.2);

		boolean equals1 = Objects.equals(geo, geo1);
		boolean equals = geo.equals(geo1);
		boolean equals2 = Objects.deepEquals(geo, geo1);
		System.out.println(equals + " " + equals1+ " " + equals2);
		System.out.println(geo.toString() + "\n" + geo1.toString());


	}
}
