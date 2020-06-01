

public class CompanyProduct {
	/*CompanyProduct.java
	 * @author Vlasakoudi Christina
	 */
	private String name;
	private String id;
	private String sellerId;
	private double stockAmount;
	private double maxStockAmount;
	private double safetyStock;
	private double price;
	
	public CompanyProduct(String name, String id, String sellerId, double stockAmount, double maxStockAmount, double safetyStock,double price) {
		this.name = name;
		this.id = id;
		this.sellerId = sellerId;
		this.stockAmount = stockAmount;
		this.maxStockAmount = maxStockAmount;
		this.safetyStock = safetyStock;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public double getSafetyStock() {
		return safetystock;
	}
	public double getStockAmount() {
		return stockamount;
	}

	public double getMaxStockAmount() {
		return maxStockAmount;
	}
	public double getPrice(){
		return price;
	}
	public String getSellertId() {
		return sellerId;
	}
	


	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStockAmount(double stockAmount) {
		this.stockamount = stockAmount;
	}

	public void setMaxStockAmount(double maxStockAmount) {
		this.maxStockAmount = maxStockAmount;
	}

	public void setSafetyStock(double safetyStock) {
		this.safetystock = safetyStock;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setSellerId(String id) {
		this.sellerId = id;
	}	
}



