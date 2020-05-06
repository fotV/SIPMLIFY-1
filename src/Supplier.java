
public class Supplier {
	String name;
	String id;
	String phoneNumber;
	String AFM;
	
	public Supplier(String name,String id,String phoneNumber,String AFM){
		
		 this.name=name;
		 this.id=id;
		 this.phoneNumber=phoneNumber;
		 this.AFM=AFM;
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


}
