package src;

public class CompanyProduct {
<<<<<<< HEAD
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 5651c03fcced90b6825e5d0d1060347f454b4c8b
	String id;
	String name;
	double price;
	int safetystock;
	int stockamount;
	int maxStockAmount;
=======
	private String id;
	private String name;
	private double price;
	private double safetystock;
	private double stockamount;
	private double maxStockAmount;
>>>>>>> f6348febcdb2ec0db992e3097f5719282fbddbc3
	
	public CompanyProduct(String id,String name,double safetystock,double stockamount,double maxStockAmount,double price)
 {
	     this.id=id;
		 this.name=name;
		 //this.price=price;
		 this.safetystock=safetystock;
		 this.stockamount=stockamount;
		 this.maxStockAmount=maxStockAmount;
		 this.price = price;

<<<<<<< HEAD
=======
	
>>>>>>> origin/master
=======
>>>>>>> 5651c03fcced90b6825e5d0d1060347f454b4c8b
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
