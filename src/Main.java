
public class Main {

	

		public static void main(String[] args) {

		Users u = new Users();
		u.extractObjectDB();
		/*
		System.out.println(u.getUsers().get(8).getPassword());
			new LogginForm();
			*/
		Seller s = (Seller) u.getUsers().get(1);
		s.initializeLists();
			new SellerForm(s );
		}

	

	
}
