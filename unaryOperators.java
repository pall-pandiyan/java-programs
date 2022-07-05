public class unaryOperators {
    public static void main(String[] args) {
        int a=10, b=15, c=5;
        int result = a>b ? (a>c ? a : c) : (b>c ? b : c);
        System.out.println("a:" + a + " b:" + b + " c:" + c);
        System.out.println("The biggest value is " + result);
    }
}


// Sample:

// a:10 b:15 c:5
// The biggest value is 15