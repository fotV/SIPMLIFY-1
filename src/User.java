
public class User {
	private String firstName;
	private String surName;
	private String password;
	private String telephone;
	private String AFM;
	private String id;
	private String company;
	
	public User() {
		
	};
	
	public User(String firstName, String surName, String password, String telephone, String aFM, String id,
			String company) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.password = password;
		this.telephone = telephone;
		AFM = aFM;
		this.id = id;
		this.company = company;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAFM() {
		return AFM;
	}

	public void setAFM(String aFM) {
		AFM = aFM;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	

}
