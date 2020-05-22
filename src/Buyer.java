
public class Buyer {
	private String name;
	private String lastName;
	private String id;
	private String AFM;
	
	public Buyer(String name, String lastName, String id, String aFM) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		AFM = aFM;
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

	public String getAFM() {
		return AFM;
	}

	public void setAFM(String aFM) {
		AFM = aFM;
	}
	
	
	
	

}
