package showroom;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the cost of the Vehicle: ");
		int cost= Integer.parseInt(scan.nextLine());
		
		System.out.print("Enter the milage of the Vehicle: ");
		int milage = Integer.parseInt(scan.nextLine());
		
		System.out.print("Enter the color of the Car: ");
		String color = scan.nextLine();
		
		System.out.print("Enter the number of tyres in the Car: ");
		int tyres = Integer.parseInt(scan.nextLine());
		
		Car c1 = new Car(cost,milage,color,tyres);
		c1.get_details();
	}
}
