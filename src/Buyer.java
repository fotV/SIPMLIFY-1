

public class Buyer {
	private String name;
	private String lastName;
	private String id;
	private String AFM;
	
	private String sellerId;

	
	public Buyer(String name,String lastName,String id,String AFM,String sellerId) {
	
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.AFM = AFM;
		
		this.sellerId = sellerId;
}

	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}

	public String getId() {
		return id;
	}

	public String getAFM() {
		return AFM;
	}

	
	public String getSellerId() {
		return sellerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;	
	}
	public void setId(String id) {
		this.id = id;	
	}
	public void setAFM(String afm) {
		this.AFM = afm;	
	}

	

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
		
	}
	

	
	


}


