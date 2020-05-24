
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
	private String stockkeeperId;
	
	public Order(String orderManagerId, String orderId, double quantity, String supplierId,
			String supplierName, String supplierAFM, String date, int status, double price, double totalPrice,
			String productName, String productId, String stockkeeperId) {
		this.orderManagerId = orderManagerId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierAFM = supplierAFM;
		this.date = date;
		this.status = status;
		this.price = price;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.productId = productId;
		this.stockkeeperId = stockkeeperId;
	}

	public String getOrderManagerId() {
		return orderManagerId;
	}

	public void setOrderManagerId(String orderManagerId) {
		this.orderManagerId = orderManagerId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAFM() {
		return supplierAFM;
	}

	public void setSupplierAFM(String supplierAFM) {
		this.supplierAFM = supplierAFM;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStockkeeperId() {
		return stockkeeperId;
	}

	public void setStockkeeperId(String stockkeeperId) {
		this.stockkeeperId = stockkeeperId;

	}
}
	
	


	