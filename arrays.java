public class arrays {
    public static void main(String[] args) {
//        int a1[][] = new int[10][10];
        int n = 10;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // a[i][j] = (i+j)%n;
                System.out.print((i+j)% n + " ");
            }
            System.out.print("\n");
        }
/*
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                System.out.print(a1[i][j] + " ");
            }
            System.out.print("\n");
        }
*/
    }
}
