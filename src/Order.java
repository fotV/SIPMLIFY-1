
public class Order {


	private String orderManagerId;
	private String orderId;
	private double quantity;
	private String supplierId;
	private String supplierName;
	private String supplierAFM;
	private String date;
	private int status;
	private double price;
	private double totalPrice;
	private String productName;
	private String productId;
	
	
	
	public Order(String orderManagerId,String orderId,double quantity,String supplierId,String supplierName,String supplierAFM,String date,int status,double price,double totalPrice,String productId,String productName) 
	{
		this.orderManagerId = orderManagerId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierAFM = supplierName;
		this.date = date;
		this.status = status;
		this.price = price;
		this.totalPrice = totalPrice;
		this.productId = productId;
		this.productName = productName;
	}


	public Order() {
		this.orderManagerId = "";
		this.orderId = "";
		this.quantity = 0.0;
		this.supplierId = "";
		this.supplierName = "";
		this.supplierAFM = "";
		this.date = "";
		this.status = 0;
		this.price = 0.0;
		this.totalPrice = 0.0;
		this.productId = "";
		this.productName = "";
	}
	

	public String getOrderManagerId() {
		return orderManagerId;
	}


	public String getOrderId() {
		return orderId;
	}


	public double getQuantity() {
		return quantity;
	}


	public String getSupplierId() {
		return supplierId;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public String getSupplierAFM() {
		return supplierAFM;
	}


	public String getDate() {
		return date;
	}
	

	public int getStatus() {
		return status;
	}


	public double getPrice() {
		return price;
	}


	public double getTotalPrice() {
		return totalPrice;
	}

	public String getProductName() {
		return productName;
	}
	
	public void setOrderManagerId(String orderManagerId) {
		this.orderManagerId = orderManagerId;
		
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
		
	}


	public void setQuantity(double quantity) {
		this.quantity = quantity;
		
	}


	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
		
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
		
	}


	public void setSupplierAFM(String supplierAFM) {
		this.supplierAFM = supplierAFM;
		
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setStatus(int status) {
		this.status = status;
		
	}


	public void setPrice(double price) {
		this.price = price;
		
	}


	public void setTotalPrice(double totalprice) {
		this.totalPrice = totalprice;
		
	}


	public void setProductName(String productName) {
		this.productName = productName;
		
		
	}


	public void setProductId(String productid) {
		this.productId = productid;
		
	}


	public String getProductId() {
		return productId;
	}


	
	
}
