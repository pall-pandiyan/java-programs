package showroom;

public class Vehicle {
	int cost;
	int milage;
	
	public Vehicle(int cost, int milage) {
		this.cost = cost;
		this.milage = milage;
	}
	
	public void get_details() {
		System.out.println("Cost of the Vehicle is "+cost);
		System.out.println("Milage of the Vehicle is "+milage);
	}
}
