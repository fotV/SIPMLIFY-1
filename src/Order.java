
public class Order {
	
	String orderManagerId;
	String orderId;
	double quantity;
	String supplierId;
	String supplierName;
	String supplierAFM;
	int status;
	double price;
	double totalPrice;
	String productName;
	String productId;
	String date;




	public Order(String productName, String orderId, int status) {
		this.productName = productName;
		this.orderId= orderId;
		this.status = status;
	}
	
}
