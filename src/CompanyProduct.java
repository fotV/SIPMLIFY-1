public class CompanyProduct {

	private String id;
	private String name;
	private double price;
	private double safetystock;
	private double stockamount;
	private double maxStockAmount;
	
	public CompanyProduct(String id,String name,double safetystock,double stockamount,double maxStockAmount,double price)
 {
	     this.id=id;
		 this.name=name;
		 //this.price=price;
		 this.safetystock=safetystock;
		 this.stockamount=stockamount;
		 this.maxStockAmount=maxStockAmount;
		 this.price = price;

}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSafetystock() {
		return safetystock;
	}

	public double getStockamount() {
		return stockamount;
	}

	public double getMaxStockAmount() {
		return maxStockAmount;
	}
	public double getPrice(){
		return price;
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
	
}