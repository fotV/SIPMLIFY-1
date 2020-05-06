
public class CompanyProduct {
	String id;
	String name;
	double price;
	int safetystock;
	int stockamount;
	int maxStockAmount;
	
	public CompanyProduct(String id,String name,double price,int safetystock,int stockamount,int maxStockAmount)
 {
	     this.id=id;
		 this.name=name;
		 this.price=price;
		 this.safetystock=safetystock;
		 this.stockamount=stockamount;
		 this.maxStockAmount=maxStockAmount;

}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getSafetystock() {
		return safetystock;
	}

	public int getStockamount() {
		return stockamount;
	}

	public int getMaxStockAmount() {
		return maxStockAmount;
	}
	
}
