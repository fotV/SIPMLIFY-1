
public class SupplierProduct {
	private String name;
	private String id;
	private String orderManagerId;
	private double stockAmount;
	private double maxStockAmount;
	private double safetyStock;
	private double averageMonthlyConsumption;
	private int leadTime;
	private double expectedAmount;
	
	public SupplierProduct(String name, String id, String orderManagerId, double stockAmount, double maxStockAmount,
			double safetyStock, double averageMonthlyConsumption, int leadTime, double expectedAmount) {
		super();
		this.name = name;
		this.id = id;
		this.orderManagerId = orderManagerId;
		this.stockAmount = stockAmount;
		this.maxStockAmount = maxStockAmount;
		this.safetyStock = safetyStock;
		this.averageMonthlyConsumption = averageMonthlyConsumption;
		this.leadTime = leadTime;
		this.expectedAmount = expectedAmount;
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

	public String getOrderManagerId() {
		return orderManagerId;
	}

	public void setOrderManagerId(String orderManagerId) {
		this.orderManagerId = orderManagerId;
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

	public double getAverageMonthlyConsumption() {
		return averageMonthlyConsumption;
	}

	public void setAverageMonthlyConsumption(double averageMonthlyConsumption) {
		this.averageMonthlyConsumption = averageMonthlyConsumption;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	public double getExpectedAmount() {
		return expectedAmount;
	}

	public void setExpectedAmount(double expectedAmount) {
		this.expectedAmount = expectedAmount;
	}
	
	
	
	

}
