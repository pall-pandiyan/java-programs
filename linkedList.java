import java.util.LinkedList;
class linkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for (int i=0; i<5; i++) {
            ll.add(i);
        }
        System.out.println(ll);
    }
}