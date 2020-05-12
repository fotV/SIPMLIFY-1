
public class SupplierProduct {
	private String name;
	 private String id;
	 private int stockAmount;
	 private int maxStockAmount;
	 private int safetyStock;
	 private float averageÌonthlyConsumption;
	 private int leadtime;
	 private int expectedAmount;
	 
	 public SupplierProduct(String name,String id,int stockAmount,int maxStockAmount,
	 int safetyStock,float averageÌonthlyConsumption,int leadtime,int expectedAmount) 
	 {
		 this.name=name;
		 this.id=id;
		 this.stockAmount=stockAmount;
		 this.maxStockAmount=maxStockAmount;
		 this.safetyStock=safetyStock;
		 this.averageÌonthlyConsumption=averageÌonthlyConsumption;
		 this.leadtime=leadtime;
		 this.expectedAmount=expectedAmount;
      }

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public int getMaxStockAmount() {
		return maxStockAmount;
	}

	public int getSafetyStock() {
		return safetyStock;
	}

	public float getAverageÌonthlyConsumption() {
		return averageÌonthlyConsumption;
	}

	public int getLeadtime() {
		return leadtime;
	}

	public int getExpectedAmount() {
		return expectedAmount;
	}

	
	 
}
