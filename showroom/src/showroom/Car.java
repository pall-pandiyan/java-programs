package showroom;

public class Car extends Vehicle{
	String color;
	int tyres;
	
	public Car(int cost, int milage, String color, int tyres) {
		super(cost,milage);
		this.color=color;
		this.tyres=tyres;
	}
	
	public void get_details() {
		super.get_details();
		System.out.println("Color of the Car: "+color);
		System.out.println("Number of tyres of the Car: "+tyres);
	}
}
