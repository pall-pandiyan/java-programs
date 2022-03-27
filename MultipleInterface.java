
interface FirstInterface {
    public void firstMethod();
}

interface SecondInterface {
    public void secondMethod();
}

class Demo implements FirstInterface, SecondInterface {
    public void firstMethod() {
        System.out.println("This is first method...");
    }
    public void secondMethod() {
        System.out.println("This is second method...");
    }
}

class MultipleInterface {
    public static void main(String[] args) {
        Demo dm = new Demo();
        dm.firstMethod();
        dm.secondMethod();
    }
}

// the output will be...
// This is first method...
// This is second method...