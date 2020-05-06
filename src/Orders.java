import java.util.ArrayList;

public class Orders extends ListFromDB {
	ArrayList <Order> orders = new ArrayList<>();

	public Orders () {
		
	//paradeigma gia na trexei
		
		Order o = new Order("Sampoo", "s1234", 1);
		Order o2 = new Order("Butter", "b1634", 0);
		Order o3 = new Order("Butter", "t1245", 0);
		Order o4 = new Order("Soap", "s1634", 3);
		Order o5 = new Order("Crisps", "p1765", 4);
		Order o6 = new Order("Eggs", "s1600", 1);
		Order o7 = new Order("Butter", "bt00", 2);

		orders.add(o);
		orders.add(o2);
		orders.add(o3);
		orders.add(o4);
		orders.add(o5);
		orders.add(o6);
		orders.add(o7);

	}
}
