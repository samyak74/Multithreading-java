package miscTest;

public class Product {
	String name;
	String id;
	Double price;

	public Product(String name, String id, Double price) {
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public Product() {
	}

	@Override
	public String toString() {
		return "Product{" +
						"name='" + name + '\'' +
						", id='" + id + '\'' +
						", price=" + price +
						'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
