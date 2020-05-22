
public class CompanyProduct {
	private String name;
	private String id;
	private String sellerId;
	private double stockAmount;
	private double maxStockAmount;
	private double safetyStock;
	private double price;
	
	public CompanyProduct(String name, String id, String sellerId, double stockAmount, double maxStockAmount, double safetyStock,
			double price) {
		super();
		this.name = name;
		this.id = id;
		this.sellerId = sellerId;
		this.stockAmount = stockAmount;
		this.maxStockAmount = maxStockAmount;
		this.safetyStock = safetyStock;
		this.price = price;
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

	public String getSellerId() {
		return sellerId;
	}
	
	public void setSellerId(String id) {
		this.sellerId = id;
	}
	
	public double getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(double stockAmount) {
		this.stockAmount = stockAmount;
	}

	public double getMaxStockAmount() {
		return maxStockAmount;
	}

	public void setMaxStockAmount(double maxStockAmount) {
		this.maxStockAmount = maxStockAmount;
	}

	public double getSafetyStock() {
		return safetyStock;
	}

	public void setSafetyStock(double safetyStock) {
		this.safetyStock = safetyStock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	
	
	
	

}
