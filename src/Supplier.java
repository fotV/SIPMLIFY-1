package src;

public class Supplier {
	private String name;
	private String lastName;
	private String id;
	private String phoneNumber;
	private String AFM;
	private String orderManagerId;
	
	public Supplier(String name,String lastName,String id,String phoneNumber,String AFM,String orderManagerId){
		
		 this.name=name;
		 this.lastName = lastName;
		 this.id=id;
		 this.phoneNumber=phoneNumber;
		 this.AFM=AFM;
		 this.orderManagerId = orderManagerId;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAFM() {
		return AFM;
	}
	
	public String getOrderManagerId() {
		return orderManagerId;
	}
	
	public void setName(String name) {
		this.name = name;	
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
		
	}

	public void setId(String id) {
		this.id = id;
		
	}

	public void setPhoneNumber(String phonenumber) {
		this.phoneNumber = phonenumber;
		
	}

	public void setAFM(String afm) {
		this.AFM = afm;
		
	}
	public void setOrderManagerId(String orm) {
		this.orderManagerId = orm;
	}


}



