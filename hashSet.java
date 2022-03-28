import java.util.HashSet;

class hashSet {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("BMW");
        hs.add("Audi");
        hs.add("Benz");
        hs.add("Audi");
        hs.add("BMW");

        System.out.println(hs);
    }
}