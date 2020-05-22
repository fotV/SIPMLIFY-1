
public class Suppl {
	private String productId;
	private String supplierId;
	private double price;
	
	public Suppl(String productId, String supplierId, double price) {
		super();
		this.productId = productId;
		this.supplierId = supplierId;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
