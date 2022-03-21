public class printMultiplesOfSix {
    public static void main(String[] args) {
        int end = 100;
        int mul = 6;

        for(int i=mul; i<end; i+=mul) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}