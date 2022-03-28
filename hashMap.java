import java.util.HashMap;

class hashMap {
    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<String,String>();
        hm.put("England","London");
        hm.put("Germony","Berlin");
        System.out.println("Keys: " + hm.keySet());
        System.out.println("Values: " + hm.values());
    }
}