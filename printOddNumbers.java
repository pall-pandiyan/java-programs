public class printOddNumbers {
    public static void main(String[] args) {
        int start=1;
        int end=100;

        for(int i=start; i<end; i=i+2) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}