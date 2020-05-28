
public class Buyer {

	String name;
	String id;
	String AFM;
	String phoneNumber;

	public Buyer(String name,String id,String AFM,String phoneNumber) {
	
		this.name=name;
		this.id=id;
		this.AFM=AFM;
		this.phoneNumber=phoneNumber;
}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getAFM() {
		return AFM;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAFM(String aFM) {
		AFM = aFM;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
