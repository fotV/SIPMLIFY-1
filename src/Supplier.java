
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


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAFM() {
		return AFM;
	}

	public void setAFM(String aFM) {
		AFM = aFM;
	}

	public String getOrderManagerId() {
		return orderManagerId;
	}

	public void setOrderManagerId(String orderManagerId) {
		this.orderManagerId = orderManagerId;
	}
	
	
	

	



}



