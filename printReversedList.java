import java.util.Scanner;

public class printReversedList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = Integer.parseInt(scan.nextLine());
        scan.close();
        
        for(int i=target; i>0; i--) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}