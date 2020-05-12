
public class Order {

	String orderManagerId;
	String orderId;
	double quantity;
	String supplierId;
	String supplierName;
	String supplierAFM;
	String date;
	int status;
	double price;
	double totalPrice;
	
	
public Order(String orderManagerId,String orderId,double quantity,String supplierId,
       String supplierName,String supplierAFM,String date,int status,double price,double totalPrice) 
{
	 this.orderManagerId=orderManagerId;
	 this.orderId=orderId;
	 this.quantity=quantity;
	 this.supplierId=supplierId;
	 this.supplierName=supplierName;
     this.supplierAFM=supplierName;
	 this.date=date;
	 this.status=status;
	 this.price=price;
	 this.totalPrice=totalPrice;
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

}
