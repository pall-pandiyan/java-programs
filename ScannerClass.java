import java.util.Scanner;

class ScannerClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scan.nextLine();

        System.out.println("Hello! "+name);
    }
}

// the output will be..
// Enter your name: 
// god   
// Hello! god