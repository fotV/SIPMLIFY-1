
public class Suppl {
	/*Suppl.java
	 * @author Vlasakoudi Christina
	 */
	private String productId;
	private String supplierId;
	private double price;

	public Suppl(String productid,String supplierid,double price) {
	
		this.productId=productid;
		this.supplierId=supplierid;
		this.price = price;
}

	public String getProductId() {
		return productId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public double getPrice() {
		return price;
	}


	public void setProductId(String productId) {
		this.productId = productId;
		
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
		

	public void setPrice(double price) {
		this.price = price;
		
	}

	
	
}
